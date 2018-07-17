package com.pipwave.sdk.library.pipwavesdklibrary.common.utils;

import com.pipwave.sdk.library.pipwavesdklibrary.pipwave.Pipwave;
import com.pipwave.sdk.library.pipwavesdklibrary.pipwave.model.AddressInfo;
import com.pipwave.sdk.library.pipwavesdklibrary.pipwave.model.ApiOverride;
import com.pipwave.sdk.library.pipwavesdklibrary.pipwave.model.BuyerInfo;
import com.pipwave.sdk.library.pipwavesdklibrary.pipwave.model.ItemInfo;
import com.pipwave.sdk.library.pipwavesdklibrary.pipwave.model.SessionInfo;
import com.pipwave.sdk.library.pipwavesdklibrary.pipwave.model.SubtotalInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public final class JSONUtils {

    private JSONUtils() {
        throw new RuntimeException("Cannot create instance of this class");
    }

    public static JSONObject toJSON(Pipwave pipwave)throws  JSONException{
        JSONObject root = new JSONObject();
        //required params
        root.put("signature", pipwave.getSignature());
        root.put("action", pipwave.getAction());
        root.put("timestamp", pipwave.getTimestamp());
        root.put("api_key", pipwave.getApi_key());
        root.put("api_secret", pipwave.getApi_secret());
        root.put("txn_id", pipwave.getTxn_id());
        root.put("amount", pipwave.getAmount());
        root.put("currency_code", pipwave.getCurrency_code());
        root.put("buyer_info",toJSON(pipwave.getBuyerInfo()));

        //not require params
        root.put("shipping_amount", pipwave.getShippingAmount());
        root.put("handling_amount", pipwave.getHandlingAmount());
        root.put("tax_exempted_amount", pipwave.getTaxExempted());
        root.put("short_description", pipwave.getShortDescription());
        root.put("prefered_payment", pipwave.getPreferredPayment());
        root.put("exclude_payment", pipwave.getExcludePayment());
        root.put("prefered_category", pipwave.getPreferredCategory());

        //not require params object
        root.put("item_info", toJSON(pipwave.getItemList()));
        root.put("subtotal_info", toJSON1(pipwave.getTotalList()));
        root.put("shipping_info", toJSON(pipwave.getShippingInfo()));
        root.put("billing_info", toJSON(pipwave.getBillingInfo()));
        root.put("api_override", toJSON(pipwave.getApiOverride()));
        root.put("session_info", toJSON(pipwave.getSessionInfo()));
        return root;
    }


    private static JSONObject toJSON(BuyerInfo buyerInfo)throws  JSONException {
        if (buyerInfo != null) {
            JSONObject root = new JSONObject();
            root.put("id", buyerInfo.getId());
            root.put("email", buyerInfo.getEmail());

            root.put("first_name", buyerInfo.getFirst_name());
            root.put("last_name", buyerInfo.getLast_name());
            root.put("contact_no", buyerInfo.getContact_no());

            root.put("contact_no_country_iso2", buyerInfo.getContact_iso2());
            root.put("contact_no_country_code", buyerInfo.getContact_code());
            root.put("country_code", buyerInfo.getCountry_code());
            root.put("processing_fee_group", buyerInfo.getProcessing_fee());
            return root;
        }
        return null;
    }

    private static JSONObject toJSON(AddressInfo addressInfo)throws JSONException{
        if(addressInfo != null){
            JSONObject root = new JSONObject();
            root.put("name", addressInfo.getName());
            root.put("address1", addressInfo.getAddress1());
            root.put("address2", addressInfo.getAddress2());
            root.put("city", addressInfo.getCity());
            root.put("state", addressInfo.getState());
            root.put("zip", addressInfo.getZip());
            root.put("country", addressInfo.getCountry());
            root.put("country_iso2", addressInfo.getCountry_iso2());
            root.put("contact_no", addressInfo.getContact_no());
            root.put("contact_no_country_iso2", addressInfo.getContact_iso2());
            root.put("email", addressInfo.getEmail());
            return root;
        }
        return null;
    }

    private static JSONObject toJSON(ItemInfo itemInfo)throws  JSONException{
        if(itemInfo != null){
            JSONObject root = new JSONObject();
            root.put("name", itemInfo.getItemName());
            root.put("description", itemInfo.getDescription());
            root.put("amount", itemInfo.getAmount());
            root.put("quantity", itemInfo.getQuantity());
            root.put("category", itemInfo.getCategory());
            root.put("sku", itemInfo.getSku());
            return root;
        }
        return null;
    }

    private static JSONArray toJSON(List<ItemInfo> itemList)throws JSONException{
        if(itemList != null && itemList.size() > 0){
            JSONArray array = new JSONArray();
            for(ItemInfo itemInfo : itemList){
                array.put(toJSON(itemInfo));
            }
            return array;
        }
        return null;
    }

    private static JSONObject toJSON(SubtotalInfo subtotalInfo)throws  JSONException{
        if(subtotalInfo != null){
            JSONObject root = new JSONObject();
            root.put("name",subtotalInfo.getSubtotalName());
            root.put("value", subtotalInfo.getSubtotalName());
            return root;
        }
        return null;
    }

    private static JSONArray toJSON1(List<SubtotalInfo> totalList)throws JSONException{
        if(totalList != null && totalList.size() > 0){
            JSONArray array = new JSONArray();
            for(SubtotalInfo subtotalInfo :totalList){
                array.put(toJSON(subtotalInfo));
            }
            return array;
        }
        return null;
    }

    private static JSONObject toJSON(ApiOverride apiOverride)throws JSONException{
        if(apiOverride != null){
            JSONObject root = new JSONObject();
            root.put("notification_url", apiOverride.getNotification());
            root.put("success_url", apiOverride.getSuccess());
            root.put("fail_url", apiOverride.getFail());
            root.put("redirect_extra_param1", apiOverride.getRedirect1());
            root.put("redirect_extra_param2", apiOverride.getRedirect2());
            root.put("redirect_extra_param3", apiOverride.getRedirect3());
            root.put("notification_extra_param1", apiOverride.getNotification1());
            root.put("notification_extra_param2", apiOverride.getNotification2());
            root.put("notification_extra_param3", apiOverride.getNotification3());
            return root;
        }
        return null;
    }

    private static JSONObject toJSON(SessionInfo sessionInfo)throws JSONException{
        if(sessionInfo != null){
            JSONObject root = new JSONObject();
            root.put("ip_address", sessionInfo.getIpAddress());
            root.put("session_id", sessionInfo.getSessionId());
            root.put("language", sessionInfo.getLanguage());
            return root;
        }
        return null;
    }

}
