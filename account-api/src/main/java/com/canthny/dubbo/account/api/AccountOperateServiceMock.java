package com.canthny.dubbo.account.api;

public class AccountOperateServiceMock implements AccountOperateService{
    @Override
    public String operateAccount(String accountNo) {
        return "mock is open,return null";
    }

    @Override
    public AccountInfo getAccountInfo(AccountReq accountReq) {
        return null;
    }
}
