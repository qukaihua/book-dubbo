package com.qu.Entity;

/**
 * Created by 96283 on 2018/11/7.
 */
public class Book {
    private int id;
    private String name;
    private String description;
    private String kc;
    private String status;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKc() {
        return kc;
    }

    public void setKc(String kc) {
        this.kc = kc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
