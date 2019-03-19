package com.canthny.dubbo.account.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.canthny.dubbo.account.api.AccountOperateService;
import org.apache.commons.lang.RandomStringUtils;

/**
 * @Author： Canthny
 * @Description： 账户操作类
 * @Date： Created in 2018/11/6 15:41
 */
@Service(timeout = 5000,path = "/hessian/test")
public class AccountOperateServiceImpl implements AccountOperateService{

    @Override
    public String operateAccount(String accountNo) {
        return RandomStringUtils.randomAlphanumeric(500*1024);
    }
}
