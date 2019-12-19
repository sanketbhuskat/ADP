package com.checkoutcounter.controller.request;

import java.util.List;

/**
 * Created by Sanket Bhsukat on 11/12/2019.
 */
public class BillingRequest {

    public List<PurchaseRequest> getPurchase() {
        return purchase;
    }

    public void setPurchase(List<PurchaseRequest> purchase) {
        this.purchase = purchase;
    }

    private List<PurchaseRequest> purchase;
}
