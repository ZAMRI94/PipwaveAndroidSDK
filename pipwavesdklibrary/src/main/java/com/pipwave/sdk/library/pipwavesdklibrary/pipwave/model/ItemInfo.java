package com.pipwave.sdk.library.pipwavesdklibrary.pipwave.model;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemInfo implements Parcelable {

    private String itemName;
    private String description;
    private String amount;
    private String quantity;
    private String category;
    private String sku;

    public static final Creator<ItemInfo> CREATOR = new Creator<ItemInfo>() {
        @Override
        public ItemInfo createFromParcel(Parcel in) {
            return new ItemInfo(in);
        }

        @Override
        public ItemInfo[] newArray(int size) {
            return new ItemInfo[size];
        }
    };

    public ItemInfo(Parcel in) {
        itemName = in.readString();
        description = in.readString();
        amount = in.readString();
        quantity = in.readString();
        category = in.readString();
        sku = in.readString();
    }

    /**
     * @param itemName name
     * @param amount amount
     * @param quantity quantity
     * @param category category
     * @param sku sku
     */
    public ItemInfo(String itemName, String amount, String quantity,
                    String category, String sku){
        this.itemName = itemName;
        this.amount = amount;
        this.quantity = quantity;
        this.category = category;
        this.sku = sku;
    }

    /**
     * @param itemName name
     * @param description description
     * @param amount amount
     * @param quantity quantity
     * @param category category
     * @param sku sku
     */
    public ItemInfo(String itemName, String description ,String amount, String quantity,
                    String category, String sku){
        this.itemName = itemName;
        this.description = description;
        this.amount = amount;
        this.quantity = quantity;
        this.category = category;
        this.sku = sku;
    }

    /**
     * @return itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * set a new value for item_info itemName
     *
     * @param itemName itemName
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * set a new value for item_info description
     *
     * @param description description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * set a new value for item_info item's amount
     *
     * @param amount amount
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * @return quantity
     */
    public String getQuantity() {
        return quantity;
    }

    /**
     * set a new value for item_info item's quantity
     *
     * @param quantity quantity
     */
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    /**
     * @return category
     */
    public String getCategory() {
        return category;
    }

    /**
     * set a new value for item_info category
     *
     * @param category category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return sku
     */
    public String getSku() {
        return sku;
    }

    /**
     * set a new value for item_info item's sku
     *
     * @param sku sku
     */
    public void setSku(String sku) {
        this.sku = sku;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(itemName);
        dest.writeString(description);
        dest.writeString(amount);
        dest.writeString(quantity);
        dest.writeString(category);
        dest.writeString(sku);
    }

    public String toString(){
        final StringBuilder sb = new StringBuilder("item_info{");
        sb.append("name=").append(itemName);
        sb.append("description=").append(description);
        sb.append("amount=").append(amount);
        sb.append("quantity=").append(quantity);
        sb.append("category=").append(category);
        sb.append("sku=").append(sku);
        sb.append('}');
        return sb.toString();

    }
}

