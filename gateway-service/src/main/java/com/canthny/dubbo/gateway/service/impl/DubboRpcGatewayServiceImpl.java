package com.canthny.dubbo.gateway.service.impl;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.service.GenericService;
import com.alibaba.fastjson.JSON;
import com.canthny.dubbo.common.filter.gateway.DubboRpcGatewayReq;
import com.canthny.dubbo.common.filter.gateway.DubboRpcGatewayResp;
import com.canthny.dubbo.common.filter.gateway.DubboRpcGatewayService;
import com.canthny.dubbo.gateway.util.GsonUtil;

import java.util.Map;

@Service
public class DubboRpcGatewayServiceImpl implements DubboRpcGatewayService {

    @Override
    public DubboRpcGatewayResp callInnerService(DubboRpcGatewayReq req) {
        try{
            ReferenceConfig<GenericService> reference = new ReferenceConfig<GenericService>();
            // 当前dubbo consumer的application配置，不设置会直接抛异常
            ApplicationConfig applicationConfig = new ApplicationConfig();
            applicationConfig.setName("account-service");
            // 注册中心配置
            RegistryConfig registryConfig = new RegistryConfig();
            // 注册中心这里需要配置上注册中心协议，例如下面的zookeeper
            registryConfig.setAddress("zookeeper://127.0.0.1:2181");
            registryConfig.setClient("curator");
            reference.setApplication(applicationConfig);
            reference.setRegistry(registryConfig);
            // 设置调用的reference属性，下面只设置了协议、接口名、版本、超时时间
            reference.setProtocol(req.getProtocol());
            reference.setInterface(req.getInterfaceName());
            reference.setVersion(req.getVersion());
            reference.setTimeout(req.getTimeout());
            reference.setGeneric(true);
            // GenericService可以接住所有的实现

            GenericService genericService = reference.get();
            Object result = genericService.$invoke(req.getMethod(), req.getParamsType(), req.getParams());
            System.out.println(JSON.toJSONString(result));
            if(result!=null){
                //请求接口可以指定响应参数的class
                Class returnClazz = req.getReturnClazz();
                if(returnClazz==null){
                    //如果没有则直接从泛化调用的map结果里直接取也可以
                    String resultClassStr = (String)((Map)result).get("class");
                    returnClazz = Class.forName(resultClassStr);
                }
                //序列化成指定的class对象即可
                String returnJson = GsonUtil.toJsonString(result);
                result = GsonUtil.fromJson(returnClazz, returnJson);
            }
            return new DubboRpcGatewayResp(result);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
