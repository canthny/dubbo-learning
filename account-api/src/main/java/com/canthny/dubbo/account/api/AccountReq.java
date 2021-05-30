package com.canthny.dubbo.account.api;

import java.io.Serializable;

public class AccountReq implements Serializable {

    private Long id;

    private String accountNo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    @Override
    public String toString() {
        return "AccountReq{" +
                "id=" + id +
                ", accountNo='" + accountNo + '\'' +
                '}';
    }
}
