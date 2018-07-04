package com.pipwave.sdk.library.pipwavesdklibrary.pipwave;

import android.os.Parcel;
import android.os.Parcelable;

import com.pipwave.sdk.library.pipwavesdklibrary.pipwave.model.AddressInfo;
import com.pipwave.sdk.library.pipwavesdklibrary.pipwave.model.ApiOverride;
import com.pipwave.sdk.library.pipwavesdklibrary.pipwave.model.BuyerInfo;
import com.pipwave.sdk.library.pipwavesdklibrary.pipwave.model.ItemInfo;
import com.pipwave.sdk.library.pipwavesdklibrary.pipwave.model.SessionInfo;
import com.pipwave.sdk.library.pipwavesdklibrary.pipwave.model.SubtotalInfo;

import java.util.ArrayList;
import java.util.List;

public class Pipwave implements Parcelable{

    //required params
    private String signature;
    private String action;
    private String timestamp;
    private String api_key;
    private String txn_id;
    private String amount;
    private String currency_code;
    private BuyerInfo buyerInfo;

    //not required params
    private String shippingAmount;
    private String handlingAmount;
    private String taxExempted;
    private String shortDescription;
    private String preferredPayment;
    private String excludePayment;
    private String preferredCategory;

    //not required params object
    private List<ItemInfo> itemList;
    private List<SubtotalInfo> totalList;

    private AddressInfo shippingInfo;
    private AddressInfo billingInfo;

    private ApiOverride apiOverride;
    private SessionInfo sessionInfo;


    public static final Creator<Pipwave> CREATOR = new Creator<Pipwave>() {
        @Override
        public Pipwave createFromParcel(Parcel in) {
            return new Pipwave(in);
        }

        @Override
        public Pipwave[] newArray(int size) {
            return new Pipwave[size];
        }
    };

    public Pipwave(Parcel in) {

        signature = in.readString();
        action = in.readString();
        timestamp = in.readString();
        api_key = in.readString();
        txn_id = in.readString();
        amount = in.readString();
        currency_code = in.readString();
        buyerInfo = in.readParcelable(BuyerInfo.class.getClassLoader());

        shippingAmount = in.readString();
        handlingAmount = in.readString();
        taxExempted = in.readString();
        shortDescription = in.readString();
        preferredPayment = in.readString();
        excludePayment = in.readString();
        preferredCategory = in.readString();

        itemList = new ArrayList<>();
        in.readTypedList(itemList, ItemInfo.CREATOR);
        totalList = new ArrayList<>();
        in.readTypedList(totalList, SubtotalInfo.CREATOR);

        shippingInfo = in.readParcelable(AddressInfo.class.getClassLoader());
        billingInfo = in.readParcelable(AddressInfo.class.getClassLoader());
        apiOverride = in.readParcelable(ApiOverride.class.getClassLoader());
        sessionInfo = in.readParcelable(SessionInfo.class.getClassLoader());

    }

    public Pipwave(String signature, String action, String timestamp, String api_key,
                   String txn_id, String amount, String currency_code, BuyerInfo buyerInfo){

        this.signature = signature;
        this.action = action;
        this.timestamp = timestamp;
        this.api_key = api_key;
        this.txn_id = txn_id;
        this.amount = amount;
        this.currency_code = currency_code;
        this.buyerInfo = buyerInfo;

        //this.shippingAmount = shippingAmount;
        //this.handlingAmount = handlingAmount;
        //this.taxExempted = taxExempted;
        //this.shortDescription = shortDescription;
        //this.preferredPayment = preferredPayment;
        //this.excludePayment = excludePayment;
        //this.preferredCategory = preferredCategory;
        //this.itemList = itemList;
        //this.totalList = totalList;
        //this.billingInfo = billingInfo;
        //this.apiOverride = apiOverride;
        //this.sessionInfo = sessionInfo;
    }

    public Pipwave(String signature, String action, String timestamp, String api_key,
                   String txn_id, String amount, String currency_code, BuyerInfo buyerInfo,
                   AddressInfo shippingInfo){

        this.signature = signature;
        this.action = action;
        this.timestamp = timestamp;
        this.api_key = api_key;
        this.txn_id = txn_id;
        this.amount = amount;
        this.currency_code = currency_code;
        this.buyerInfo = buyerInfo;
        this.shippingInfo = shippingInfo;

    }

