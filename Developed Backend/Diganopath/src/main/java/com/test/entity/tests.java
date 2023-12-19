package com.test.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class tests {
    
    @Id
    private int test_id;
    private String test_name;
    private double test_price;
    
    public tests() {
    }

    public tests(int test_id, String test_name, double test_price) {
        this.test_id = test_id;
        this.test_name = test_name;
        this.test_price = test_price;
    }

    public int getTest_id() {
        return test_id;
    }

    public void setTest_id(int test_id) {
        this.test_id = test_id;
    }

    public String getTest_name() {
        return test_name;
    }

    public void setTest_name(String test_name) {
        this.test_name = test_name;
    }

    public double getTest_price() {
        return test_price;
    }

    public void setTest_price(double test_price) {
        this.test_price = test_price;
    }

    

}
