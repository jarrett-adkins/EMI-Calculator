package com.example.admin.emicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.Math;

public class MainActivity extends AppCompatActivity {

    EditText etInputLoanAmount;
    EditText etInputInterestRate;
    EditText etInputTime;
    Button btnUpdateValue;
    TextView tvDisplayAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//*
        etInputLoanAmount = (EditText) findViewById(R.id.etInputLoanAmount);
        etInputInterestRate = (EditText) findViewById(R.id.etInputInterestRate);
        etInputTime = (EditText) findViewById(R.id.etInputTime);
        btnUpdateValue = (Button) findViewById( R.id.btnUpdateTextView );
        tvDisplayAmount = (TextView) findViewById( R.id.tvDisplayAmount );

        btnUpdateValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    double loanAmount = Double.valueOf(etInputLoanAmount.getText().toString());
                    double interestRate = Double.valueOf(etInputInterestRate.getText().toString());
                    double timeInYears = Double.valueOf(etInputTime.getText().toString());

                    interestRate = interestRate / (12 * 100);
                    timeInYears *= 12;

                    double emi = (loanAmount * interestRate * Math.pow(1 + interestRate, timeInYears)) /
                            (Math.pow(1 + interestRate, timeInYears) - 1);

                    String answer = String.valueOf(emi);
                    tvDisplayAmount.setText(answer);

                } catch (java.lang.NumberFormatException e ) {
                    tvDisplayAmount.setText( "Invalid input." );
                }
            }
        });
        //*/
    }
}
