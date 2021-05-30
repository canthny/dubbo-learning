package com.canthny.dubbo.gateway;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@DubboComponentScan(basePackages = "com.canthny.dubbo.gateway")
public class GateWayStarter {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(GateWayStarter.class,args);
        Thread.sleep(999999999);
    }
}
