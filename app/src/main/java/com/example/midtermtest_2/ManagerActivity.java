package com.example.midtermtest_2;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class ManagerActivity extends AppCompatActivity implements View.OnClickListener {
    Button historyBtn, restockBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        historyBtn = findViewById(R.id.buttonHistory);
        restockBtn = findViewById(R.id.buttonRestock);

        historyBtn.setOnClickListener(this);
        restockBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonHistory) {
            Intent intent1 = new Intent(ManagerActivity.this, ShowHistoryActivity.class);
            startActivity(intent1);
        } else {
        }
    }
}
