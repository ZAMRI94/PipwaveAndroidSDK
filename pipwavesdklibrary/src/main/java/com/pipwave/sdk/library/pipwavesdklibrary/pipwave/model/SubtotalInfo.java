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

    /**
     * @param subtotalName name
     * @param value value
     */
    public SubtotalInfo(String subtotalName, String value){
        this.subtotalName = subtotalName;
        this.value = value;
    }

    /**
     * @return subtotalName
     */
    public String getSubtotalName() {
        return subtotalName;
    }

    /**
     * set a new value for subtotal_info item's name
     *
     * @param subtotalName name
     */
    public void setSubtotalName(String subtotalName) {
        this.subtotalName = subtotalName;
    }

    /**
     * @return value
     */
    public String getValue() {
        return value;
    }

    /**
     * set a new value for subtotal_info item's value
     *
     * @param value value
     */
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
