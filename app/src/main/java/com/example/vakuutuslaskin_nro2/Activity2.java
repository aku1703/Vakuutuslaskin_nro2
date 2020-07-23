package com.example.vakuutuslaskin_nro2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity  {
    EditText a1, a2, a3, a4;

    private CalculatorOlio calculatorOlio = new CalculatorOlio();

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

                double agreemntAmount = Double.parseDouble(a1.getText().toString());
                double insurancePercentage = Double.parseDouble(a2.getText().toString());
                double vendorSharePercentage = Double.parseDouble(a3.getText().toString());
                double minCostPrecent = Double.parseDouble(a4.getText().toString());

                calculatorOlio.setOneMonthInsurance(agreemntAmount, insurancePercentage);
                calculatorOlio.setVendorSharePerMonth(agreemntAmount, insurancePercentage, vendorSharePercentage, minCostPrecent);

                calculatorOlio.getOneMonthInsurance();
                calculatorOlio.getVendorSharePerMonth();

                double insPer1Month =  calculatorOlio.getOneMonthInsurance();
                double splitPer1Month =  calculatorOlio.getVendorSharePerMonth();

                Intent intent = new Intent(getApplicationContext(), ResultList.class);
                intent.putExtra("key", insPer1Month);
                intent.putExtra("key2", splitPer1Month);
                startActivity(intent);
            };

        });
    };
}
