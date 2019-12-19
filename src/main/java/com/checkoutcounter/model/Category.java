package com.checkoutcounter.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Sanket Bhsukat on 11/12/2019.
 */
@Entity
@Table(name ="category" )
public class Category {

/*    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", salestax=" + salestax +
                ", products=" + products +
                ", id=" + id +
                '}';
    }*/

    private String name;
    private double salestax;


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

    public double getSalestax() {
        return salestax;
    }

    public void setSalestax(double salestax) {
        this.salestax = salestax;
    }

    private int id;

    public Category(String name, double salestax) {
        this.name = name;
        this.salestax = salestax;
    }






    public Category(){

    }
}
