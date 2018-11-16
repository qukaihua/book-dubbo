package com.qu.Dto;

import java.io.Serializable;

/**
 * Created by 96283 on 2018/11/16.
 */
public class CaptchaDto implements Serializable{
    private byte[] bytes;
    private String text;

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
