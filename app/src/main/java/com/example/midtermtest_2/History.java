package com.example.midtermtest_2;

import java.util.Date;

public class History {
    private String type;
    private double total;
    private int quantity;
    private Date date;

    // Constructor
    public History(String type, double total, int quantity, Date date) {
        this.type = type;
        this.total = total;
        this.quantity = quantity;
        this.date = date;
    }

    // Getter methods
    public String getType() {
        return type;
    }

    public double getTotal() {
        return total;
    }

    public int getQuantity() {
        return quantity;
    }

    public Date getDate() {
        return date;
    }
}