    public Pipwave(String signature, String action, String timestamp, String api_key,
                   String txn_id, String amount, String currency_code, BuyerInfo buyerInfo,
                   ApiOverride apiOverride){

        this.signature = signature;
        this.action = action;
        this.timestamp = timestamp;
        this.api_key = api_key;
        this.txn_id = txn_id;
        this.amount = amount;
        this.currency_code = currency_code;
        this.buyerInfo = buyerInfo;
        this.apiOverride = apiOverride;

    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getApi_key() {
        return api_key;
    }

    public void setApi_key(String api_key) {
        this.api_key = api_key;
    }

    public String getTxn_id() {
        return txn_id;
    }

    public void setTxn_id(String txn_id) {
        this.txn_id = txn_id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency_code() {
        return currency_code;
    }

    public void setCurrency_code(String currency_code) {
        this.currency_code = currency_code;
    }

    public BuyerInfo getBuyerInfo() {
        return buyerInfo;
    }

    public void setBuyerInfo(BuyerInfo buyerInfo) {
        this.buyerInfo = buyerInfo;
    }

    public List<ItemInfo> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemInfo> itemList) {
        this.itemList = itemList;
    }

    public List<SubtotalInfo> getTotalList() {
        return totalList;
    }

    public void setTotalList(List<SubtotalInfo> totalList) {
        this.totalList = totalList;
    }

    public AddressInfo getShippingInfo() {
        return shippingInfo;
    }

    public void setShippingInfo(AddressInfo shippingInfo) {
        this.shippingInfo = shippingInfo;
    }

    public AddressInfo getBillingInfo() {
        return billingInfo;
    }

    public void setBillingInfo(AddressInfo billingInfo) {
        this.billingInfo = billingInfo;
    }

    public ApiOverride getApiOverride() {
        return apiOverride;
    }

    public void setApiOverride(ApiOverride apiOverride) {
        this.apiOverride = apiOverride;
    }

    public SessionInfo getSessionInfo() {
        return sessionInfo;
    }

    public void setSessionInfo(SessionInfo sessionInfo) {
        this.sessionInfo = sessionInfo;
    }

    public String getShippingAmount() {
        return shippingAmount;
    }

    public void setShippingAmount(String shippingAmount) {
        this.shippingAmount = shippingAmount;
    }

    public String getHandlingAmount() {
        return handlingAmount;
    }

    public void setHandlingAmount(String handlingAmount) {
        this.handlingAmount = handlingAmount;
    }

    public String getTaxExempted() {
        return taxExempted;
    }

    public void setTaxExempted(String taxExempted) {
        this.taxExempted = taxExempted;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getPreferredPayment() {
        return preferredPayment;
    }

    public void setPreferredPayment(String preferredPayment) {
        this.preferredPayment = preferredPayment;
    }

    public String getExcludePayment() {
        return excludePayment;
    }

    public void setExcludePayment(String excludePayment) {
        this.excludePayment = excludePayment;
    }

    public String getPreferredCategory() {
        return preferredCategory;
    }

    public void setPreferredCategory(String preferredCategory) {
        this.preferredCategory = preferredCategory;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(signature);
        dest.writeString(action);
        dest.writeString(timestamp);
        dest.writeString(api_key);
        dest.writeString(txn_id);
        dest.writeString(amount);
        dest.writeString(currency_code);
        dest.writeParcelable(buyerInfo, flags);

        dest.writeString(shippingAmount);
        dest.writeString(handlingAmount);
        dest.writeString(taxExempted);
        dest.writeString(shortDescription);
        dest.writeString(preferredPayment);
        dest.writeString(excludePayment);
        dest.writeString(preferredCategory);

        dest.writeTypedList(itemList);
        dest.writeTypedList(totalList);

        dest.writeParcelable(shippingInfo, flags);
        dest.writeParcelable(billingInfo, flags);
        dest.writeParcelable(apiOverride, flags);
        dest.writeParcelable(sessionInfo, flags);

    }

    public String toString(){
        final StringBuilder sb = new StringBuilder();
        sb.append("signature=").append(signature);
        sb.append(", action=").append(action);
        sb.append(", timestamp=").append(timestamp);
        sb.append(", api_key=").append(api_key);
        sb.append(", txn_id=").append(txn_id);
        sb.append(", amount=").append(amount);
        sb.append(", currency_code=").append(currency_code);
        sb.append(", buyer_info=").append(buyerInfo);

        sb.append(", shipping_amount=").append(shippingAmount);
        sb.append(", handling_amount=").append(handlingAmount);
        sb.append(", tax_exempted_amount=").append(taxExempted);
        sb.append(", short_description=").append(shortDescription);
        sb.append(", prefered_payment=").append(preferredPayment);
        sb.append(", exclude_payment=").append(excludePayment);
        sb.append(", prefered_category=").append(preferredCategory);

        sb.append(", item_info=").append(itemList);
        sb.append(", subtotal_info=").append(totalList);

        sb.append(", shipping_info=").append(shippingInfo);
        sb.append(", billing_info=").append(billingInfo);
        sb.append(", api_override=").append(apiOverride);
        sb.append(", session_info=").append(sessionInfo);

        sb.append('}');
        return sb.toString();
    }

}
