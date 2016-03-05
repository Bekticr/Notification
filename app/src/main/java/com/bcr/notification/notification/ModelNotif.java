package com.bcr.notification.notification;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Win7 on 03/03/2016.
 */
public class ModelNotif {

    @SerializedName("id_order")
    @Expose
    public int idOrder;
    @SerializedName("id_customer")
    @Expose
    public int idCustomer;
}