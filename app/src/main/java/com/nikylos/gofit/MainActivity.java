package com.nikylos.gofit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goCalculator(View v){
        Intent intent = new Intent(getApplicationContext(),CalculatorActivity.class);
        startActivity(intent);

    }
    public void goSetting(View v){
        Intent intent = new Intent(getApplicationContext(),SettingActivity.class);
        startActivity(intent);

    }

    long lastPress;
    Toast backpressToast;

    @Override
    public void onBackPressed() {
        long currentTime = System.currentTimeMillis();
        if(currentTime - lastPress > 5000){
            backpressToast = Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_LONG);
            backpressToast.show();
            lastPress = currentTime;
        } else {
            if (backpressToast != null) backpressToast.cancel();
            super.onBackPressed();
        }
    }
}
