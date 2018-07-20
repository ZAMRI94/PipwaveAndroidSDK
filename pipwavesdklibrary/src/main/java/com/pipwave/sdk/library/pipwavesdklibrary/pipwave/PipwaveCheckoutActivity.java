package com.pipwave.sdk.library.pipwavesdklibrary.pipwave;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.pipwave.sdk.library.pipwavesdklibrary.PipwaveConfig;
import com.pipwave.sdk.library.pipwavesdklibrary.R;
import com.pipwave.sdk.library.pipwavesdklibrary.common.network.AndroidClient;
import com.pipwave.sdk.library.pipwavesdklibrary.common.network.Request;
import com.pipwave.sdk.library.pipwavesdklibrary.common.network.Response;
import com.pipwave.sdk.library.pipwavesdklibrary.common.utils.JSONUtils;
import com.pipwave.sdk.library.pipwavesdklibrary.common.utils.Preconditions;
import com.pipwave.sdk.library.pipwavesdklibrary.common.utils.Signature;
import com.pipwave.sdk.library.pipwavesdklibrary.pipwave.model.ApiOverride;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import static com.pipwave.sdk.library.pipwavesdklibrary.PipwaveConfig.ACTION;

public final class PipwaveCheckoutActivity extends Activity{

    public static final int RESULT_FAILURE = 1063;

    public static final String EXTRAS_CLIENT_KEY = "extras_client_key";
    public static final String EXTRAS_CHECKOUT = "extras_checkout";
    public static final String EXTRAS_CHECKOUT_BUNDLE = "extras_bundle";
    public static final String EXTRAS_FAILURE_MESSAGE = "extras_failure_message";

    private Pipwave mPipwave;
    private String mClientKey;
    private WebView mWebView;
    private ProgressBar mProgressBar;
    private String mSessionRedirectUrl;
    private String mSessionToken;
    private String mSessionCheckoutId;

