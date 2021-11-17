package com.safeshake.model;

import com.orm.SugarRecord;

public class Password extends SugarRecord {
    public Password(String password, String username, String website) {
        this.password = password;
        this.username = username;
        this.website = website;
    }

    public Password(){

    }

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    private String username;
    private String website;

}
