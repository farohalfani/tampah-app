package com.android.tampah_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class InvoiceActivity extends AppCompatActivity {
    private TextView tvOrderNo2;
    private TextView tvOrderName2;
    private TextView tvFromDate2;
    private TextView tvToDate2;
    private TextView tvOrderPrice2;

    private String orderName, fromDate, toDate;
    private String getDays;
    private int position,orderPrice;
    private Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setTitle("");
        setContentView(R.layout.activity_invoice);

//        SharedPreferences prefs = getSharedPreferences("DATA_SEWA", MODE_PRIVATE);
//
//        String fromDate = prefs.getString("DARI_TANGGAL", "");
//        String toDate = prefs.getString("SAMPAI_TANGGAL","");
//        String note = prefs.getString("CATATAN","");
//
//        ((TextView)findViewById(R.id.tvOrderNo2)).setText(fromDate);
//        ((TextView)findViewById(R.id.tvOrderName2)).setText(toDate);
//        ((TextView)findViewById(R.id.tvFromDate2)).setText(note);

        //((TextView)findViewById(R.id.tvOrderDate2)).setText(note);

        Intent intent = getIntent();
        data = new Data();
        position = data.getPosition();
        fromDate = intent.getStringExtra("start");
        toDate = intent.getStringExtra("end");
        getDays = intent.getStringExtra("days");

        tvOrderNo2 = (TextView) findViewById(R.id.tvOrderNo2);
        tvOrderName2 = (TextView) findViewById(R.id.tvOrderName2);
        tvFromDate2 = (TextView) findViewById(R.id.tvFromDate2);
        tvToDate2 = (TextView) findViewById(R.id.tvToDate2);
        tvOrderPrice2 = (TextView)findViewById(R.id.tvOrderPrice2);

        final Button bConfirm = (Button) findViewById(R.id.bConfirm2);

        bConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent confirmIntent = new Intent(InvoiceActivity.this, PaymentConfirm.class);
                InvoiceActivity.this.startActivity(confirmIntent);
            }
        });

        showResult();

    }
    public void showEdit(View view) {
        startActivity(new Intent(getApplicationContext(), KetSewaActivity.class));
    }

    private void showResult(){
        Random random = new Random();
        int orderNo = random.nextInt(100);
        tvOrderNo2.setText(String.valueOf(orderNo));

        orderName = data.namaBrg[position];
        tvOrderName2.setText(orderName);

        tvFromDate2.setText(fromDate);
        tvToDate2.setText(toDate);

        int days = Integer.parseInt(getDays);
        int price = data.hargaBrg[position];
        orderPrice = price*days;
        tvOrderPrice2.setText("Rp " +orderPrice);

    }
}
