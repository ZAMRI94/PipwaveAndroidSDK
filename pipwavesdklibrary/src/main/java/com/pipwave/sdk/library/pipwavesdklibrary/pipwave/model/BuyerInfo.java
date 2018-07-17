package com.pipwave.sdk.library.pipwavesdklibrary.pipwave.model;

import android.os.Parcel;
import android.os.Parcelable;


public class BuyerInfo implements Parcelable{

    private String id;
    private String email;

    private String first_name;
    private String last_name;
    private String contact_no;

    private String contact_iso2;
    private String contact_code;
    private String country_code;
    private String processing_fee;

    public static final Creator<BuyerInfo> CREATOR = new Creator<BuyerInfo>() {
        @Override
        public BuyerInfo createFromParcel(Parcel in) {
            return new BuyerInfo(in);
        }

        @Override
        public BuyerInfo[] newArray(int size) {
            return new BuyerInfo[size];
        }
    };

    public BuyerInfo(Parcel in) {
        id = in.readString();
        email = in.readString();

        first_name = in.readString();
        last_name = in.readString();
        contact_no = in.readString();

        contact_iso2 = in.readString();
        contact_code = in.readString();
        country_code = in.readString();
        processing_fee = in.readString();
    }

    /**
     * @param id id
     * @param email email
     */
    public BuyerInfo(String id, String email){
        this.id = id;
        this.email = email;
    }

    /**
     * @param id id
     * @param email email
     * @param first_name first_name
     * @param last_name last_name
     * @param contact_no contact_no
     */
    public BuyerInfo(String id, String email, String first_name, String last_name, String contact_no) {
        this.id = id;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.contact_no = contact_no;
    }

    /**
     * @param id id
     * @param email email
     * @param first_name first_name
     * @param last_name last_name
     * @param contact_no contact_no
     * @param processing_fee processing_fee_group
     */
    public BuyerInfo(String id, String email, String first_name, String last_name, String contact_no,
                     String processing_fee){
        this.id = id;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.contact_no = contact_no;
        this.processing_fee = processing_fee;
    }

    /**
     * @param id id
     * @param email email
     * @param first_name first_name
     * @param last_name last_name
     * @param contact_no contact_no
     * @param contact_iso2 contact_no_country_iso2
     * @param contact_code contact_no_country_code
     * @param country_code country_code
     * @param processing_fee processing_fee_group
     */
    public BuyerInfo(String id, String email, String first_name, String last_name, String contact_no,
                     String contact_iso2, String contact_code, String country_code, String processing_fee){
        this.id = id;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.contact_no = contact_no;
        this.contact_iso2 = contact_iso2;
        this.contact_code = contact_code;
        this.country_code = country_code;
        this.processing_fee = processing_fee;
    }


    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * set a new value for buyer_info id
     *
     * @param id id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * set a new value for buyer_info email
     *
     * @param email email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return first_name
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * set a new value for first_name
     *
     * @param first_name first_name
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /**
     * @return last_name
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * set a new value for last_name
     *
     * @param last_name last_name
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    /**
     * @return contact_no
     */
    public String getContact_no() {
        return contact_no;
    }

    /**
     * set a new value for contact_no
     *
     * @param contact_no contact_no
     */
    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    /**
     * @return contact_iso2
     */
    public String getContact_iso2() {
        return contact_iso2;
    }

    /**
     * set a new value for contact_iso2
     *
     * @param contact_iso2 contact_no_country_iso2
     */
    public void setContact_iso2(String contact_iso2) {
        this.contact_iso2 = contact_iso2;
    }

    /**
     * @return contact_code
     */
    public String getContact_code() {
        return contact_code;
    }

    /**
     * set a new value for contact_code
     *
     * @param contact_code contact_no_country_code
     */
    public void setContact_code(String contact_code) {
        this.contact_code = contact_code;
    }

    /**
     * @return country_code
     */
    public String getCountry_code() {
        return country_code;
    }

    /**
     * set a new code for country_code
     *
     * @param country_code country_code
     */
    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    /**
     * @return processing_fee
     */
    public String getProcessing_fee() {
        return processing_fee;
    }

    /**
     * set a new value for processing_fee
     *
     * @param processing_fee processing_fee_group
     */
    public void setProcessing_fee(String processing_fee) {
        this.processing_fee = processing_fee;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(email);

        dest.writeString(first_name);
        dest.writeString(last_name);
        dest.writeString(contact_no);

        dest.writeString(contact_iso2);
        dest.writeString(contact_code);
        dest.writeString(country_code);
        dest.writeString(processing_fee);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String toString(){
        final StringBuilder sb = new StringBuilder("buyer_info{");
        sb.append("id=").append(id);
        sb.append(", email=").append(email);

        sb.append(", first_name=").append(first_name);
        sb.append(", last_name=").append(last_name);
        sb.append(", contact_no=").append(contact_no);

        sb.append(", contact_no_country_iso2=").append(contact_iso2);
        sb.append(", contact_no_country_code=").append(contact_code);
        sb.append(", country_code=").append(country_code);
        sb.append(", processing_fee_group=").append(processing_fee);

        sb.append('}');
        return sb.toString();

    }
}
