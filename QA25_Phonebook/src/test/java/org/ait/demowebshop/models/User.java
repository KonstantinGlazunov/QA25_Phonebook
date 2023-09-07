package org.ait.demowebshop;

public class User {
    private String name;
    private String surname;
    private String email;
    private String password;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public User setName(String name) {
        return this;
    }

    public User setSurname(String surname) {
        return this;
    }

    public User setEmail(String email) {
        return this;
    }

    public User setPassword(String password) {
        return this;
    }
}