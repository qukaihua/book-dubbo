package com.qu.Dto;

import java.io.Serializable;

/**
 * Created by 96283 on 2018/11/7.
 */
public class BookSearchDto implements Serializable{
    private String name;
    private String description;
    private String kc;

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
}
