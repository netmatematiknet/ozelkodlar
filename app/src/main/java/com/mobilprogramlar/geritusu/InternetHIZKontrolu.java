package com.mobilprogramlar.geritusu;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InternetHIZKontrolu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nuri1);



        if(isSlowInternetConnection()){ //internet HIZ kontrol methodu çağırılıyor
            Toast.makeText(getApplicationContext(), "İnternet HIZLI!", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(), "İnternet!\b YAVAŞ", Toast.LENGTH_LONG).show();
        }


}   //OnCreate SONU


    private boolean isSlowInternetConnection() {
        // İnternet bağlantısının hızını kontrol edin
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkCapabilities nc = cm.getNetworkCapabilities(cm.getActiveNetwork());

        if (nc != null) {
            // Wi-Fi bağlantısını kontrol edin
            if (nc.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                // CDMA bağlantısı olup olmadığını kontrol edin
                // TelephonyManager.NETWORK_TYPE_CDMA kullanımdan kaldırıldığı için alternatif bir yöntem kullanın
                return isCdmaConnection(cm); // Kendi `isCdmaConnection()` methodunuzu oluşturun
            } else if (nc.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                // Hücresel bağlantı için sinyal gücünü kontrol edin
                //int signalStrength = networkCapabilities.getSignalStrength();
                int signalStrength = 0;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    signalStrength = nc.getSignalStrength();
                }
                if (signalStrength < 5) {
                    // Sinyal gücü zayıfsa
                    Toast.makeText(this, "İnternet bağlantınız yavaş.", Toast.LENGTH_SHORT).show();
                    return true;
                }
            }
        }
        return false;
    }

    // CDMA bağlantısını kontrol eden method
    private boolean isCdmaConnection(ConnectivityManager cm) {
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String networkOperator = telephonyManager.getNetworkOperatorName();
        // TelephonyManager kullanmadan CDMA bağlantısını kontrol etme
        // 1. Yöntem: Ağ operatörü bilgilerini kullanma

        if (networkOperator != null && networkOperator.contains("CDMA")) {
            return true;
        }

        // 2. Yöntem: Sinyal türünü kontrol etme (API 29 ve üzeri için)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            SignalStrength signalStrength = telephonyManager.getSignalStrength();
            if (signalStrength != null && signalStrength.getCdmaDbm() < -100) {
                // CDMA sinyal gücü zayıfsa
                return true;
            }
        } else {
            // Android 10 (Q) veya üzeri sürüm değilse, bu kısımda alternatif bir işlem yapılabilir veya bir uyarı verilebilir.
            Log.d("MyActivity", "Android 10 (Q) veya üzeri bir sürüm değil");
            // Örnek olarak, aşağıdaki gibi bir işlem yapılabilir
            Toast.makeText(this, "Bu işlem sadece Android 10 (Q) ve üzeri sürümlerde desteklenmektedir.", Toast.LENGTH_SHORT).show();
        }

        // CDMA bağlantısı bulunamadı
        return false;
    }





}


