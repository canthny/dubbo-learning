package com.canthny.dubbo.account.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.canthny.dubbo.account.api.AccountOperateService;

/**
 * @Author： Canthny
 * @Description： 账户操作类
 * @Date： Created in 2018/11/6 15:41
 */
@Service(timeout = 5000)
public class AccountOperateServiceImpl implements AccountOperateService{

    @Override
    public String operateAccount(String accountNo) {
        return "operateAccount is success:"+accountNo;
    }
}
