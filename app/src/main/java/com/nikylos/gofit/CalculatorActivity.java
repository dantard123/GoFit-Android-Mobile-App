package com.nikylos.gofit;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.view.View;
import android.widget.ToggleButton;

public class CalculatorActivity extends AppCompatActivity {
    EditText editTextWeight;
    EditText editTextHeight;
    TextView textViewResult;
    Button buttonCalculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        //Toogle Listener
        ((RadioGroup) findViewById(R.id.toggleGroup)).setOnCheckedChangeListener(ToggleListener);



        //Button EventListener
        buttonCalculate = (Button) findViewById(R.id.button);
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextHeight = (EditText) findViewById(R.id.editTextHeight);
                editTextWeight = (EditText) findViewById(R.id.editTextWeight);
                double height = Double.parseDouble(editTextHeight.getText().toString());
                double weight = Double.parseDouble(editTextWeight.getText().toString());
                double result = weight/Math.pow((height/100),2);
                textViewResult = (TextView) findViewById(R.id.textViewResult);
                textViewResult.setText("Your BMI Value is"+ String.format("%.2f",result)+"!");
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
        ToggleButton toggleButtonMetric= (ToggleButton) findViewById(R.id.toggleButtonMetric);
        textViewResult = (TextView) findViewById(R.id.textViewResult);
        if (toggleButtonMetric.isChecked()){
            textViewResult.setText("CM/KG");
        }
        else{
            textViewResult.setText("FT/LB");
        }


    }


}
