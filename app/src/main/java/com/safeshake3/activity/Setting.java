package com.safeshake3.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.safeshake3.R;
import com.safeshake3.model.AppPassword;

public class Setting extends ParentActivity {
    final int MENU_ID = R.id.setting;
    final int LAYOUT_ID = R.layout.activity_setting;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EditText oldPassword = (EditText) findViewById(R.id.setting_oldPassword);
        AppPassword appPassword = AppPassword.findById(AppPassword.class, 1);
        Button cancelBtn = (Button) findViewById(R.id.setting_cancelBtn);
        Button saveBtn = (Button) findViewById(R.id.vault_AddBtn);
        EditText pass1 = (EditText) findViewById(R.id.setting_newPassword);
        EditText pass2 = (EditText) findViewById(R.id.setting_newPassword2);


        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToVault();
            }
        });


        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* if (pass1.getText().equals(null)&  pass2.getText().equals(null)){
                    Toast.makeText(Setting.this, "Password is empty", Toast.LENGTH_LONG).show();

                }else*/
                if (appPassword.getPassword().equals(oldPassword.getText().toString()) && pass2.getText().toString().equals(pass1.getText().toString())){
                    //todo update on apppassword changed
                    AppPassword tobeSaved = AppPassword.findById(AppPassword.class,appPassword.getId());
                    tobeSaved.setPassword(pass1.getText().toString());
                    tobeSaved.save();
                    Log.d("Password are Same","true");
                    goToVault();
                } else {
                Toast.makeText(Setting.this, "Password doesn't match", Toast.LENGTH_LONG).show();
            }
            }

        });

    }
    @Override
    protected int getResourceLayoutId() {
        return LAYOUT_ID;
    }

    @Override
    protected int getResourceMenuId() {
        return MENU_ID;
    }
    private void goToVault() {
        Intent intent = new Intent(this, Vault.class);
        startActivity(intent);
    }
}

