package com.pipwave.android.sdk.pipwaveandroidsdk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.pipwave.sdk.library.pipwavesdklibrary.PipwaveConfig;
import com.pipwave.sdk.library.pipwavesdklibrary.common.utils.RandomString;
import com.pipwave.sdk.library.pipwavesdklibrary.pipwave.Pipwave;
import com.pipwave.sdk.library.pipwavesdklibrary.pipwave.PipwaveCheckout;
import com.pipwave.sdk.library.pipwavesdklibrary.pipwave.PipwaveCheckoutCallback;
import com.pipwave.sdk.library.pipwavesdklibrary.pipwave.model.ApiOverride;
import com.pipwave.sdk.library.pipwavesdklibrary.pipwave.model.BuyerInfo;

import java.math.BigDecimal;

import static com.pipwave.android.sdk.pipwaveandroidsdk.Config.API_STAGING_KEY;
import static com.pipwave.android.sdk.pipwaveandroidsdk.Config.API_STAGING_SECRET;
import static com.pipwave.android.sdk.pipwaveandroidsdk.Config.CANCEL_URL_PIPWAVE;
import static com.pipwave.android.sdk.pipwaveandroidsdk.Config.FAILURE_URL_PIPWAVE;
import static com.pipwave.android.sdk.pipwaveandroidsdk.Config.HEADERS;
import static com.pipwave.android.sdk.pipwaveandroidsdk.Config.STYLES;
import static com.pipwave.android.sdk.pipwaveandroidsdk.Config.SUCCESS_URL_PIPWAVE;

public class MainActivity extends AppCompatActivity implements PipwaveCheckoutCallback {

    private PipwaveCheckout mPipwaveCheckout;
    private BuyerInfo buyerInfo;
    private ApiOverride apiOverride;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PipwaveConfig.setEnvironment(PipwaveConfig.ENVIRONMENT_SANDBOX);
        mPipwaveCheckout = new PipwaveCheckout(API_STAGING_KEY, this);
    }

    public void onClick(View view) {

        buyer();
        apiOverride();

        RandomString randomString = new RandomString();
        String txn_id = randomString.nextString();

        BigDecimal mAmount = new BigDecimal("10");
        String amount = mAmount.toString();
        String currency_code = "MYR";

        Pipwave pipwave = new Pipwave(API_STAGING_KEY, API_STAGING_SECRET, txn_id, amount, currency_code, buyerInfo, apiOverride);
        pipwave.setHeaders(HEADERS);
        pipwave.setStyles(STYLES);
        mPipwaveCheckout.execute(this, pipwave);
    }

    private void buyer() {
       buyerInfo = new BuyerInfo("USER007", "zamri.yusof@dpodium.com");
    }

    private void apiOverride() {
        apiOverride = new ApiOverride(CANCEL_URL_PIPWAVE, SUCCESS_URL_PIPWAVE, FAILURE_URL_PIPWAVE);
    }

    @Override
    public void onCheckoutSuccess() {
        Toast.makeText(this, "Payment Success", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCheckoutCanceled() {
        Toast.makeText(this, "Payment Canceled", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCheckoutFailure(String message) {
        Toast.makeText(this, "Payment Fail : " + message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mPipwaveCheckout.onActivityResult(requestCode, resultCode, data);
    }
}
