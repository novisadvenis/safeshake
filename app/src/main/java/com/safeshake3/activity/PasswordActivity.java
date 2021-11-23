package com.safeshake3.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.safeshake3.R;
import com.safeshake3.model.Password;

public class PasswordActivity extends AppCompatActivity {
    private TextView website, username, password;
    private Button cancelBtn, editBtn;
    private Password selectedPasswordObject;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        Intent intent = getIntent();
        selectedPasswordObject = (Password) intent.getSerializableExtra("selectedPasswordObject");
        String websiteValue = selectedPasswordObject.getWebsite();
        String usernameValue = selectedPasswordObject.getUsername();
        String passwordValue = selectedPasswordObject.getPassword();

        website = (TextView) findViewById(R.id.passwordDetails_website_value);
        username = (TextView) findViewById(R.id.passwordDetails_username_value);
        password = (TextView) findViewById(R.id.passwordDetails_password_value);
        cancelBtn = (Button) findViewById(R.id.passwordDetails_cancelBtn);
        editBtn = (Button) findViewById(R.id.passwordDetails_editBtn);


        website.setText(websiteValue);
        username.setText(usernameValue);
        password.setText(passwordValue);

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToVault();
            }
        });

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(PasswordActivity.this, EditPassword.class);
                intent1.putExtra("selectedPasswordObject",selectedPasswordObject);
                startActivity(intent1);
            }
        });
    }


    private void goToVault() {
        Intent intent = new Intent(this, Vault.class);
        startActivity(intent);
    }

    private void goToEditPassword() {
        Intent intent = new Intent(this, EditPassword.class);
        startActivity(intent);
    }


}