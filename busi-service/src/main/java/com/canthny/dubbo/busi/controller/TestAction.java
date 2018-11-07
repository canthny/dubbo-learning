package com.canthny.dubbo.busi.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.canthny.dubbo.account.api.AccountOperateService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author： Canthny
 * @Description： 测试controller
 * @Date： Created in 2018/11/7 16:13
 */
@RestController
public class TestAction {

    @Reference
    AccountOperateService accountOperateService;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        return accountOperateService.operateAccount("tanghao");
    }
}
