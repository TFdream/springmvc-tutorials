package com.ricky.codelab.springmvc.domain;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2016-07-26 10:13
 */
public class Oder {
    private long id;
    private String category;
    private String receiveAddress;
    private double amount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getReceiveAddress() {
        return receiveAddress;
    }

    public void setReceiveAddress(String receiveAddress) {
        this.receiveAddress = receiveAddress;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
