package com.example.android_week_07;

import java.io.Serializable;

public class Travel implements Serializable {
    private int id;
    private String name;

    public Travel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Travel() {
    }

    public Travel(String name) {
        this.name = name;
    }

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
}
