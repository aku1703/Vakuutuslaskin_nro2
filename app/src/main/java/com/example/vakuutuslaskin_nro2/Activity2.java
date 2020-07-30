package com.example.vakuutuslaskin_nro2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity  {
    EditText a1, a2, a3, a4;
    TextView title;

    private CalculatorOlio calculatorOlio = new CalculatorOlio();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        title = findViewById(R.id.tv_insTitle);
        a1 = findViewById(R.id.Amount);
        a2 = findViewById(R.id.ins_percentage);
        a3 = findViewById(R.id.vendor_share_percentage);
        a4 = findViewById(R.id.min_cost_precent);
        Button button2 = findViewById(R.id.button2);

        String txtToTitle = "Insurance and vendor split calculator";
        title.setText(txtToTitle);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double agreementAmount = Double.parseDouble(a1.getText().toString());
                double insurancePercentage = Double.parseDouble(a2.getText().toString());
                double vendorSharePercentage = Double.parseDouble(a3.getText().toString());
                double minCostPercent = Double.parseDouble(a4.getText().toString());

                calculatorOlio.setOneMonthInsurance(agreementAmount, insurancePercentage);
                calculatorOlio.setVendorSharePerMonth(agreementAmount, insurancePercentage, vendorSharePercentage, minCostPercent);

                double insPer1Month =  calculatorOlio.getOneMonthInsurance();
                double splitPer1Month =  calculatorOlio.getVendorSharePerMonth();


                Intent intent = new Intent(getApplicationContext(), ResultList.class);
                intent.putExtra("key", insPer1Month);
                intent.putExtra("key2", splitPer1Month);
                startActivity(intent);
            }

        });
    }
}
