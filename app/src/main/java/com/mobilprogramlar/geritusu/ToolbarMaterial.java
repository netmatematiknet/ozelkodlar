package com.mobilprogramlar.geritusu;

        import android.animation.Animator;
        import android.animation.AnimatorSet;
        import android.animation.ObjectAnimator;
        import android.os.Bundle;
        import android.view.View;
        import android.view.ViewTreeObserver;
        import android.widget.ImageView;
        import android.widget.TextView;
        import androidx.activity.OnBackPressedCallback;
        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.appcompat.widget.Toolbar;

public class ToolbarMaterial extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView logo;
    private TextView title1, title2;
    private boolean toolbarShown = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toolbar_material);

        toolbar = findViewById(R.id.toolbar);
        logo = findViewById(R.id.logo);
        title1 = findViewById(R.id.title_1);
        title2 = findViewById(R.id.title_2);

        // Toolbar'ı başlangıçta gizle
        toolbar.setVisibility(View.GONE);

        // Görünüm ağacı gözlemcisi, görünüm hiyerarşisi oluşturulduktan sonra animasyonu başlatmak için kullanılır.
        final ViewTreeObserver observer = toolbar.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                // Gözlemciyi kaldır
                observer.removeOnGlobalLayoutListener(this);

                // Animasyonları başlat
                showToolbar();
            }
        });


        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if (toolbarShown) {
                    hideToolbar();
                } else {
                    getParent().onBackPressed();
                }
            }
        };
        getOnBackPressedDispatcher().addCallback(this, callback);


    }

    private void showToolbar() {
        toolbarShown = true;

        // Animasyon setini oluştur
        AnimatorSet animatorSet = new AnimatorSet();

        // Logo ve başlıkları sola kaydır
        ObjectAnimator logoAnim = ObjectAnimator.ofFloat(logo, "translationX", -100, 0);
        ObjectAnimator title1Anim = ObjectAnimator.ofFloat(title1, "translationX", -100, 0);
        ObjectAnimator title2Anim = ObjectAnimator.ofFloat(title2, "translationX", -100, 0);

        // Animasyon setine animasyonları ekle
        animatorSet.playTogether(logoAnim, title1Anim, title2Anim);

        // Animasyon setini başlat
        animatorSet.start();

        // Toolbar'ı görünür hale getir
        toolbar.setVisibility(View.VISIBLE);
    }

    private void hideToolbar() {
        toolbarShown = false;

        // Animasyon setini oluştur
        AnimatorSet animatorSet = new AnimatorSet();

        // Logo ve başlıkları sağa kaydır
        ObjectAnimator logoAnim = ObjectAnimator.ofFloat(logo, "translationX", 0, -100);
        ObjectAnimator title1Anim = ObjectAnimator.ofFloat(title1, "translationX", 0, -100);
        ObjectAnimator title2Anim = ObjectAnimator.ofFloat(title2, "translationX", 0, -100);

        // Animasyon setine animasyonları ekle
        animatorSet.playTogether(logoAnim, title1Anim, title2Anim);

        // Animasyon setini başlat
        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(@NonNull Animator animation) {

            }

            @Override
            public void onAnimationEnd(@NonNull Animator animation) {
                // Animasyon bittikten sonra Toolbar'ı gizle
                toolbar.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationCancel(@NonNull Animator animation) {

            }

            @Override
            public void onAnimationRepeat(@NonNull Animator animation) {

            }
        });

        animatorSet.start();
    }

    /*
    @Override
    public void onBackPressed() {
        if (toolbarShown) {
            hideToolbar();
        } else {
            super.onBackPressed();
        }
    }
    */



}
