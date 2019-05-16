package com.canthny.dubbo.busi.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.rpc.RpcException;
import com.canthny.dubbo.account.api.AccountOperateService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeoutException;

/**
 * @Author： Canthny
 * @Description： 测试controller
 * @Date： Created in 2018/11/7 16:13
 */
@RestController
public class TestAction {

    @Reference(timeout = 1000,mock = "true")
//    @Reference
    AccountOperateService accountOperateService;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        String test="";
        try{
            test = accountOperateService.operateAccount("tanghao");
        }catch (RpcException e){
            //如果开了mock就不会抛异常
            e.printStackTrace();
        }
        return test;
    }
}
