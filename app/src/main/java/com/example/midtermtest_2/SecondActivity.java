package com.example.midtermtest_2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Retrieve the file path from the intent
        String imagePath = getIntent().getStringExtra("imagePath");

        // Load the image from the file
        Bitmap imageBitmap = BitmapFactory.decodeFile(imagePath);

        // Display the loaded image in the SecondActivity UI
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageBitmap(imageBitmap);
    }
}
