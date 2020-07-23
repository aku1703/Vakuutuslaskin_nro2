package com.example.vakuutuslaskin_nro2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import static java.lang.String.*;

public class ResultList extends Activity2 {
    private Button logout;
    TextView result;

    @SuppressLint("SetTextI18n")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_list);
        result = (TextView) findViewById(R.id.textFieldForResult);

        result.setText(" Hello there, how are you doing?" );




        logout = (Button) findViewById(R.id.buttonLogOut);


    }
}