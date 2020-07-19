package com.example.vakuutuslaskin_nro2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity2 extends AppCompatActivity  {
    EditText a1, a2, a3, a4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        a1 = (EditText)findViewById(R.id.Amount);
        a2 = (EditText)findViewById(R.id.ins_percentage);
        a3 = (EditText)findViewById(R.id.vendor_share_percentage);
        a4 = (EditText)findViewById(R.id.min_cost_precent);
        Button button2 = (Button) findViewById(R.id.button2);


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calculator_Impl calculator = new Calculator_Impl();

                 double agreemntAmount = Double.parseDouble(a1.getText().toString());
                 double insurancePercentage = Double.parseDouble(a2.getText().toString());
                 double vendorSharePercentage = Double.parseDouble(a3.getText().toString());
                 double minCostPrecent = Double.parseDouble(a4.getText().toString());

                 calculator.insuranceCost(agreemntAmount, insurancePercentage, vendorSharePercentage,  minCostPrecent);

             };
         });
    };
}
