package com.nikylos.gofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

public class CalculatorActivity extends AppCompatActivity {
    EditText editTextWeight;
    EditText editTextHeight;
    TextView textViewResult;
    Button buttonCalculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

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
}
