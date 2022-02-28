package com.example.mytempapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnCalculate;
    EditText etTemp;
    RadioGroup rgTemp;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //bind programming variables with the views in xml

        btnCalculate = findViewById(R.id.btnCalc);
        etTemp = findViewById(R.id.etTemp);
        rgTemp = findViewById(R.id.rGroup);
        tvResult = findViewById(R.id.tvCalc);

        //anonymous class

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalculateAnswer();
            }
        });
    }


    private void CalculateAnswer(){

        //taking entered string out of
        String temperature = etTemp.getText().toString();

        //check for empty
        if (temperature.equals("")){

            Toast.makeText(this, "Please enter a value", Toast.LENGTH_LONG).show();
        }
        else{

            Float d = 0.0f;
            Boolean error = Boolean.FALSE;

            //check whether its a number
            try{
                d = Float.parseFloat(temperature);
            }
            catch(NumberFormatException e){
                Toast.makeText(this, "Invalid Entry", Toast.LENGTH_LONG).show();
                error = Boolean.TRUE;
            }

            if(!error){

                int checkedRadioButton = rgTemp.getCheckedRadioButtonId();

                if(checkedRadioButton == R.id.rCels){
                    tvResult.setText(convertFahrenheitToCelsius(d) + "");
                }
                else{
                    tvResult.setText(convertCelsiusToFahrenheit(d) + "");
                }
            }
        }

        //Toast
        //Toast.makeText(this, "Error!!!!", Toast.LENGTH_LONG).show();
    }


    //convertions

    protected float convertCelsiusToFahrenheit(float Temp){

        float newFaran = ( Temp * 9 / 5 ) + 32;

        return newFaran;
    }


    protected float convertFahrenheitToCelsius(float Temp){

        float newCels = ( Temp - 32 ) * 5 / 9;

        return newCels;
    }

}
