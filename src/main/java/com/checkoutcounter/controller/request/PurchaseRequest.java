package com.checkoutcounter.controller.request;

/**
 * Created by Sanket Bhsukat on 11/12/2019.
 */
public class PurchaseRequest {

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String productName;
    public String quantity;
}
