package com.nikylos.gofit;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
    TextView textviewQuote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Resources resources = getResources();
        String[] array = resources.getStringArray(R.array.quote);
        String randomStr = array[new Random().nextInt(array.length-1)];
      textviewQuote = (TextView)findViewById(R.id.textViewQuote);
        textviewQuote.setText(""+randomStr);


    }

    public void goCalculator(View v){
        Intent intent = new Intent(getApplicationContext(),CalculatorActivity.class);
        startActivity(intent);

    }
    public void goSetting(View v){
        Intent intent = new Intent(getApplicationContext(),SettingActivity.class);
        startActivity(intent);

    }
    public void goHeartbeat(View v){
        Intent intent = new Intent(getApplicationContext(),HeartBeatActivity.class);
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
