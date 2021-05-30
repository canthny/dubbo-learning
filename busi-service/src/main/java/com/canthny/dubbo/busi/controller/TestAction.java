package com.canthny.dubbo.busi.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.fastjson.JSONObject;
import com.canthny.dubbo.account.api.AccountInfo;
import com.canthny.dubbo.account.api.AccountOperateService;
import com.canthny.dubbo.account.api.AccountReq;
import com.canthny.dubbo.common.filter.gateway.DubboRpcGatewayReq;
import com.canthny.dubbo.common.filter.gateway.DubboRpcGatewayResp;
import com.canthny.dubbo.common.filter.gateway.DubboRpcGatewayService;
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

//    @Reference(timeout = 1000,mock = "true")
    @Reference
    AccountOperateService accountOperateService;
    @Reference
    DubboRpcGatewayService dubboRpcGatewayService;

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

    @RequestMapping(value = "/testGateway",method = RequestMethod.GET)
    public String testGateway(){
        try{
            DubboRpcGatewayReq req = new DubboRpcGatewayReq();
            req.setInterfaceName("com.canthny.dubbo.account.api.AccountOperateService");
            req.setMethod("operateAccount");
            req.setReturnClazz(String.class);
            DubboRpcGatewayResp resp = dubboRpcGatewayService.callInnerService(req);
            System.out.print("testGatewayResp="+resp);
            return JSONObject.toJSONString(resp);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/testGateway2",method = RequestMethod.GET)
    public String testGateway2(){
        try{
            DubboRpcGatewayReq req = new DubboRpcGatewayReq();
            req.setInterfaceName("com.canthny.dubbo.account.api.AccountOperateService");
            req.setMethod("getAccountInfo");
            AccountReq accountReq = new AccountReq();
            accountReq.setAccountNo("canthny");
            accountReq.setId(1L);
            req.setParams(new Object[]{accountReq});
            req.setParamsType(new String[]{"com.canthny.dubbo.account.api.AccountReq"});
            req.setReturnClazz(AccountInfo.class);
            DubboRpcGatewayResp resp = dubboRpcGatewayService.callInnerService(req);
            System.out.print("testGatewayResp="+resp);
            return JSONObject.toJSONString(resp);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
