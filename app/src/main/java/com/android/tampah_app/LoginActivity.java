package com.android.tampah_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setTitle("");
        setContentView(R.layout.activity_login);

        final EditText etEmail = (EditText) findViewById(R.id.etEmail);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final Button bLogin = (Button) findViewById(R.id.bLogin);
        final TextView registerLink = (TextView) findViewById(R.id.tvRegister);

        registerLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }
        });


        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!etEmail.getText().toString().isEmpty() && !etPassword.getText().toString().isEmpty()) {
                    /*Toast.makeText(LoginActivity.this,
                            "Login berhasil",
                            Toast.LENGTH_SHORT).show();*/
                    Intent loginSuccess = new Intent(LoginActivity.this, KetSewaActivity.class);
                    LoginActivity.this.startActivity(loginSuccess);
                } else {
                    Toast.makeText(LoginActivity.this,
                            "Kolom yang Anda isikan tidak lengkap",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}