    private String mimiType = "text/html";
    private String encoding = "UTF-8";

    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pipwave_checkout);

        Intent intent = getIntent();
        Preconditions.checkNotNull(intent, "Missing intent");

        Bundle bundle = intent.getBundleExtra(EXTRAS_CHECKOUT_BUNDLE);
        Preconditions.checkNotNull(bundle, "Missing bundle");

        mPipwave = bundle.getParcelable(EXTRAS_CHECKOUT);
        Preconditions.checkNotNull(mPipwave, "Missing object");

        mClientKey = intent.getStringExtra(EXTRAS_CLIENT_KEY);
        Preconditions.checkNotNull(mClientKey, "Missing client key");

        initialize();
        requestCreateCheckout();
    }

    @SuppressLint({"SetJavaScriptEnabled", "JavascriptInterface"})
    private void initialize() {

        mSessionRedirectUrl = "";
        mSessionToken = "";

        mProgressBar = findViewById(R.id.progress_bar);
        mWebView = findViewById(R.id.web_view);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setAllowFileAccess(true);
        mWebView.getSettings().setDomStorageEnabled(true);
        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //redirect||call when transaction done
                ApiOverride apiOverride = mPipwave.getApiOverride();
                if(url.startsWith(apiOverride.getSuccess())){
                    finishSuccess();
                    return true;
                }else if(url.startsWith(apiOverride.getNotification())){
                    finishCanceled();
                    return true;
                }else if(url.startsWith(apiOverride.getFail())){
                    finishFailure(apiOverride.getFail());
                    return true;
                }
                return super.shouldOverrideUrlLoading(view, url);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                //Hide ProgressBar after  7second  when mSessionToken or mSessionCheckoutId loaded
                if(url.contains(mSessionToken) || url.contains(mSessionCheckoutId)){
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            hideProgress();
                        }
                    },7000);
                }
                super.onPageFinished(view, url);
            }
        });
    }

    @SuppressLint("StaticFieldLeak")
    private void requestCreateCheckout() {

        new AsyncTask<Void, Void, Response>() {
            @Override
            protected Response doInBackground(Void... voids) {

                try {
                    //Initialize environment
                    Request request = new Request(Request.Method.POST, PipwaveConfig.getEnvironment()
                            == PipwaveConfig.ENVIRONMENT_PRODUCTION ?
                            PipwaveConfig.API_PIPWAVE_PRODUCTION :
                            PipwaveConfig.API_PIPWAVE_SANDBOX);

                    //generate timestamp
                    long time = System.currentTimeMillis()/1000L;
                    String timestamp = Long.toString(time);

                    //generate signature
                    String mSignature = "action:"+ ACTION + "amount:" + mPipwave.getAmount() + "api_key:" + mPipwave.getApi_key() + "api_secret:" + mPipwave.getApi_secret() + "currency_code:" + mPipwave.getCurrency_code() + "timestamp:" + timestamp + "txn_id:" + mPipwave.getTxn_id();
                    String signature = null;
                    try {
                        signature = Signature.SHA1(mSignature);
                    } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }

                    mPipwave.setSignature(signature);
                    mPipwave.setAction(ACTION);
                    mPipwave.setTimestamp(timestamp);

                    byte[] body = JSONUtils.toJSON(mPipwave).toString().getBytes();
                    request.setBody(body);

                    String key = mClientKey + ":";
                    String authorization = Base64.encodeToString(key.getBytes(), Base64.DEFAULT);

                    Map<String, String> headers = new HashMap<>();
                    headers.put("x-api-key", mPipwave.getApi_key());
                    headers.put("Content-Type", "application/json");
                    headers.put("Authorization", "Basic " + authorization);
                    headers.put("Content-Length", Integer.toString(body.length));
                    request.setHeaders(headers);

                    AndroidClient androidClient = new AndroidClient();
                    return androidClient.call(request);
                } catch (JSONException e) {
                    return new Response(-1, "");
                }
            }

            @JavascriptInterface
            @Override
            protected void onPostExecute(Response response) {
                if(response.getCode() == 200){
                    try {
                        JSONObject responseBody = new JSONObject(response.getResponse());

                        //get redirectUrl and token after api fire
                        mSessionRedirectUrl =responseBody.getString("redirect_url");
                        mSessionToken = responseBody.getString("token");

                        String[] redirectUrlParts = mSessionRedirectUrl.split("\\?");
                        mSessionCheckoutId = redirectUrlParts[redirectUrlParts.length - 1];
                        if(Build.MANUFACTURER.toLowerCase().contains("samsung")){
                            mSessionRedirectUrl += "&cssfix=true";
                        }

                        if(mPipwave.getStyles() == null){
                            mPipwave.setStyles("");
                        }
                        if(mPipwave.getHeaders() == null){
                            mPipwave.setHeaders("");
                        }

                        StringBuilder sb = new StringBuilder();
                        sb.append("<html>");
                        sb.append("<head>");
                        sb.append("<meta http-equiv=\"Content-Type\" content= \"text/html;charset=UTF-8\">");
                        sb.append(mPipwave.getStyles());
                        sb.append("<body>");
                        sb.append(mPipwave.getHeaders());
                        sb.append("<div id=\"pwscript\"></div>");
                        sb.append("<div class=\"pwarea\" id=\"pwarea\"></div>");
                        sb.append("<script type=\"text/javascript\">");
                        sb.append("var pwconfig = {\"api_key\":\"").append(mPipwave.getApi_key()).append("\",\"token\":\"").append(mSessionToken).append("\"};");
                        sb.append("(function (_, p, w, s, d, k) {");
                        sb.append("    var a = _.createElement(\"script\");");
                        sb.append("    a.setAttribute(\"data-main\", w + s);    a.setAttribute('src', w + d);");
                        sb.append("    a.setAttribute('id', k);");
                        sb.append("    setTimeout(function() {");
                        sb.append("        var reqPwInit = (typeof reqPipwave != 'undefined');");
                        sb.append("        if (reqPwInit) {");
                        sb.append("            reqPipwave.require(['pw'], function(pw) {");
                        sb.append("                pw.setOpt(pwconfig);");
                        sb.append("                pw.startLoad();");
                        sb.append("            });");
                        sb.append("        } else {");
                        sb.append("            _.getElementById(k).parentNode.replaceChild(a, _.getElementById(k));");
                        sb.append("        }");
                        sb.append("    }, 800);");
                        sb.append("})(document, 'script', \"https://staging-checkout.pipwave.com/sdk/\", \"pw.sdk.js\", \"lib/require.js\", \"pwscript\");");
                        sb.append("</script>");
                        sb.append("</body>");
                        sb.append("</html>");



                        //load Pipwave JS SDK in WebView
                        loadData(sb.toString(), mimiType, encoding);
                    } catch (JSONException e) {
                        finishFailure(e.getMessage());
                    }
                }else{
                    finishFailure(response.getResponse());
                }
            }
        }.execute();
    }

    //Call this when transaction success
    private void finishSuccess() {
        Intent intent = new Intent();
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    //Call this when transaction canceled
    private void finishCanceled() {
        Intent intent = new Intent();
        setResult(Activity.RESULT_CANCELED, intent);
        finish();
    }

    //Call this when transaction failure
    private void finishFailure(String message) {
        Intent intent = new Intent();
        intent.putExtra(EXTRAS_FAILURE_MESSAGE, message);
        setResult(RESULT_FAILURE, intent);
        finish();
    }

    //webview load data
    @JavascriptInterface
    private void loadData(String url, String mimiType, String encoding) {
        mWebView.loadData(url,mimiType, encoding);
    }

    //show ProgressBar
    public void showProgress(){
        mProgressBar.setVisibility(View.VISIBLE);
    }

    //hide ProgressBar
    private void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
    }

    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
    }

}
