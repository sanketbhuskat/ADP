package com.checkoutcounter.model;

import javax.persistence.*;

/**
 * Created by Sanket Bhsukat on 11/12/2019.
 */
@Entity
public class Product {

    public double getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    private double salesTax;

/*    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", category=" + category +
                ", purchases=" + purchases +
                ", id=" + id +
                '}';
    }*/

    private String name;
    private double cost;
    private Category category;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @ManyToOne
    @JoinColumn(name = "category_id")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    private int id;

    public Product(String name, double cost, Category category) {
        this.name = name;
        this.cost = cost;
        this.category = category;
        this.salesTax=((cost*category.getSalestax())/100);
    }



    public Product(){

    }
}
