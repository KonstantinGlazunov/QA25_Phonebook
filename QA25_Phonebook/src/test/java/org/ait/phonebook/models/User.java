package org.ait.phonebook;

public class User {
    private String email;
    private String pass;

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public User setPass(String pass) {
        this.pass = pass;
        return this;

    }
}
