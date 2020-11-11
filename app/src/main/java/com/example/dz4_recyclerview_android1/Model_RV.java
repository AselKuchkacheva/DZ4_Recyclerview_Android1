package com.example.dz4_recyclerview_android1;

import java.io.Serializable;

public class Model_RV implements Serializable {
    private String name;

    public Model_RV(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
