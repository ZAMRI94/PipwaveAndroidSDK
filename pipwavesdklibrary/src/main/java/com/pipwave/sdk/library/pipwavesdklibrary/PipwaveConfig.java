package com.pipwave.sdk.library.pipwavesdklibrary;

public class PipwaveConfig {

    public static final String ACTION = "initiate-payment";

    public static final String API_PIPWAVE_PRODUCTION = "https://api.pipwave.com/payment";
    public static final String API_PIPWAVE_SANDBOX = "https://staging-api.pipwave.com/payment";

    public static final int ENVIRONMENT_SANDBOX = 0;
    public static final int ENVIRONMENT_PRODUCTION = 1;

    public static boolean DEBUG = false;

    private static int ENVIRONMENT = ENVIRONMENT_SANDBOX;

    public static void setEnvironment(int environment){
        ENVIRONMENT = environment;
    }

    public static int getEnvironment() {
        return ENVIRONMENT;
    }

}
