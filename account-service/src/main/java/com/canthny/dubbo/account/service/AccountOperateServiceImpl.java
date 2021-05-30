package com.canthny.dubbo.account.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONObject;
import com.canthny.dubbo.account.api.AccountInfo;
import com.canthny.dubbo.account.api.AccountOperateService;
import com.canthny.dubbo.account.api.AccountReq;

/**
 * @Author： Canthny
 * @Description： 账户操作类
 * @Date： Created in 2018/11/6 15:41
 */
@Service(timeout = 5000)
public class AccountOperateServiceImpl implements AccountOperateService{

    @Override
    public String operateAccount(String accountNo) {
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "operateAccount is success:"+accountNo;
    }

    @Override
    public AccountInfo getAccountInfo(AccountReq accountReq) {
        System.out.print(JSONObject.toJSONString(accountReq));
        return new AccountInfo(1L,"canthny","汤昊");
    }
}
