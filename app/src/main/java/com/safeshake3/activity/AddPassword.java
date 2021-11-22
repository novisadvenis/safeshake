package com.safeshake3.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.safeshake3.R;

public class AddPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_password);
        Button cancelBtn = (Button) findViewById(R.id.addPassword_cancelBtn);


        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToVault();
            }
        });

    }

    private void goToVault() {
        Intent intent = new Intent(this, Vault.class);
        startActivity(intent);
    }
}