package com.example.vakuutuslaskin_nro2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import static com.example.vakuutuslaskin_nro2.MainActivity.historyFile;
import static com.example.vakuutuslaskin_nro2.R.id.editTextHistTitle;

public class History extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        TextView historyTitle = findViewById(editTextHistTitle);
        ScrollView history = findViewById(R.id.textBoxHistory);
        TextView historyDetails = findViewById(R.id.et_history);
        Button exit = findViewById(R.id.btExit);

        String title = "History";
        historyTitle.setText(title);
        history.setBackgroundColor(Color.LTGRAY);

        try {
            historyDetails.setText(MainActivity.readFile());

        } catch (Exception e) {
            e.printStackTrace();
        }

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("EXIT", true);
                startActivity(intent);
                finish();
            }
        }
        );
    }
}