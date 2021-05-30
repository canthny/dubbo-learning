package com.canthny.dubbo.busi;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author： Canthny
 * @Description： 业务聚合服务启动类
 * @Date： Created in 2018/11/6 17:09
 */
@SpringBootApplication
@DubboComponentScan(basePackages = {"com.canthny.dubbo.busi","com.canthny.dubbo.account.api"})
public class BusiServiceStarter {

    public static void main(String[] args) {
        SpringApplication.run(BusiServiceStarter.class,args);
    }
}
