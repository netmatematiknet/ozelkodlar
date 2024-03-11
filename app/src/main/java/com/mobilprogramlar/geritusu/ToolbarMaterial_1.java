package com.mobilprogramlar.geritusu;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ToolbarMaterial_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toolbar_material_1);

        View toolbar = findViewById(R.id.toolbar);
        setSupportActionBar((androidx.appcompat.widget.Toolbar) toolbar);

        // Animasyonları başlatma
        initAnimations();
    }

    private void setSupportActionBar(Toolbar toolbar) {
    }

    private void initAnimations() {

        /*

        // Logo Animasyonu
        final ImageView logo = findViewById(R.id.toolbar_logo);
        logo.setPivotX(0);
        logo.setPivotY(0);
        logo.animate().translationX(-50).setDuration(500).start();

        // Başlık Animasyonu
        final TextView title = findViewById(R.id.toolbar_title);
        title.setAlpha(0);
        title.animate().alpha(1).setDuration(500).start();

        // Home Butonu Animasyonu
        final ImageButton homeButton = findViewById(R.id.toolbar_home);
        homeButton.setRotation(45);
        homeButton.animate().rotation(0).setDuration(500).start();



        // Toolbar Renk Animasyonu

        ValueAnimator colorAnimator = ValueAnimator.ofArgb(
                ContextCompat.getColor(this, R.color.colorPrimary),
                ContextCompat.getColor(this, R.color.colorAccent));
        colorAnimator.setDuration(500);
        colorAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(@NonNull ValueAnimator animation) {
                // LayoutParams ayarlama
                Toolbar.LayoutParams params = (Toolbar.LayoutParams) toolbar.getLayoutParams();
                params.setBackgroundColor((Integer) animation.getAnimatedValue());
                toolbar.setLayoutParams(params);
            }
        });
        colorAnimator.start();
        */


    }
}
