package com.example.midtermtest_2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private ImageView productImageView;
    private ActivityResultLauncher<Intent> takePictureLauncher;
    private Bitmap currentImageBitmap;
    private String currentImagePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productImageView = findViewById(R.id.ivProductImage);

        takePictureLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> handleTakePictureResult(result.getResultCode(), result.getData())
        );

        Button takePhotoButton = findViewById(R.id.btnTakePhoto);
        Button saveButton = findViewById(R.id.btnSave);

        takePhotoButton.setOnClickListener(view -> dispatchTakePictureIntent());
        saveButton.setOnClickListener(view -> saveProduct());
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            takePictureLauncher.launch(takePictureIntent);
        }
    }

    private void handleTakePictureResult(int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK && data != null) {
            Bundle extras = data.getExtras();
            if (extras != null) {
                currentImageBitmap = (Bitmap) extras.get("data");
                productImageView.setImageBitmap(currentImageBitmap);

                // Save the image to a file
                currentImagePath = saveImageToFile(currentImageBitmap);
            }
        } else {
            Toast.makeText(this, "Failed to capture image", Toast.LENGTH_SHORT).show();
        }
    }

    private String saveImageToFile(Bitmap bitmap) {
        File filesDir = getFilesDir();
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File imageFile = new File(filesDir, imageFileName + ".jpg");

        try (FileOutputStream fos = new FileOutputStream(imageFile)) {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            return imageFile.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void saveProduct() {
        if (currentImagePath != null) {
            // Do something with the product data, e.g., save it to a list or database
            Toast.makeText(this, "Product saved", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Take a photo first", Toast.LENGTH_SHORT).show();
        }
    }
}
