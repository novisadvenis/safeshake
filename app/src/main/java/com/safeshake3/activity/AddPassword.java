package com.safeshake3.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.safeshake3.R;
import com.safeshake3.model.Password;

public class AddPassword extends AppCompatActivity {
    Button cancelBtn,saveBtn;
    TextView website,username,password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_password);
        cancelBtn = (Button) findViewById(R.id.addPassword_cancelBtn);
        saveBtn = (Button) findViewById(R.id.addPassword_saveBtn);
        website = (TextView) findViewById(R.id.addPassword_website_value);
        username = (TextView) findViewById(R.id.addPassword_username_value);
        password = (TextView) findViewById(R.id.addPassword_password_value);


        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToVault();
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newWebsiteString = website.getText().toString();
                String newUsernameString = username.getText().toString();
                String newPasswordString = password.getText().toString();
                Password newPassword = new Password(newWebsiteString,newUsernameString,newPasswordString);
                Password.save(newPassword);
                //todo input check
                goToVault();

            }
        });

    }

    private void goToVault() {
        Intent intent = new Intent(this, Vault.class);
        startActivity(intent);
    }
}