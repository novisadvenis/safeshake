package com.safeshake3.model;

import com.orm.SugarRecord;

public class AppPassword extends SugarRecord {
    private String password;


    public AppPassword() {
    }

    public AppPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
