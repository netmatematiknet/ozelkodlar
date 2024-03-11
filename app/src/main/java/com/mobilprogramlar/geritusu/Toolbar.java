package com.mobilprogramlar.geritusu;

import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Toolbar extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toolbar);

        // Toolbar'ı Toolbar türüne dönüştürüyoruz
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(view -> onBackPressed());

    }
}



