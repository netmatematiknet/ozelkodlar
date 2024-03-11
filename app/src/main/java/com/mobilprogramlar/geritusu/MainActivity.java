package com.mobilprogramlar.geritusu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btn_1,btn_2,btn_3,btn_4,btn_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


/*
        btn_1 = findViewById(R.id.btn1);
        btn_2 = findViewById(R.id.btn2);
        btn_3 = findViewById(R.id.btn3);
        btn_4 = findViewById(R.id.btn4);
        btn_5 = findViewById(R.id.btn5);


        btn_1.setOnClickListener(view -> {
            Intent hedefSAYFA1 = new Intent(getApplicationContext(),InternetKontrolu.class);
            //uniteINTENT.putExtra("hangi_unite",1);
            startActivity(hedefSAYFA1);
        });

        btn_2.setOnClickListener(view -> {
            Intent hedefSAYFA2 = new Intent(getApplicationContext(),InternetHIZKontrolu.class);
            startActivity(hedefSAYFA2);
        });

        btn_3.setOnClickListener(view -> {
            Intent hedefSAYFA3 = new Intent(getApplicationContext(), InternetWifimiGsmmi.class);
            startActivity(hedefSAYFA3);
        });

        btn_4.setOnClickListener(view -> {
            Intent hedefSAYFA4 = new Intent(getApplicationContext(),OnBackPressed_1.class);
            startActivity(hedefSAYFA4);
        });

        btn_5.setOnClickListener(view -> {
            Intent hedefSAYFA5 = new Intent(getApplicationContext(),OnBackPressed_2.class);
            startActivity(hedefSAYFA5);
        });
*/


// Butonların id'lerini ve ilgili sınıfları bir dizi içinde tutabiliriz
        int[] buttonIds = {R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8};
        Class<?>[] nur = {
                InternetKontrolu.class, InternetHIZKontrolu.class, InternetWifimiGsmmi.class, OnBackPressed_1.class, OnBackPressed_2.class,
                Toolbar.class, ToolbarMaterial.class, ToolbarMaterial_2.class
        };

// Butonların tıklama olaylarını tek bir döngü içinde hızlıca bağlayabiliriz
        for (int i = 0; i < buttonIds.length; i++) {
            // Her bir butonun tıklama işlemi için bir final değişken oluşturuyoruz
            int finalI = i;
            // Her bir butonun id'sini kullanarak butonu buluyoruz ve tıklama olayı dinleyicisini ekliyoruz
            //findViewById(buttonIds[i]).setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), nur[finalI])));
            findViewById(buttonIds[i]).setOnClickListener(v -> {
                // Tıklanan butona göre doğru sınıfı belirleyip yeni bir Intent oluşturuyoruz ve startActivity ile başlatıyoruz
                startActivity(new Intent(getApplicationContext(), nur[finalI]));
            });
        }







    }

}