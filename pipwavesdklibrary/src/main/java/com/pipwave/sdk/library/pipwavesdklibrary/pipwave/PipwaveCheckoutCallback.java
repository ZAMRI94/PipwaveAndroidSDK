package com.pipwave.sdk.library.pipwavesdklibrary.pipwave;

public interface PipwaveCheckoutCallback {

    void onCheckoutSuccess();
    void onCheckoutCanceled();
    void onCheckoutFailure(String message);
}
