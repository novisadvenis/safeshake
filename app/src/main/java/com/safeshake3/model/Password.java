package com.safeshake3.model;

import com.orm.SugarRecord;

import org.passay.CharacterData;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Password extends SugarRecord implements Serializable {
    private Long id;
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

        if (!Objects.equals(website, password1.website))
            return false;
        if (!Objects.equals(username, password1.username))
            return false;
        return Objects.equals(password, password1.password);
    }

    @Override
    public int hashCode() {
        int result = website != null ? website.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public long save() {
        this.id =  super.save();
        return this.id;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public static String generatePassword(int length, boolean upper, boolean lower,boolean number,boolean special) {

        PasswordGenerator generator = new PasswordGenerator();
        List<CharacterRule> rules = new ArrayList<>();
        if(upper) {
            CharacterData uppercaseChars = EnglishCharacterData.UpperCase;
            CharacterRule upperCaseRule = new CharacterRule(uppercaseChars);
            upperCaseRule.setNumberOfCharacters(2);
            rules.add(upperCaseRule);
        }

        if(lower) {
            CharacterData lowercaseChars = EnglishCharacterData.LowerCase;
            CharacterRule lowercaseRule = new CharacterRule(lowercaseChars);
            lowercaseRule.setNumberOfCharacters(2);
            rules.add(lowercaseRule);
        }

        if(number) {
            CharacterData numberChars = EnglishCharacterData.Digit;
            CharacterRule numberRule = new CharacterRule(numberChars);
            numberRule.setNumberOfCharacters(2);
            rules.add(numberRule);
        }

        if(special) {
            CharacterData specialChars = new CharacterData() {
                public String getErrorCode() {
                    return "Error Detected";
                }

                public String getCharacters() {
                    return "!@#$%^&*()_+";
                }
            };
            CharacterRule specialRule = new CharacterRule(specialChars);
            rules.add(specialRule);
            specialRule.setNumberOfCharacters(2);
        }

        return generator.generatePassword(length,rules);
    }
}
