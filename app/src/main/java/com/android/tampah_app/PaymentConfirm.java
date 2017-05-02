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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class PaymentConfirm extends AppCompatActivity implements OnClickListener {
    private EditText etPayDate;
    private EditText etOrderID;
    private EditText etAccountOwner;
    private EditText etAmount;

    private Button bConfirm;
    /*private PopupWindow popupWindow;
    private LayoutInflater layoutInflater;

    private Context mContext;
    private Activity mActivity;

    private LinearLayout linearLayout;*/

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
                Intent thanksIntent = new Intent(PaymentConfirm.this, ThanksActivity.class);
                PaymentConfirm.this.startActivity(thanksIntent);
            }
        });

        //showThanksDialog();

    }

    private void findViewsById() {
        etOrderID = (EditText) findViewById(R.id.etOrderID);
        etAccountOwner = (EditText) findViewById(R.id.etAccountOwner);
        etAmount = (EditText) findViewById(R.id.etAmount);

        etPayDate = (EditText) findViewById(R.id.etPayDate);
        etPayDate.setInputType(InputType.TYPE_NULL);
        etPayDate.requestFocus();

        bConfirm = (Button) findViewById(R.id.bConfirm2);
        //bOK = (Button) findViewById(R.id.bOK);

        //linearLayout = (LinearLayout) findViewById(R.id.lin);
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

    private void showThanksDialog() {

       /* mContext = getApplicationContext();

        mActivity = PaymentConfirm.this;

        bConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
                View customView = inflater.inflate(R.layout.popup_thanks, null);

                popupWindow = new PopupWindow(
                        customView,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

                bOK.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view1) {
                        popupWindow.dismiss();
                    }
                });
            }
        });*/



        /*bConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.popup_thanks,null);

                popupWindow = new PopupWindow(container, 400, 400, true);
                popupWindow.showAtLocation(linearLayout, Gravity.CENTER, 500, 500);
            */
                /*AlertDialog.Builder mBuilder = new AlertDialog.Builder(PaymentConfirm.this);
                View mView = getLayoutInflater().inflate(R.layout.popup_thanks, null);

                bOK.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view1) {
                        Intent backToHomeIntent = new Intent(PaymentConfirm.this, MainActivity.class);
                        PaymentConfirm.this.startActivity(backToHomeIntent);
                    }
                });

                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();
            }
        });*/

/*
        public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(PaymentConfirm.this);
                View mView = getLayoutInflater().inflate(R.layout.popup_thanks, null);
                Button mOK = (Button) mView.findViewById(R.id.bOK);

                mOK.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent backToHomeIntent = new Intent(PaymentConfirm.this, MainActivity.class);
                        PaymentConfirm.this.startActivity(backToHomeIntent);
                    }
                });

                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();*/

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
