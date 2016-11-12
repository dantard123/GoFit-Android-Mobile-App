package com.nikylos.gofit;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import layout.MetricFragment;

public class SettingActivity extends AppCompatActivity implements MetricFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        MetricFragment fragment = new MetricFragment();
        fragmentTransaction.add(R.id.fragment_container,fragment);
        fragmentTransaction.commit();


        setContentView(R.layout.activity_setting);

    }


    @Override
    public void onMetricFragmentInteraction(String string) {
        
    }
}
