package com.mobilprogramlar.geritusu;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

public class NurActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nuri2);

        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent intent = new Intent(NurActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        };

    }
}