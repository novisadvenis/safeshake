package com.safeshake3.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.safeshake3.R;

public class EditPassword extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_password);
        Button cancelBtn = (Button) findViewById(R.id.editPassword_cancelBtn);


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