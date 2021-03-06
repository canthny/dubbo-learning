package com.canthny.dubbo.account.api;

import java.io.Serializable;

public class AccountInfo implements Serializable {

    private Long id;

    private String accountNo;

    private String accountName;

    private AccountSubInfo accountSubInfo;

    public AccountInfo(Long id,String accountNo,String accountName,AccountSubInfo accountSubInfo){
        this.id = id;
        this.accountName = accountName;
        this.accountNo = accountNo;
        this.accountSubInfo = accountSubInfo;
    }

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

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public AccountSubInfo getAccountSubInfo() {
        return accountSubInfo;
    }

    public void setAccountSubInfo(AccountSubInfo accountSubInfo) {
        this.accountSubInfo = accountSubInfo;
    }

    @Override
    public String toString() {
        return "AccountInfo{" +
                "id=" + id +
                ", accountNo='" + accountNo + '\'' +
                ", accountName='" + accountName + '\'' +
                '}';
    }
}
