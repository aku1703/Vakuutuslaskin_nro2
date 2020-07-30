package com.example.vakuutuslaskin_nro2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.*;


public class MainActivity extends AppCompatActivity {
    private static Context context = null;
    private EditText Name;
    private EditText Password;
    private Button Login;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;

        // HUOM:tiedosto löytyy: data/data/com.example.vakuutuslaskin_nro2/files/ kansion alta!
        System.out.println("tässä on kansio " + context.getFilesDir());

        Name = findViewById(R.id.editTextTextUsername);
        Password = findViewById(R.id.editTextTextPassword);
        Login = findViewById(R.id.Login);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(), Password.getText().toString());
                finish();
            }
        });
    }

    private void validate(String userName, String userPassword) {
        if ((userName.equals("Admin")) && (userPassword.equals("1234"))) {
            makeText(MainActivity.this, "*** Wellcome! ***", LENGTH_SHORT).show();
            DateOlio dateOlio = new DateOlio();
            String date = dateOlio.getFormattedDate();
            writeFile(userName + ",");
            writeFile(date + ",");
            Intent intent = new Intent(getApplicationContext(), ChooseAction.class);
            startActivity(intent);
        } else {
            makeText(MainActivity.this, "*** Invalid Details! ***", LENGTH_LONG).show();
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            counter--;
            if (counter == 0) {
                makeText(MainActivity.this, "*** Please, check your username and password! ***", LENGTH_LONG).show();
                Login.setEnabled(false);
            }
        }
    }

    public static void writeFile(String txt) {
        try {
            OutputStreamWriter ows = new OutputStreamWriter(context.openFileOutput("newFileForTesting4.csv", MODE_APPEND));
            ows.write(txt);
            ows.close();

        } catch (IOException e) {
            Log.e("IOException", "Problem found");
        } finally {
            System.out.println("writefile menty loppuun");
        }
    }

    public static List<ReadHistoryFile> historyFile = new ArrayList<>();

    public static String readFile() {
        String s = "";

        try {
            InputStream ins = context.openFileInput("newFileForTesting4.csv");
            BufferedReader br = new BufferedReader(new InputStreamReader(ins));
            String detail;
            while ((detail = br.readLine()) != null) {
                s = s + detail + "\n";

                //Split by ";"
                String[] tokens = s.split(",");
                // Read the data
                ReadHistoryFile readHistoryFile = new ReadHistoryFile();
                readHistoryFile.getUsername(tokens[0]);
                readHistoryFile.getDate(tokens[1]);
                readHistoryFile.getInsurance(tokens[2]);
                readHistoryFile.getInsurance(tokens[3]);
                readHistoryFile.getQuote(tokens[4]);
                historyFile.add(readHistoryFile);

            }
            ins.close();
            br.close();

        } catch (IOException e) {
            Log.e("IOException", "IOException problem found");
        } finally {
            System.out.println("readFile menty loppuun");
        }
        return s;
    }
}

