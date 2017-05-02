package com.android.tampah_app;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    Button bRegister, bKTP;
    ImageView ivKTP;
    private static final int PICK_IMAGE = 100;
    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setTitle("");
        setContentView(R.layout.activity_register);

        bRegister = (Button) findViewById(R.id.bRegister);
        bKTP = (Button) findViewById(R.id.bUploadKTP);
        ivKTP = (ImageView) findViewById(R.id.ivKTP);

        bKTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkValue();
            }
        });
    }

    private void checkValue() {
        final EditText etName = (EditText) findViewById(R.id.etName);
        final EditText etEmail = (EditText) findViewById(R.id.etEmail);
        final EditText etAddress = (EditText) findViewById(R.id.etAddress);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final EditText etConfirmPW = (EditText) findViewById(R.id.etConfirmPW);
        final EditText etPhone = (EditText) findViewById(R.id.etPhone);

        String name = etName.getText().toString();
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        String confirmPW = etConfirmPW.getText().toString();
        String phone = etPhone.getText().toString();
        String address = etAddress.getText().toString();

        if ( name.isEmpty() || email.isEmpty() || password.isEmpty() ||
                confirmPW.isEmpty() || phone.isEmpty() || address.isEmpty() ) {

            // Error , one or more editText are empty
            Toast.makeText(RegisterActivity.this,
                    "Kolom yang Anda isikan tidak lengkap",
                    Toast.LENGTH_SHORT).show();
        }

        else if (!confirmPW.equals(password)) {
            Toast.makeText(RegisterActivity.this,
                    "Password yang Anda masukkan tidak sama",
                    Toast.LENGTH_SHORT).show();
        }


        else if (ivKTP.getDrawable() == null) {
            Toast.makeText(RegisterActivity.this,
                    "Anda belum mengambil foto KTP",
                    Toast.LENGTH_SHORT).show();
        }

        else
        {
            // all editText are not empty
            Intent loginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
            RegisterActivity.this.startActivity(loginIntent);
        }

    }

    private void openGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            imageUri = data.getData();
            ivKTP.setImageURI(imageUri);

        }
    }


}
