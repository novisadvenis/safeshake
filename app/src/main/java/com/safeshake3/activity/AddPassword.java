package com.safeshake3.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.safeshake3.R;
import com.safeshake3.model.Password;

public class AddPassword extends AppCompatActivity {
    Button cancelBtn,saveBtn;
    TextView website,username,password,generateLink;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String passwordString = null;
        if(intent != null && (passwordString = intent.getStringExtra("password")) != null) {
            setContentView(R.layout.activity_add_password2);
            password = (TextView) findViewById(R.id.addPassword_password_value);
            password.setText(passwordString);
        } else {
            setContentView(R.layout.activity_add_password);
            generateLink = (TextView) findViewById(R.id.addPassword_generate_link);

            generateLink.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(AddPassword.this,Generator.class);
                    intent.putExtra("from","AddPassword");
                    startActivity(intent);
                }
            });
        }

        cancelBtn = (Button) findViewById(R.id.addPassword_cancelBtn);
        saveBtn = (Button) findViewById(R.id.addPassword_saveBtn);
        website = (TextView) findViewById(R.id.addPassword_website_value);
        username = (TextView) findViewById(R.id.addPassword_username_value);



        //Cancel Button
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToVault();
            }
        });

        //Save Button
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String newWebsiteString = website.getText().toString();
                String newUsernameString = username.getText().toString();
                String newPasswordString = password.getText().toString();

                // Eingabe Leer Validierung
                if (newWebsiteString.isEmpty()){
                    Toast.makeText(AddPassword.this, "website is empty", Toast.LENGTH_LONG).show();
                }else if (newUsernameString.isEmpty()){
                    Toast.makeText(AddPassword.this, "username is empty", Toast.LENGTH_LONG).show();
                }else if (newPasswordString.isEmpty()){
                    Toast.makeText(AddPassword.this, "password is empty", Toast.LENGTH_LONG).show();
                }
                else {
                    Password newPassword = new Password(newWebsiteString, newUsernameString, newPasswordString);
                    Password.save(newPassword);
                    //todo input check
                    goToVault();
                }

            }
        });

    }

    private void goToVault() {
        Intent intent = new Intent(this, Vault.class);
        startActivity(intent);
    }
}