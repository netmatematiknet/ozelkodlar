package com.mobilprogramlar.geritusu;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class InternetKontrolu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nuri1);

        if(internetVarmi()){ //internet kontrol methodu çağırılıyor
            Toast.makeText(getApplicationContext(), "İnternet Bağlı!", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(), "İnternet!\b YOK", Toast.LENGTH_LONG).show();
        }


}   //OnCreate SONU





    protected boolean internetVarmi() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm != null) {
            NetworkCapabilities nc = cm.getNetworkCapabilities(cm.getActiveNetwork());
            if (nc != null && nc.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) && nc.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)) {
                return true;    // Bağlantı mevcut
            }
        }
        return false;   // Bağlantı yok veya hata var
    }




}


