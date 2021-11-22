package com.safeshake3.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.safeshake3.R;

public class Setting extends ParentActivity {
    final int MENU_ID = R.id.setting;
    final int LAYOUT_ID = R.layout.activity_setting;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button cancelBtn = (Button) findViewById(R.id.setting_cancelBtn);

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToVault();
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