package com.example.midtermtest_2;

import android.graphics.Bitmap;
import java.io.Serializable;

public class Product implements Serializable {
    private final String name;
    private final Bitmap image;

    public Product(String name, Bitmap image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public Bitmap getImage() {
        return image;
    }
}
