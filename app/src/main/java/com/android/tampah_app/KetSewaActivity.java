package com.android.tampah_app;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class KetSewaActivity extends AppCompatActivity implements OnClickListener {
    private EditText etFromDate;
    private EditText etToDate;
    private EditText etNote;
    private Button bPlaceOrder;
    private SharedPreferences prefs;

    private DatePickerDialog fromDatePickerDialog;
    private DatePickerDialog toDatePickerDialog;

    private SimpleDateFormat dateFormatter;
    private Date startDate, endDate;
    private Data data;
    private long days;
    private Date date;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setTitle("");
        setContentView(R.layout.activity_ket_sewa);

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

        findViewsById();

        try{
            position = data.getPosition();
        } catch (Exception e){
            e.printStackTrace();
        }

        bPlaceOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkValue();
            }
        });

        setDateTimeField();

        /*prefs = getSharedPreferences("DATA_SEWA", MODE_PRIVATE);

        String fromDate = prefs.getString("DARI_TANGGAL", "");
        String toDate = prefs.getString("SAMPAI_TANGGAL","");
        String note = prefs.getString("CATATAN","");*/

    }

    private void findViewsById() {
        etFromDate = (EditText) findViewById(R.id.etFromDate);
        etFromDate.setInputType(InputType.TYPE_NULL);
        etFromDate.requestFocus();

        etToDate = (EditText) findViewById(R.id.etToDate);
        etToDate.setInputType(InputType.TYPE_NULL);

        etNote = (EditText) findViewById(R.id.etNote);

        bPlaceOrder = (Button) findViewById(R.id.bConfirm2);
    }
    private void setDateTimeField() {
        etFromDate.setOnClickListener(this);
        etToDate.setOnClickListener(this);

        Calendar newCalendar = Calendar.getInstance();
        fromDatePickerDialog = new DatePickerDialog(this, new OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                etFromDate.setText(dateFormatter.format(newDate.getTime()));
                startDate = newDate.getTime();
                if (Data.startDate2[position] == null) {
                    Data.startDate2[position] = startDate;
                } else if (startDate.getTime() < Data.startDate2[position].getTime()) {
                    Toast.makeText(KetSewaActivity.this,
                            "Tanggal yang Anda masukkan tidak valid",
                            Toast.LENGTH_SHORT).show();
                    bPlaceOrder.setEnabled(false);
                } else if (startDate.getTime() >= Data.startDate2[position].getTime() && startDate.getTime() <= Data.endDate2[position].getTime() ) {
                    Toast.makeText(KetSewaActivity.this,
                            "Barang tidak tersedia",
                            Toast.LENGTH_SHORT).show();
                    bPlaceOrder.setEnabled(false);
                } else {
                    bPlaceOrder.setEnabled(true);
                    Data.startDate2[position] = startDate;
                }
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        toDatePickerDialog = new DatePickerDialog(this, new OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                etToDate.setText(dateFormatter.format(newDate.getTime()));
                endDate = newDate.getTime();
                Data.endDate2[position] = endDate;
                if (startDate.getTime() > endDate.getTime()) {
                    Toast.makeText(KetSewaActivity.this,
                            "Tanggal yang Anda masukkan tidak valid",
                            Toast.LENGTH_SHORT).show();
                    bPlaceOrder.setEnabled(false);
                }
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }

    private void checkValue() {

        String fromDate = etFromDate.getText().toString();
        String toDate = etToDate.getText().toString();


        if ( fromDate.isEmpty() || toDate.isEmpty() ) {

            // Error , one or more editText are empty
            Toast.makeText(KetSewaActivity.this,
                    "Kolom yang Anda isikan tidak lengkap",
                    Toast.LENGTH_SHORT).show();
        }

        else
        {
            // all editText are not empty
            days = endDate.getTime() - startDate.getTime();
            String fixDays = String.valueOf(TimeUnit.DAYS.convert(days, TimeUnit.MILLISECONDS));
            Intent placeOrderIntent = new Intent(KetSewaActivity.this, InvoiceActivity.class);
            placeOrderIntent.putExtra("days",fixDays);
            placeOrderIntent.putExtra("index",position);
            placeOrderIntent.putExtra("start",dateFormatter.format(startDate));
            placeOrderIntent.putExtra("end",dateFormatter.format(endDate));
            KetSewaActivity.this.startActivity(placeOrderIntent);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_drawer_menu_drawer, menu);
        return true;
    }

    @Override
    public void onClick(View view) {
        if(view == etFromDate) {
            fromDatePickerDialog.show();
        } else if(view == etToDate) {
            toDatePickerDialog.show();
        }
    }

    public void saveData(View view){
        String fromDate = etFromDate.getText().toString();
        String toDate = etToDate.getText().toString();
        String note = etNote.getText().toString();

        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("DARI_TANGGAL", fromDate);
        editor.putString("SAMPAI_TANGGAL", toDate);
        editor.putString("CATATAN", note);
        editor.apply();




        }


    }






