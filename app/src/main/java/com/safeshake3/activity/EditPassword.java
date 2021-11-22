package com.safeshake3.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.safeshake3.R;
import com.safeshake3.model.Password;

public class EditPassword extends AppCompatActivity {
    private TextView website, username, password;
    private Button cancelBtn, saveBtn,deleteBtn;
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
        deleteBtn = (Button) findViewById(R.id.editPassword_deleteBtn);

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
                long id = selectedPasswordObject.getId();

                Password editedPassword = Password.findById(Password.class,id);
                editedPassword.setWebsite(website.getText().toString());
                editedPassword.setUsername(username.getText().toString());
                editedPassword.setPassword(password.getText().toString());
                editedPassword.save();

                goToVault();
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(EditPassword.this);
                builder.setCancelable(true);
                builder.setTitle("You want to delete this Password");
                builder.setMessage("Please be sure....");
                builder.setPositiveButton("Confirm",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                long id = selectedPasswordObject.getId();
                                Password.findById(Password.class,id).delete();
                                Log.d("Deleted",selectedPasswordObject.toString());
                                goToVault();
                            }
                        });
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


    }

    private void goToVault() {
        Intent intent = new Intent(this, Vault.class);
        startActivity(intent);
    }
}