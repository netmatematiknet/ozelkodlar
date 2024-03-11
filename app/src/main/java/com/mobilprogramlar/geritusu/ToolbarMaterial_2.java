package com.mobilprogramlar.geritusu;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import java.util.Objects;

public class ToolbarMaterial_2 extends AppCompatActivity {

        private ImageView logo;
        private TextView title1, title2;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.toolbar_material_2);

            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setDisplayShowHomeEnabled(false);

            logo = findViewById(R.id.toolbar_logo);
            title1 = findViewById(R.id.toolbar_title);
            title2 = findViewById(R.id.toolbar_title_2);

            animateToolbarItems();

            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //onBackPressed();
                    finish();
                }
            });

            toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    // Handle menu item clicks here
                    return false;
                }
            });
        }

        private void animateToolbarItems() {
            ViewCompat.animate(logo).translationX(0).setDuration(500).start();
            ViewCompat.animate(title1).translationX(0).setDuration(500).start();
            ViewCompat.animate(title2).translationX(0).setDuration(500).start();
        }
    }

