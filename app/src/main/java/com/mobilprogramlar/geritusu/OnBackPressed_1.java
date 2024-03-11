package com.mobilprogramlar.geritusu;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

// onBackPressedDispatcher: Bu, geri tuşu olaylarını yönetmek için bir araç sağlar.
// Aktivite sınıfındaki getOnBackPressedDispatcher() yöntemini kullanarak bir OnBackPressedDispatcher nesnesi alabilirsiniz.
// Bu nesne, geri tuşu olaylarını dinleyen ve geri tuşuna basıldığında belirli işlevleri çağıran bir yönetici görevi görür.

// Kısacası, OnBackPressedCallback geri tuşuna basıldığında belirli bir davranışı tanımlamak için kullanılırken,
// onBackPressedDispatcher geri tuşu olaylarını yönetmek ve işlevleri çağırmak için kullanılır.

public class OnBackPressed_1 extends AppCompatActivity {

//  OnBackPressedCallback Android 10 (API seviyesi 29) ve sonrasında kullanıma sunulmuştur.
//  onBackPressedDispatcher ise Android 9 (API seviyesi 28) ve sonrasında kullanıma sunulmuştur.

// Ancak OnBackPressedCallback, API 28'den itibaren kullanılabilir

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nuri1);

        final int MIN_ANDROID_VERSION_1 = 28; // Android 9 (Build.VERSION_CODES.P)
        final int MIN_ANDROID_VERSION_2 = 29; // Android 10 (Build.VERSION_CODES.Q)


        if (Build.VERSION.SDK_INT >= MIN_ANDROID_VERSION_2) {
            getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true /* enabled by default */) {
                @Override
                public void handleOnBackPressed() {
                    // Geri tuşuna basıldığında yapılacak işlemler
                    Intent intent = new Intent(OnBackPressed_1.this, MainActivity.class);
                    startActivity(intent);
                    //Toast.makeText(OnBackPressed_1.this, "Geri tuşuna basıldı", Toast.LENGTH_SHORT).show();
                    finish(); // Aktiviteyi sonlandır
                }
            });
        } else {
            // Android 9 öncesi için geri tuşuna basıldığında yapılacak işlemler
            Intent intent = new Intent(OnBackPressed_1.this, MainActivity.class);
            startActivity(intent);
            //super.onBackPressed(); // Gerçek geri tuşu işlevini çağırmak gerekli değil. Intent kullanmazsak burayı kullanırız.
        }
    }
}














