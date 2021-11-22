package com.safeshake3.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.safeshake3.R;

public abstract class ParentActivity  extends AppCompatActivity {

    protected abstract int getResourceLayoutId();
    protected abstract int getResourceMenuId();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getResourceLayoutId());

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation2);

        bottomNavigationView.setSelectedItemId(getResourceMenuId());

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.vault:
                        startActivity(new Intent(getApplicationContext(),
                                Vault.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.generator:
                        startActivity(new Intent(getApplicationContext(),
                                Generator.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.setting:
                        startActivity(new Intent(getApplicationContext(),
                                Setting.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
}
