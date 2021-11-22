package com.safeshake3.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.safeshake3.R;
import com.safeshake3.model.Password;

public class EditPassword extends AppCompatActivity {
    private TextView website, username, password;
    private Button cancelBtn, saveBtn;
    private Password selectedPasswordObject;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_password);
        website = (TextView) findViewById(R.id.editPassword_website_value);
        username = (TextView) findViewById(R.id.editPassword_username_value);
        password = (TextView) findViewById(R.id.editPassword_password_value);
        cancelBtn = (Button) findViewById(R.id.editPassword_cancelBtn);
        saveBtn = (Button) findViewById(R.id.editPassword_saveBtn);

        Intent intent = getIntent();
        selectedPasswordObject = (Password) intent.getSerializableExtra("selectedPasswordObject");
        String websiteValue = selectedPasswordObject.getWebsite();
        String usernameValue = selectedPasswordObject.getUsername();
        String passwordValue = selectedPasswordObject.getPassword();

        website.setText(websiteValue);
        username.setText(usernameValue);
        password.setText(passwordValue);

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToVault();
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo input check
                selectedPasswordObject.setWebsite(website.getText().toString());
                selectedPasswordObject.setUsername(username.getText().toString());
                selectedPasswordObject.setPassword(password.getText().toString());
                Password.update(selectedPasswordObject);

                goToVault();
            }
        });


    }

    private void goToVault() {
        Intent intent = new Intent(this, Vault.class);
        startActivity(intent);
    }
}