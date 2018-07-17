package com.pipwave.sdk.library.pipwavesdklibrary.pipwave.model;

import android.os.Parcel;
import android.os.Parcelable;

public class ApiOverride implements Parcelable{

    private String notification;
    private String success;
    private String fail;
    private String redirect1;
    private String redirect2;
    private String redirect3;
    private String notification1;
    private String notification2;
    private String notification3;

    public static final Creator<ApiOverride> CREATOR = new Creator<ApiOverride>() {
        @Override
        public ApiOverride createFromParcel(Parcel in) {
            return new ApiOverride(in);
        }

        @Override
        public ApiOverride[] newArray(int size) {
            return new ApiOverride[size];
        }
    };

    public ApiOverride(Parcel in) {
        notification = in.readString();
        success = in.readString();
        fail = in.readString();
        redirect1 = in.readString();
        redirect2 = in.readString();
        redirect3 = in.readString();
        notification1 = in.readString();
        notification2 = in.readString();
        notification3 = in.readString();
    }

    /**
     * @param notification notification_url
     * @param success success_url
     * @param fail fail_url
     */
    public ApiOverride(String notification, String success, String fail){
        this.notification = notification;
        this.success = success;
        this.fail = fail;
    }

    /**
     * @param notification notification_url
     * @param success success_url
     * @param fail fail_url
     * @param redirect1 redirect_extra_param1
     * @param notification1 notification_extra_param1
     */
    public ApiOverride(String notification, String success, String fail, String redirect1, String notification1){
        this.notification = notification;
        this.success = success;
        this.fail = fail;
        this.redirect1 = redirect1;
        this.notification1 = notification1;
    }

    /**
     * @param notification notification_url
     * @param success success_url
     * @param fail fail_url
     * @param redirect1 redirect_extra_param1
     * @param redirect2 redirect_extra_param2
     * @param redirect3 redirect_extra_param3
     * @param notification1 notification_extra_param1
     * @param notification2 notification_extra_param2
     * @param notification3 notification_extra_param3
     */
    public ApiOverride(String notification, String success, String fail, String redirect1, String redirect2, String redirect3, String notification1, String notification2, String notification3){
        this.notification = notification;
        this.success = success;
        this.fail = fail;
        this.redirect1 = redirect1;
        this.redirect2 = redirect2;
        this.redirect3 = redirect3;
        this.notification1 = notification1;
        this.notification2 = notification2;
        this.notification3 = notification3;
    }

    /**
     * @return notification
     */
    public String getNotification() {
        return notification;
    }

    /**
     * set a new value for notification_url
     *
     * @param notification notification_url
     */
    public void setNotification(String notification) {
        this.notification = notification;
    }

    /**
     * @return success
     */
    public String getSuccess() {
        return success;
    }

    /**
     * set a new value for success_url
     *
     * @param success success_url
     */
    public void setSuccess(String success) {
        this.success = success;
    }

    /**
     * @return fail
     */
    public String getFail() {
        return fail;
    }

    /**
     * @param fail fail_url
     */
    public void setFail(String fail) {
        this.fail = fail;
    }

    /**
     * @return redirect1
     */
    public String getRedirect1() {
        return redirect1;
    }

    /**
     * set a new value for redirect1
     *
     * @param redirect1 redirect_extra_param1
     */
    public void setRedirect1(String redirect1) {
        this.redirect1 = redirect1;
    }

    /**
     * @return redirect2
     */
    public String getRedirect2() {
        return redirect2;
    }

    /**
     * set a new value for redirect2
     *
     * @param redirect2 redirect_extra_param2
     */
    public void setRedirect2(String redirect2) {
        this.redirect2 = redirect2;
    }

    /**
     * @return redirect3
     */
    public String getRedirect3() {
        return redirect3;
    }

    /**
     * set a new value for redirect3
     *
     * @param redirect3 redirect_extra_param3
     */
    public void setRedirect3(String redirect3) {
        this.redirect3 = redirect3;
    }

    public String getNotification1() {
        return notification1;
    }

    /**
     * set a new value for notification1
     *
     * @param notification1 notification_extra_param1
     */
    public void setNotification1(String notification1) {
        this.notification1 = notification1;
    }

    public String getNotification2() {
        return notification2;
    }

    /**
     * set a new value for notification2
     *
     * @param notification2 notification_extra_param2
     */
    public void setNotification2(String notification2) {
        this.notification2 = notification2;
    }

    /**
     * @return notification3
     */
    public String getNotification3() {
        return notification3;
    }

    /**
     * set a net value for notification 3
     *
     * @param notification3 notification_extra_param3
     */
    public void setNotification3(String notification3) {
        this.notification3 = notification3;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(notification);
        dest.writeString(success);
        dest.writeString(fail);
        dest.writeString(redirect1);
        dest.writeString(redirect2);
        dest.writeString(redirect3);
        dest.writeString(notification1);
        dest.writeString(notification2);
        dest.writeString(notification3);
    }

    public String toString(){
        final StringBuilder sb = new StringBuilder("api_override{");
        sb.append("notification_url=").append(notification);
        sb.append(", success_url=").append(success);
        sb.append(", fail_url=").append(fail);
        sb.append(", redirect_extra_param1=").append(redirect1);
        sb.append(", redirect_extra_param2=").append(redirect2);
        sb.append(", redirect_extra_param3=").append(redirect3);
        sb.append(", notification_extra_param1=").append(notification1);
        sb.append(", notification_extra_param2=").append(notification2);
        sb.append(", notification_extra_param3=").append(notification3);
        sb.append('}');
        return sb.toString();
    }




}
