package com.nikylos.gofit;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class HeartBeatActivity extends AppCompatActivity {
    private Button buttonStartTimer;
    private TextView textViewTimeleft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart_beat);

        buttonStartTimer = (Button)findViewById(R.id.buttonStartTimer);
        buttonStartTimer.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                textViewTimeleft = (TextView) findViewById(R.id.textViewTimeleft);
                new CountDownTimer(30000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        textViewTimeleft.setText("seconds remaining: " + millisUntilFinished / 1000);
                        //here you can have your logic to set text to edittext
                    }

                    public void onFinish() {
                        textViewTimeleft.setText("done!");
                    }

                }.start();
            }
        }
        );
    }


}
