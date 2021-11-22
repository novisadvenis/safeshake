package com.safeshake3.model;

import androidx.annotation.Nullable;

import com.orm.SugarRecord;

import java.io.Serializable;
import java.util.Objects;

public class Password extends SugarRecord implements Serializable {
    private String website;
    private String username;
    private String password;

    public Password() {
    }

    public Password(String website, String username, String password) {
        this.website = website;
        this.username = username;
        this.password = password;
    }

    public static void init() {
        for (int i = 10; i < 20; i++) {
            String website = "website"+i;
            String username = "username"+i;
            String passwordString = "password"+i;
            Password password = new Password(website,username,passwordString);
            password.save();
        }
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Password{" +
                "website='" + website + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Password password1 = (Password) o;
        return website.equals(password1.website) && username.equals(password1.username) && password.equals(password1.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(website, username, password);
    }
}
