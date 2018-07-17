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
    private String api_secret;
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

    //Custom header html
    private String styles;
    private String headers;


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
        api_secret = in.readString();
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

        styles = in.readString();
        headers = in.readString();

    }

    /**
     * @param api_key api_key
     * @param api_secret api_secret
     * @param txn_id txn_id
     * @param amount amount
     * @param currency_code currency_code
     * @param buyerInfo buyer_info
     */
    public Pipwave(String api_key, String api_secret, String txn_id, String amount,
                   String currency_code, BuyerInfo buyerInfo){
        this.api_key = api_key;
        this.api_secret = api_secret;
        this.txn_id = txn_id;
        this.amount = amount;
        this.currency_code = currency_code;
        this.buyerInfo = buyerInfo;
    }

    /**
     * @param api_key api_key
     * @param api_secret api_secret
     * @param txn_id txn_id
     * @param amount amount
     * @param currency_code currency_code
     * @param buyerInfo buyer_info
     * @param shippingInfo shipping_info
     */
    public Pipwave(String api_key, String api_secret, String txn_id, String amount,
                   String currency_code, BuyerInfo buyerInfo, AddressInfo shippingInfo){
        this.api_key = api_key;
        this.api_secret = api_secret;
        this.txn_id = txn_id;
        this.amount = amount;
        this.currency_code = currency_code;
        this.buyerInfo = buyerInfo;
        this.shippingInfo = shippingInfo;

    }

    /**
     * @param api_key api_key
     * @param api_secret api_secret
     * @param txn_id txn_id
     * @param amount amount
     * @param currency_code currency_code
     * @param buyerInfo buyer_info
     * @param apiOverride api_override
     */
    public Pipwave(String api_key, String api_secret, String txn_id, String amount,
                   String currency_code, BuyerInfo buyerInfo, ApiOverride apiOverride){
        this.api_key = api_key;
        this.api_secret = api_secret;
        this.txn_id = txn_id;
        this.amount = amount;
        this.currency_code = currency_code;
        this.buyerInfo = buyerInfo;
        this.apiOverride = apiOverride;

    }

    /**
     * @return signature
     */
    public String getSignature() {
        return signature;
    }

    /**
     * set a new value for signature
     *
     * @param signature signature
     */
    public void setSignature(String signature) {
        this.signature = signature;
    }

    /**
     * @return action
     */
    public String getAction() {
        return action;
    }

    /**
     * set a new value for action
     *
     * @param action action
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * @return timestamp
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * set a new value for timestamp
     *
     * @param timestamp timestamp
     */
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * @return api_key
     */
    public String getApi_key() {
        return api_key;
    }

    /**
     * set a new value for api_key
     *
     * @param api_key api_key
     */
    public void setApi_key(String api_key) {
        this.api_key = api_key;
    }

    /**
     * @return api_secret
     */
    public String getApi_secret() {
        return api_secret;
    }

    /**
     * set a new value for api_secret
     *
     * @param api_secret api_secret
     */
    public void setApi_secret(String api_secret) {
        this.api_secret = api_secret;
    }

    /**
     * @return txn_id
     */
    public String getTxn_id() {
        return txn_id;
    }

    /**
     * set a new value for txn_id
     *
     * @param txn_id txn_id
     */
    public void setTxn_id(String txn_id) {
        this.txn_id = txn_id;
    }

    /**
     * @return amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * set a new value for amount
     *
     * @param amount amount
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * @return currency_code
     */
    public String getCurrency_code() {
        return currency_code;
    }

    /**
     * set a new value for currency_code
     *
     * @param currency_code currency_code
     */
    public void setCurrency_code(String currency_code) {
        this.currency_code = currency_code;
    }

    /**
     * @return buyer_info
     */
    public BuyerInfo getBuyerInfo() {
        return buyerInfo;
    }

    /**
     * set a new value for buyer_info
     *
     * @param buyerInfo buyer_info
     */
    public void setBuyerInfo(BuyerInfo buyerInfo) {
        this.buyerInfo = buyerInfo;
    }

    /**
     * @return itemList
     */
    public List<ItemInfo> getItemList() {
        return itemList;
    }

    /**
     * set a new value for item_List
     *
     * @param itemList list of item_info
     */
    public void setItemList(List<ItemInfo> itemList) {
        this.itemList = itemList;
    }

    /**
     * @return totalList
     */
    public List<SubtotalInfo> getTotalList() {
        return totalList;
    }

    /**
     * set a new value for total_list
     *
     * @param totalList list of subtotal_info
     */
    public void setTotalList(List<SubtotalInfo> totalList) {
        this.totalList = totalList;
    }

    /**
     * @return shipping_info
     */
    public AddressInfo getShippingInfo() {
        return shippingInfo;
    }

    /**
     * set a new value for shipping_info
     *
     * @param shippingInfo address shipping_info
     */
    public void setShippingInfo(AddressInfo shippingInfo) {
        this.shippingInfo = shippingInfo;
    }

    /**
     * @return billing_info
     */
    public AddressInfo getBillingInfo() {
        return billingInfo;
    }

    /**
     * set a new value for billing_info
     *
     * @param billingInfo address billing_info
     */
    public void setBillingInfo(AddressInfo billingInfo) {
        this.billingInfo = billingInfo;
    }

    /**
     * @return api_override
     */
    public ApiOverride getApiOverride() {
        return apiOverride;
    }

    /**
     * set a new value for api_override
     *
     * @param apiOverride api_override
     */
    public void setApiOverride(ApiOverride apiOverride) {
        this.apiOverride = apiOverride;
    }

    /**
     * @return session_info
     */
    public SessionInfo getSessionInfo() {
        return sessionInfo;
    }

    /**
     * set a new value for session_info
     *
     * @param sessionInfo session_info
     */
    public void setSessionInfo(SessionInfo sessionInfo) {
        this.sessionInfo = sessionInfo;
    }

    /**
     * @return shipping_amount
     */
    public String getShippingAmount() {
        return shippingAmount;
    }

    /**
     * set a new value for shipping_amount
     *
     * @param shippingAmount shipping_amount
     */
    public void setShippingAmount(String shippingAmount) {
        this.shippingAmount = shippingAmount;
    }

    /**
     * @return handlingAmount
     */
    public String getHandlingAmount() {
        return handlingAmount;
    }

    /**
     * set a new value for handling_amount
     *
     * @param handlingAmount handling_amount
     */
    public void setHandlingAmount(String handlingAmount) {
        this.handlingAmount = handlingAmount;
    }

    /**
     * @return taxExempted taxExempted
     */
    public String getTaxExempted() {
        return taxExempted;
    }

    /**
     * set a new value for taxExempted
     *
     * @param taxExempted tax_exempted_amount
     */
    public void setTaxExempted(String taxExempted) {
        this.taxExempted = taxExempted;
    }

    /**
     * @return shortDescription
     */
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     * set a new value for shortDescription
     *
     * @param shortDescription short_description
     */
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    /**
     * @return preferredPayment
     */
    public String getPreferredPayment() {
        return preferredPayment;
    }

    /**
     * set a new value for preferred_payment
     *
     * @param preferredPayment preferred_payment
     */
    public void setPreferredPayment(String preferredPayment) {
        this.preferredPayment = preferredPayment;
    }

    /**
     * @return excludePayment
     */
    public String getExcludePayment() {
        return excludePayment;
    }

    /**
     * set a new value for excludePayment
     *
     * @param excludePayment exclude_payment
     */
    public void setExcludePayment(String excludePayment) {
        this.excludePayment = excludePayment;
    }

    /**
     * @return preferredCategory
     */
    public String getPreferredCategory() {
        return preferredCategory;
    }

    /**
     * set a new value for preferredCategory
     *
     * @param preferredCategory preferred_category
     */
    public void setPreferredCategory(String preferredCategory) {
        this.preferredCategory = preferredCategory;
    }

    /**
     * @return styles
     */
    public String getStyles() {
        return styles;
    }

    /**
     * set a new value for styles
     *
     * @param styles styles css
     */
    public void setStyles(String styles) {
        this.styles = styles;
    }

    /**
     * @return headers
     */
    public String getHeaders() {
        return headers;
    }

    /**
     * set a new value for headers
     *
     * @param headers headers
     */
    public void setHeaders(String headers) {
        this.headers = headers;
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
        dest.writeString(api_secret);
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

        dest.writeString(styles);
        dest.writeString(headers);

    }

    public String toString(){
        final StringBuilder sb = new StringBuilder();
        sb.append("signature=").append(signature);
        sb.append(", action=").append(action);
        sb.append(", timestamp=").append(timestamp);
        sb.append(", api_key=").append(api_key);
        sb.append(", api_secret=").append(api_secret);
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

        sb.append(", styles=").append(styles);
        sb.append(", headers=").append(headers);

        sb.append('}');
        return sb.toString();
    }

}
