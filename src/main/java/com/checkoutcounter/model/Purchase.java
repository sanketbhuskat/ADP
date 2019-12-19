package com.checkoutcounter.model;

import javax.persistence.*;

/**
 * Created by Sanket Bhsukat on 11/12/2019.
 */
@Entity
public class Purchase {

    public Purchase(){

    }

    public void setPurchaseCost(double purchaseCost) {
        this.purchaseCost = purchaseCost;
    }

    public void setPurchaseSalesTax(double purchaseSalesTax) {
        this.purchaseSalesTax = purchaseSalesTax;
    }

    private double purchaseCost;
    private double purchaseSalesTax;

 /*   @Override
    public String toString() {
        return "Purchase{" +
                "product=" + product +
                ", quantity=" + quantity +
                ", bills=" + bills +
                ", id=" + id +
                '}';
    }*/

    private Product product;
    private double quantity;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "product_id")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    private int id;

    public Purchase(Product product, double quantity) {
        this.product = product;
        this.quantity = quantity;
        this.purchaseCost=product.getCost()*quantity;
        this.purchaseSalesTax=product.getSalesTax()*quantity;
    }


    public double getPurchaseCost() {
        return purchaseCost;
    }

    public double getPurchaseSalesTax() {
        return purchaseSalesTax;
    }

}
