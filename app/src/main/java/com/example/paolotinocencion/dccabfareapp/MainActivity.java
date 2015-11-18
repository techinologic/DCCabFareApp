package com.example.example.dccabfareapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    double costPer8thmile = 0.27;
    double distanceToTravel;
    double totalCost;
    String taxiChoice;
    double first8thMile = 3.25;
    double recommendedTip = 0.20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText miles = (EditText)findViewById(R.id.txtMiles);
        final Spinner taxitype = (Spinner)findViewById(R.id.txtTaxiType);

        Button cost = (Button)findViewById(R.id.btnCost);
        Button get = (Button)findViewById(R.id.btnGet);

        cost.setOnClickListener(new View.OnClickListener() {
        final TextView result = ((TextView)findViewById(R.id.txtResult));


            @Override
            public void onClick(View v) {

                distanceToTravel = Double.parseDouble(miles.getText().toString());
                double divideMile = (distanceToTravel/0.125);
                totalCost = first8thMile+((divideMile-1)*costPer8thmile);

                DecimalFormat currency = new DecimalFormat("$###,###.##");
                taxiChoice = taxitype.getSelectedItem().toString();
                result.setText("Cost of "+distanceToTravel+" miles using a "+taxiChoice+" is "+currency.format(totalCost)+". Recommended tip is "+currency.format(totalCost*recommendedTip)+".");
            }
        });

        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Results.class));
            }
        });



    }
}
