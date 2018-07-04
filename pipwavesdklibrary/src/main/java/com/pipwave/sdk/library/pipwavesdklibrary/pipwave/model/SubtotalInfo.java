package com.pipwave.sdk.library.pipwavesdklibrary.pipwave.model;

import android.os.Parcel;
import android.os.Parcelable;

public class SubtotalInfo implements Parcelable {

    private String subtotalName;
    private String value;

    public static final Creator<SubtotalInfo> CREATOR = new Creator<SubtotalInfo>() {
        @Override
        public SubtotalInfo createFromParcel(Parcel in) {
            return new SubtotalInfo(in);
        }

        @Override
        public SubtotalInfo[] newArray(int size) {
            return new SubtotalInfo[size];
        }
    };

    public SubtotalInfo(Parcel in) {
        subtotalName = in.readString();
        value = in.readString();
    }

    public SubtotalInfo(String subtotalName, String value){
        this.subtotalName = subtotalName;
        this.value = value;
    }

    public String getSubtotalName() {
        return subtotalName;
    }

    public void setSubtotalName(String subtotalName) {
        this.subtotalName = subtotalName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(subtotalName);
        dest.writeString(value);
    }

    public String toString(){
        final StringBuilder sb = new StringBuilder("subtotal_info{");
        sb.append("name=").append(subtotalName);
        sb.append(", value=").append(value);
        sb.append('}');
        return sb.toString();
    }




}
