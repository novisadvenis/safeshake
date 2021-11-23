package com.safeshake3.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.orm.SugarContext;
import com.safeshake3.R;
import com.safeshake3.model.AppPassword;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SugarContext.init(this);


        AppPassword appPassword = AppPassword.findById(AppPassword.class,1);
        if(appPassword == null) {
            setContentView(R.layout.login);

            EditText pass1 = (EditText) findViewById(R.id.login_password3);
            EditText pass2 = (EditText) findViewById(R.id.login_password2);
            Button loginBtn = (Button) findViewById(R.id.login_button);


            //login Button
            loginBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(pass1.getText().toString().equals(pass2.getText().toString())) {
                        goToVault();
                        //password saved
                        new AppPassword(pass1.getText().toString()).save();
                        Log.d("Password are Same","true");
                    } else {
                        Toast.makeText(Login.this, "Password doesn't match", Toast.LENGTH_LONG).show();
                    }
                }
            });
        } else  {
            setContentView(R.layout.login2);
            EditText pass = (EditText) findViewById(R.id.login_password3);
            Button loginBtn = (Button) findViewById(R.id.login_button);

            loginBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(appPassword.getPassword().equals(pass.getText().toString())) {
                        goToVault();
                        Log.d("Password are Same","true");
                    } else {
                        Toast.makeText(Login.this, "Password is incorrect", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }

    }

    private void goToVault() {
        Intent intent = new Intent(this, Vault.class);
        startActivity(intent);
    }
}
