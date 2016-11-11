package com.nikylos.gofit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


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

}
