package com.safeshake3.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.safeshake3.R;

public class PasswordActivity extends AppCompatActivity {
    TextView website;
    TextView username;
    TextView password;
    Button cancel,edit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        Intent intent = getIntent();
        String websiteValue = intent.getStringExtra("website");
        String usernameValue = intent.getStringExtra("website");
        String passwordValue = intent.getStringExtra("website");

        website = (TextView) findViewById(R.id.passwordDetails_website_value);
        username = (TextView) findViewById(R.id.passwordDetails_username_value);
        password = (TextView) findViewById(R.id.passwordDetails_password_value);
        cancel = (Button) findViewById(R.id.passwordDetails_cancelBtn);


        website.setText(websiteValue);
        username.setText(usernameValue);
        password.setText(passwordValue);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToValut();
            }
        });
    }


    private void goToValut() {
        Intent intent = new Intent(this, Vault.class);
        startActivity(intent);
    }


}