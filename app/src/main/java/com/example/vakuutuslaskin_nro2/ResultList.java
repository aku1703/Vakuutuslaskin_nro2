package com.example.vakuutuslaskin_nro2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultList extends Activity2 {
    private Button button;
    TextView result;

    private Converter converter = new Converter();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_list);
        result = findViewById(R.id.textFieldForResult);

        Intent intent = getIntent();
        Double value1 = intent.getDoubleExtra("key", 0.0);
        Double value2 = intent.getDoubleExtra("key2", 0.0);
        converter.setNumber(value1);
        String insurance = converter.getNumber();
        converter.setNumber(value2);
        String split = converter.getNumber();

        result.setTextColor(Color.BLACK);
        String note = ("Insurance per month is " + insurance +" Exempt FI\n\nVendor split per month is -" + split +
                " Standard FI.\n\n" + "Please remember to check that asset age is no over 10 years.\n\n" +
                "Asset can't be a car or tracked excavator.");
        result.setText(note);

        MainActivity.writeFile(insurance + ",");
        MainActivity.writeFile(split + ",");
        button = findViewById(R.id.buttonQuote);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viev) {
                Intent intent = new Intent((getApplicationContext()), SettlementQuoteCalculator.class);
                startActivity(intent);

            }
        });
    }
}