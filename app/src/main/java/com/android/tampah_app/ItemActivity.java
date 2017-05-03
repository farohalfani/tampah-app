package com.android.tampah_app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemActivity extends AppCompatActivity {

    ImageView gambarBrg;
    TextView namaBrg, deskripsiBrg, hargaBrg;

    private Context mContext = this;

    Data data;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_item);


//        Intent intent = getIntent();
        try{
            position = Data.getPosition();
        } catch (Exception e){
            e.printStackTrace();
        }

        final Button bSewa = (Button) findViewById(R.id.bSewa);
        gambarBrg = (ImageView) findViewById(R.id.ivItem);
        namaBrg = (TextView) findViewById(R.id.tvItem);
        deskripsiBrg = (TextView) findViewById(R.id.tvDeskripsi);
        hargaBrg = (TextView) findViewById(R.id.tvHarga);

        data = new Data();
        try{
            gambarBrg.setImageResource(data.gambarBrg[position]);
            namaBrg.setText(data.namaBrg[position]);
            hargaBrg.setText("Rp " + data.hargaBrg[position] + "/hari");
            deskripsiBrg.setText(data.deskripsiBrg[position]);
        }catch(Exception e){
            e.printStackTrace();
        }

        bSewa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(ItemActivity.this, LoginActivity.class);
                ItemActivity.this.startActivity(loginIntent);
            }
        });

    }


}
