package com.safeshake3.model;

import com.orm.SugarRecord;

import java.io.Serializable;

public class AppPassword extends SugarRecord implements Serializable {
    private long id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppPassword that = (AppPassword) o;

        return password != null ? password.equals(that.password) : that.password == null;
    }

    @Override
    public int hashCode() {
        return password != null ? password.hashCode() : 0;
    }

    @Override
    public long save() {
        this.id = super.save();
        return this.id;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
