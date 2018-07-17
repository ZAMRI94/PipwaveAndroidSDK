package com.pipwave.sdk.library.pipwavesdklibrary.pipwave;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.pipwave.sdk.library.pipwavesdklibrary.common.utils.Preconditions;

public final class PipwaveCheckout  {

    private static final int CHECKOUT_REQUEST_CODE = 707;
    private String mClientKey;
    private PipwaveCheckoutCallback mCallback;

    /**
     * @param clientKey clientKey
     * @param callback callback
     */
    public PipwaveCheckout(String clientKey, PipwaveCheckoutCallback callback){
        mClientKey = clientKey;
        mCallback = Preconditions.checkNotNull(callback, "callback");
    }

    /**
     * execution for calling pipwave api
     *
     * @param activity activity
     * @param model model
     */
    public void execute(Activity activity, Pipwave model){
        Bundle checkoutBundle = new Bundle();
        checkoutBundle.putParcelable(PipwaveCheckoutActivity.EXTRAS_CHECKOUT, model);
        Intent intent = new Intent(activity, PipwaveCheckoutActivity.class);
        intent.putExtra(PipwaveCheckoutActivity.EXTRAS_CLIENT_KEY, mClientKey);
        intent.putExtra(PipwaveCheckoutActivity.EXTRAS_CHECKOUT_BUNDLE, checkoutBundle);
        activity.startActivityForResult(intent, CHECKOUT_REQUEST_CODE);
    }

    /**
     * call activity after Activity done
     *
     * @param requestCode requestCode
     * @param resultCode resultCode
     * @param data data
     */
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == CHECKOUT_REQUEST_CODE){
            switch (resultCode){
                case Activity.RESULT_OK:
                    mCallback.onCheckoutSuccess();
                    break;
                case Activity.RESULT_CANCELED:
                    mCallback.onCheckoutCanceled();
                    break;
                case PipwaveCheckoutActivity.RESULT_FAILURE:
                    String failureMessage = data.getStringExtra(
                            PipwaveCheckoutActivity.EXTRAS_FAILURE_MESSAGE);
                    mCallback.onCheckoutFailure(failureMessage);
                    break;
                default:
                    break;
            }
        }
    }
}
