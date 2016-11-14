package com.nikylos.gofit;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



import layout.MetricFragment;

public class SettingActivity extends AppCompatActivity implements MetricFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_setting);

    }


    @Override
    public void onMetricFragmentInteraction(String string) {

    }
}
