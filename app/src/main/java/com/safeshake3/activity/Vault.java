package com.safeshake3.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.orm.SugarContext;
import com.safeshake3.R;
import com.safeshake3.model.Password;

import java.util.List;
import java.util.stream.Collectors;

public class Vault extends ParentActivity {
    final int MENU_ID = R.id.vault;
    final int LAYOUT_ID = R.layout.activity_vault;
    SearchView searchView;
    ListView listView;
    List<Password> list;
    List<String> websiteList;
    Button addPassword;


    @Override
    protected int getResourceLayoutId() {
        return LAYOUT_ID;
    }

    @Override
    protected int getResourceMenuId() {
        return MENU_ID;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchView = (SearchView) findViewById(R.id.searchView);
        listView = (ListView) findViewById(R.id.lv1);
        addPassword = (Button) findViewById(R.id.settingAddBtn);

        SugarContext.init(this);
        //Password.init();

        list = Password.listAll(Password.class);
        Log.d("INIT Password", list.toString());

        websiteList = list.stream().map(Password::getWebsite).collect(Collectors.toList());

        addPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToAddPassword();
            }
        });


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, websiteList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Password selectedPassword = list.get(position);
                Log.d("Password Selected",selectedPassword.toString());

                Intent intent = new Intent(Vault.this, PasswordActivity.class);
               /* intent.putExtra("website",selectedPassword.getWebsite());
                intent.putExtra("username",selectedPassword.getUsername());
                intent.putExtra("password",selectedPassword.getPassword());*/
                intent.putExtra("selectedPasswordObject", selectedPassword);

                startActivity(intent);

            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (list.contains(query)) {
                    adapter.getFilter().filter(query);
                } else {
                    Toast.makeText(Vault.this, "No Match found", Toast.LENGTH_LONG).show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
    }

    private void goToAddPassword() {
        Intent intent = new Intent(this,AddPassword.class);
        startActivity(intent);
    }

}