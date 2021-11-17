package com.safeshake.model;

import com.orm.SugarRecord;

public class AppPassword extends SugarRecord {
    private String appPasswort;

    public AppPassword(String appPasswort) {
        this.appPasswort = appPasswort;
    }
    public AppPassword() {

    }

    public String getAppPasswort() {
        return appPasswort;
    }

    public void setAppPasswort(String appPasswort) {
        this.appPasswort = appPasswort;
    }
}
