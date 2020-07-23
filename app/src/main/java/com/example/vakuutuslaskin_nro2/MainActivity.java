package com.example.vakuutuslaskin_nro2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import static android.widget.Toast.*;


public class MainActivity extends AppCompatActivity {
    private EditText Name;
    private EditText Password;
    private Button Login;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText) findViewById(R.id.editTextTextUsername);
        Password = (EditText) findViewById(R.id.editTextTextPassword);
        Login = (Button) findViewById(R.id.Login);

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
            Intent intent = new Intent(getApplicationContext(), Activity2.class);
            startActivity(intent);
        } else {
            makeText(MainActivity.this, "*** Invalid Details! ***", LENGTH_LONG).show();
            counter--;
            if (counter == 0) {
                makeText(MainActivity.this, "*** Please, check your username and password! ***", LENGTH_LONG).show();

                Login.setEnabled(false);
            }
        }
    }
}

 //           public void exit() { // TODO lisää tämä sivulle 2 jotta sieltä voi palata etusivulle?
 //               Intent intent = new Intent(getApplicationContext(), MainActivity.class);
 //               intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
 //               intent.putExtra("EXIT", true);
 //               finish();
 //           }

