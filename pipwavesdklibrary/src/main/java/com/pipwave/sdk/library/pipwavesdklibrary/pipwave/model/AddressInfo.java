package com.pipwave.sdk.library.pipwavesdklibrary.pipwave.model;

import android.os.Parcel;
import android.os.Parcelable;

public class AddressInfo implements Parcelable{
    private String name;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String country_iso2;
    private String contact_no;
    private String contact_iso2;
    private String email;

    public static final Creator<AddressInfo> CREATOR = new Creator<AddressInfo>() {
        @Override
        public AddressInfo createFromParcel(Parcel in) {
            return new AddressInfo(in);
        }

        @Override
        public AddressInfo[] newArray(int size) {
            return new AddressInfo[size];
        }
    };

    /**
     * @param name name
     * @param address1 address line1
     * @param address2 address line2
     * @param city city
     * @param state state
     * @param zip zip
     * @param country country
     * @param contact_no contact_no
     * @param email email
     */
    public AddressInfo(String name, String address1, String address2, String city, String state,
                       String zip, String country, String contact_no, String email){

        this.name = name;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
        this.contact_no = contact_no;
        this.email = email;
    }

    /**
     * @param name name
     * @param address1 address line1
     * @param address2 address line2
     * @param city city
     * @param state state
     * @param zip zip
     * @param country country
     * @param country_iso2 country_iso2
     * @param contact_no contact_no
     * @param contact_iso2 contact_no_country_iso2
     * @param email email
     */
    public AddressInfo(String name, String address1, String address2, String city, String state,
                       String zip, String country, String country_iso2, String contact_no, String contact_iso2,
                       String email){

        this.name = name;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
        this.country_iso2 = country_iso2;
        this.contact_no = contact_no;
        this.contact_iso2 = contact_iso2;
        this.email = email;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * set value for name
     *
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return address1
     */
    public String getAddress1() {
        return address1;
    }

    /**
     * set a new value for address1
     *
     * @param address1 address line1
     */
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    /**
     * @return address2
     */
    public String getAddress2() {
        return address2;
    }

    /**
     * set a new value for address2
     *
     * @param address2 address line2
     */
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    /**
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * set a new value for city
     *
     * @param city city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * set a new value for state
     *
     * @param state state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * set a new value for zip
     *
     * @param zip zip
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * @return country
     */
    public String getCountry() {
        return country;
    }

    /**
     * set a new value for country
     *
     * @param country country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return country_iso2
     */
    public String getCountry_iso2() {
        return country_iso2;
    }

    /**
     * set a new value for country_iso2
     *
     * @param country_iso2 country_iso2
     */
    public void setCountry_iso2(String country_iso2) {
        this.country_iso2 = country_iso2;
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
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * set a new value for email
     *
     * @param email email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public AddressInfo(Parcel in) {
        name = in.readString();
        address1 = in.readString();
        address2 = in.readString();
        city = in.readString();
        state = in.readString();
        zip = in.readString();
        country = in.readString();
        country_iso2 = in.readString();
        contact_no = in.readString();
        contact_iso2 = in.readString();
        email = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(address1);
        dest.writeString(address2);
        dest.writeString(city);
        dest.writeString(state);
        dest.writeString(zip);
        dest.writeString(country);
        dest.writeString(country_iso2);
        dest.writeString(contact_no);
        dest.writeString(contact_iso2);
        dest.writeString(email);
    }

    public String toString(){
        final StringBuilder sb = new StringBuilder("address_info{");
        sb.append("name=").append(name);
        sb.append(", address1=").append(address1);
        sb.append(", address2=").append(address2);
        sb.append(", city=").append(city);
        sb.append(", state=").append(state);
        sb.append(", zip=").append(zip);
        sb.append(", country=").append(country);
        sb.append(", country_iso2=").append(country_iso2);
        sb.append(", contact_no=").append(contact_no);
        sb.append(", contact_no_country_iso2=").append(contact_iso2);
        sb.append(", email=").append(email);
        return sb.toString();
    }
}

