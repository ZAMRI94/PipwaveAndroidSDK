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

    public ItemInfo(String itemName, String amount, String quantity,
                    String category, String sku){
        this.itemName = itemName;
        this.amount = amount;
        this.quantity = quantity;
        this.category = category;
        this.sku = sku;
    }

    public ItemInfo(String itemName, String description ,String amount, String quantity,
                    String category, String sku){
        this.itemName = itemName;
        this.description = description;
        this.amount = amount;
        this.quantity = quantity;
        this.category = category;
        this.sku = sku;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSku() {
        return sku;
    }

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

