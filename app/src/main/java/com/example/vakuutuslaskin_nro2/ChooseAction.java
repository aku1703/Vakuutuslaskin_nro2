package com.example.vakuutuslaskin_nro2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ChooseAction extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_action);

        Button btInsurance = findViewById(R.id.bt_chooseInsurance);
        Button btQuote = findViewById(R.id.bt_chooseQuote);
        EditText txt = findViewById(R.id.editTextChooseAction);

        txt.setTextColor(Color.BLACK);
        String text = "Choose your action:";
        txt.setText(text);

        btInsurance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Activity2.class);
                startActivity(intent);
                finish();
            }
        });

        btQuote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SettlementQuoteCalculator.class);
                startActivity(intent);
                finish();
            }
        });

    }
}

