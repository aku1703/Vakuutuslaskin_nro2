package com.example.vakuutuslaskin_nro2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.System.out;

public class SettlementQuoteCalculator extends AppCompatActivity {

    TextView a1, a2, a3, a4, a5, a6;
    private SettlementOlio settlementOlio = new SettlementOlio();
    private Converter converter = new Converter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settlement_quote_calculator);

        a1 = (EditText)findViewById(R.id.rentPerInvoice);
        a2 = (EditText)findViewById(R.id.remainingInvoices);
        a3 = (EditText)findViewById(R.id.residualValue);
        Button btCalculateQuote = findViewById(R.id.CalculateQuote);
        a4 = (EditText)findViewById(R.id.SettelementAmount);
        a5 = (EditText)findViewById(R.id.Vat);
        a6 = (EditText)findViewById(R.id.TotalCost);
        final Button btHistory = findViewById(R.id.buttonReadHistory);

        btCalculateQuote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double rent = Double.parseDouble(a1.getText().toString());
                double invoices = Double.parseDouble(a2.getText().toString());
                double residualValue = Double.parseDouble(a3.getText().toString());

                settlementOlio.setRemainingLease(rent, invoices, residualValue);

                double amountNoVat =  settlementOlio.getRemainingLease();
                converter.setNumber(settlementOlio.getRemainingLease());
                a4.setText(converter.getNumber());
                MainActivity.writeFile(converter.getNumber()+ "\n");


                double vat  =  ((settlementOlio.getRemainingLease() * 1.24) - amountNoVat);
                converter.setNumber(vat);
                a5.setText(converter.getNumber());

                double totalAmount = (settlementOlio.getRemainingLease() * 1.24);
                converter.setNumber(totalAmount);
                a6.setText(converter.getNumber());

                btHistory.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getApplicationContext(), History.class);
                        startActivity(intent);
                        finish();
                    }
                });
            }
        }
        );
    }
}





