package com.android.tampah_app;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class PaymentConfirm extends AppCompatActivity implements OnClickListener {
    private EditText etPayDate;
    private EditText etOrderID;
    private EditText etAccountOwner;
    private EditText etAmount;
    private EditText etBank;

    private Button bConfirm;

    private DatePickerDialog payDatePickerDialog;

    private SimpleDateFormat dateFormatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setTitle("");
        setContentView(R.layout.activity_payment_confirm);

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

        findViewsById();

        setDateTimeField();

        bConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkValue();
            }
        });


    }

    private void findViewsById() {
        etOrderID = (EditText) findViewById(R.id.etOrderID);
        etAccountOwner = (EditText) findViewById(R.id.etAccountOwner);
        etAmount = (EditText) findViewById(R.id.etAmount);
        etBank = (EditText) findViewById(R.id.etBank);

        etPayDate = (EditText) findViewById(R.id.etPayDate);
        etPayDate.setInputType(InputType.TYPE_NULL);
        etPayDate.requestFocus();

        bConfirm = (Button) findViewById(R.id.bConfirm2);

    }

    private void checkValue() {

        String ID = etOrderID.getText().toString();
        String accountOwner = etAccountOwner.getText().toString();
        String amount = etAmount.getText().toString();
        String bank = etBank.getText().toString();
        String payDate = etPayDate.getText().toString();


        if ( ID.isEmpty() || accountOwner.isEmpty() || amount.isEmpty() ||
                bank.isEmpty() || payDate.isEmpty() ) {

            // Error , one or more editText are empty
            Toast.makeText(PaymentConfirm.this,
                    "Kolom yang Anda isikan tidak lengkap",
                    Toast.LENGTH_SHORT).show();
        }

        else
        {
            // all editText are not empty
            Intent thanksIntent = new Intent(PaymentConfirm.this, ThanksActivity.class);
            PaymentConfirm.this.startActivity(thanksIntent);
        }

    }

    private void setDateTimeField() {
        etPayDate.setOnClickListener(this);

        Calendar newCalendar = Calendar.getInstance();
        payDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear,dayOfMonth);
                etPayDate.setText(dateFormatter.format(newDate.getTime()));
            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public void onClick(View v) {
        if (v == etPayDate) {
            payDatePickerDialog.show();
        }
    }


}
