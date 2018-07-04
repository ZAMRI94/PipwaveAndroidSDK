package com.pipwave.sdk.library.pipwavesdklibrary.pipwave.model;

import android.os.Parcel;
import android.os.Parcelable;

public class SessionInfo implements Parcelable{

    private String ipAddress;
    private String sessionId;
    private String language;

    public static final Creator<SessionInfo> CREATOR = new Creator<SessionInfo>() {
        @Override
        public SessionInfo createFromParcel(Parcel in) {
            return new SessionInfo(in);
        }

        @Override
        public SessionInfo[] newArray(int size) {
            return new SessionInfo[size];
        }
    };

    public SessionInfo(Parcel in) {
        ipAddress = in.readString();
        sessionId = in.readString();
        language = in.readString();
    }

    public SessionInfo(String ipAddress, String sessionId, String language){
        this.ipAddress = ipAddress;
        this.sessionId = sessionId;
        this.language = language;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(ipAddress);
        dest.writeString(sessionId);
        dest.writeString(language);
    }

    public String toString(){
        final StringBuilder sb = new StringBuilder("session_info{");
        sb.append("ip_address=").append(ipAddress);
        sb.append("session_id=").append(sessionId);
        sb.append("language=").append(language);
        sb.append('}');
        return sb.toString();
    }



}
