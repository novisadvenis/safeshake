package com.safeshake3.model;

import com.orm.SugarRecord;

import java.io.Serializable;

public class AppPassword extends SugarRecord implements Serializable {
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
