package com.android.tampah_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class BankActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setLogo(R.drawable.logo);
            getSupportActionBar().setDisplayUseLogoEnabled(true);
            getSupportActionBar().setTitle("");
            setContentView(R.layout.activity_bank);

            final EditText etNamaBank = (EditText) findViewById(R.id.etNamaBank);
            final EditText etNoRek = (EditText) findViewById(R.id.etNoRek);
            final EditText etAtasNama = (EditText) findViewById(R.id.etAtasNama);

//            registerLink.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent registerIntent = new Intent(com.android.tampah_app.LoginActivity.this, RegisterActivity.class);
//                    com.android.tampah_app.LoginActivity.this.startActivity(registerIntent);
//                }
//            });


        }
    }
