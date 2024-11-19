package com.bank.marketing.model;

import java.util.List;

public class Customer {
    private int id; // Unique customer ID
    private String name; // Customer's name
    private String email; // Customer's email
    private List<String> preferences; // Customer's marketing preferences

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<String> preferences) {
        this.preferences = preferences;
    }


}
