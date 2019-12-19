package com.checkoutcounter.model;

import javax.persistence.*;
import java.util.Iterator;
import java.util.Set;
/**
 * Created by Sanket Bhsukat on 11/12/2019.
 */
@Entity
public class Bill {
    public Bill(){

    }

  /*  @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", totalCost=" + totalCost +
                ", totalSaleTax=" + totalSaleTax +
                ", purchases=" + purchases +
                '}';
    }*/

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public void setTotalSaleTax(double totalSaleTax) {
        this.totalSaleTax = totalSaleTax;
    }

    private int id;
    private double totalCost;
    private double totalSaleTax;
    private Set<Purchase> purchases;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public double getTotalSaleTax() {
        return totalSaleTax;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "bill_purchase", joinColumns = @JoinColumn(name = "bill_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "purchase_id", referencedColumnName = "id"))
    public Set<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(Set<Purchase> purchases) {
        this.purchases = purchases;
    }



    public Bill(Set<Purchase> purchases) {
        this.purchases=purchases;
        Iterator<Purchase> iterator = this.purchases.iterator();
        while (iterator.hasNext())   {
            Purchase next = iterator.next();
            totalSaleTax=totalSaleTax+ next.getPurchaseSalesTax();
            totalCost=totalCost+next.getPurchaseCost();
        }
        this.purchases = purchases;
    }



}
