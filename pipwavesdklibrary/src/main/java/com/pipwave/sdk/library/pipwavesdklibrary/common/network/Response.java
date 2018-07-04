package com.pipwave.sdk.library.pipwavesdklibrary.common.network;

public class Response {

    private int code;

    private String response;

    public Response(int code, String response) {
        this.code = code;
        this.response = response;
    }

    public int getCode() {
        return code;
    }

    public String getResponse() {
        return response;
    }
}
