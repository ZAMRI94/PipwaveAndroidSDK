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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry_iso2() {
        return country_iso2;
    }

    public void setCountry_iso2(String country_iso2) {
        this.country_iso2 = country_iso2;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public String getContact_iso2() {
        return contact_iso2;
    }

    public void setContact_iso2(String contact_iso2) {
        this.contact_iso2 = contact_iso2;
    }

    public String getEmail() {
        return email;
    }

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

