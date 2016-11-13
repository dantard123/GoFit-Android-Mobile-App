package com.nikylos.gofit;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.app.AlertDialog;
import android.util.Log;

import android.view.View;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

import layout.*;

public class CalculatorActivity extends AppCompatActivity implements MetricFragment.OnFragmentInteractionListener, StandardFragment.OnFragmentInteractionListener {
    EditText editTextWeight;
    EditText editTextHeight;
    EditText editTextInches;
    TextView textViewResult;
    Button buttonCalculate;
    android.support.v4.app.FragmentManager fragmentManager;
    android.support.v4.app.FragmentTransaction fragmentTransaction;
    MetricFragment metricFragment;
    StandardFragment standardFragment;
    ToggleButton toggleButtonMetric;
    LayoutInflater layoutInflater;
    PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      ;


        setContentView(R.layout.activity_calculator);

        //Toogle Listener
        ((RadioGroup) findViewById(R.id.toggleGroup)).setOnCheckedChangeListener(ToggleListener);

 /*       //Fragment
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        metricFragment = new MetricFragment();

        //add or replace
        fragmentTransaction.replace(R.id.fragment_container,metricFragment);
        fragmentTransaction.commit();*/


        //Button EventListener
        buttonCalculate = (Button) findViewById(R.id.button);
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                if( toggleButtonMetric.isChecked()){

                        editTextHeight = (EditText) findViewById(R.id.editTextHeight);
                        editTextWeight = (EditText) findViewById(R.id.editTextWeight);
                        double height = Double.parseDouble(editTextHeight.getText().toString());
                        double weight = Double.parseDouble(editTextWeight.getText().toString());
                        double result = weight / Math.pow((height / 100), 2);
                        textViewResult = (TextView) findViewById(R.id.textViewResult);
                        textViewResult.setText("Your BMI Value is" + String.format("%.2f", result) + "!");


                   //popup
                    layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                    ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.layout_popup,null);
                    popupWindow = new PopupWindow(container,400,400,true);
                    RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.activity_calculator) ;
                    popupWindow.showAtLocation(relativeLayout, Gravity.NO_GRAVITY,500,500);
                    TextView textViewPopUp = (TextView) container.findViewById(R.id.textViewPopUp);
                    textViewPopUp.setText("HIIIIIIIIII");
                    container.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View v, MotionEvent event) {
                            popupWindow.dismiss();
                            return false;
                        }
                    });

                }
                else{
                        editTextHeight = (EditText) findViewById(R.id.editTextFeet);
                        editTextInches = (EditText) findViewById(R.id.editTextInches);
                        editTextWeight = (EditText) findViewById(R.id.editTextPound);
                        double height = Double.parseDouble(editTextHeight.getText().toString())*12;
                        double inches = Double.parseDouble(editTextInches.getText().toString());
                        double FINAL_HEIGHT = (height + inches)*0.025;
                        double weight = Double.parseDouble(editTextWeight.getText().toString()) * 0.45;

                        double result = weight / Math.pow((FINAL_HEIGHT), 2);
                        textViewResult = (TextView) findViewById(R.id.textViewResult);
                        textViewResult.setText("Your BMI Value is" + String.format("%.2f", result) + "!");

                     }
                } catch (Throwable ex) {
                    messageBox("Error", ex.getMessage());
                }
            }
        });
    }
    static final RadioGroup.OnCheckedChangeListener ToggleListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(final RadioGroup radioGroup, final int i) {
            for (int j = 0; j < radioGroup.getChildCount(); j++) {
                final ToggleButton view = (ToggleButton) radioGroup.getChildAt(j);
                view.setChecked(view.getId() == i);


            }

        }
    };
    public void onToggle(View view) {

        ((RadioGroup)view.getParent()).check(view.getId());
        toggleButtonMetric= (ToggleButton) findViewById(R.id.toggleButtonMetric);
        textViewResult = (TextView) findViewById(R.id.textViewResult);
        if (toggleButtonMetric.isChecked()){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            metricFragment = new MetricFragment();
            fragmentTransaction.replace(R.id.fragment_container,metricFragment);
            fragmentTransaction.commit();
            textViewResult.setText("CM/KG");
        }
        else{
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            standardFragment = new StandardFragment();
            fragmentTransaction.replace(R.id.fragment_container,standardFragment);
            fragmentTransaction.commit();
            textViewResult.setText("FT/LB");
        }


    }

    //alert messagebox
    private void messageBox(String method, String message)
    {
//        Log.d("EXCEPTION: " + method,  message);

        AlertDialog.Builder messageBox = new AlertDialog.Builder(this);
        messageBox.setTitle(method);
        messageBox.setMessage(message);
        messageBox.setCancelable(false);
        messageBox.setNeutralButton("OK", null);
        messageBox.show();
    }


    @Override
    public void onMetricFragmentInteraction(String string) {

    }

    @Override
    public void onStandardFragmentInteraction(String string) {

    }
}
