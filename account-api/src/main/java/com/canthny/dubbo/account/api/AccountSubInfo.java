package com.canthny.dubbo.account.api;

import java.io.Serializable;

public class AccountSubInfo implements Serializable {

    public AccountSubInfo(String ext){
        this.ext = ext;
    }

    private String ext;

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }
}
