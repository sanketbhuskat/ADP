package com.checkoutcounter.controller.request;

/**
 * Created by Sanket Bhsukat on 11/12/2019.
 */
public class ProductConfigureRequest {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    private String name;
    private String cost;
    private String category;
}
