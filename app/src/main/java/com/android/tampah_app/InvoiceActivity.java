package com.android.tampah_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InvoiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setTitle("");
        setContentView(R.layout.activity_invoice);

        SharedPreferences prefs = getSharedPreferences("DATA_SEWA", MODE_PRIVATE);

        String fromDate = prefs.getString("DARI_TANGGAL", "");
        String toDate = prefs.getString("SAMPAI_TANGGAL","");
        String note = prefs.getString("CATATAN","");

        ((TextView)findViewById(R.id.tvOrderNo2)).setText(fromDate);
        ((TextView)findViewById(R.id.tvOrderName2)).setText(toDate);
        ((TextView)findViewById(R.id.tvFromDate2)).setText(note);

        //((TextView)findViewById(R.id.tvOrderDate2)).setText(note);



        final Button bConfirm = (Button) findViewById(R.id.bConfirm2);

        bConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent confirmIntent = new Intent(InvoiceActivity.this, PaymentConfirm.class);
                InvoiceActivity.this.startActivity(confirmIntent);
            }
        });


    }
    public void showEdit(View view) {
        startActivity(new Intent(getApplicationContext(), KetSewaActivity.class));
    }
}
