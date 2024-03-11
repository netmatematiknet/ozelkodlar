package com.mobilprogramlar.geritusu;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class InternetWifimiGsmmi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nuri1);


        if (checkInternetConnection()) {
            Toast.makeText(this, "Bağlı olduğunuz ağ WiFi", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Bağlı olduğunuz ağ WiFi değil", Toast.LENGTH_SHORT).show();
        }


}   //OnCreate SONU


    private boolean checkInternetConnection() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm != null) {
            NetworkCapabilities nc = cm.getNetworkCapabilities(cm.getActiveNetwork());
            if (nc != null) {
                return nc.hasTransport(NetworkCapabilities.TRANSPORT_WIFI);
            }
        }
        return false;
    }



}


