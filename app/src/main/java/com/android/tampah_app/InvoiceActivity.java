package com.android.tampah_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InvoiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setTitle("");
        setContentView(R.layout.activity_invoice);

        final Button bConfirm = (Button) findViewById(R.id.bConfirm);

        bConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent confirmIntent = new Intent(InvoiceActivity.this, PaymentConfirm.class);
                InvoiceActivity.this.startActivity(confirmIntent);
            }
        });


    }
}
