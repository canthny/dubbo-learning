package com.canthny.dubbo.account;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author： Canthny
 * @Description：
 * @Date： Created in 2018/11/6 16:06
 */
@SpringBootApplication
@DubboComponentScan(basePackages = "com.canthny.dubbo.account.service")
public class AccountServiceStarter {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(AccountServiceStarter.class,args);
        while (true){

        }
//        Thread.sleep(999999999);
    }
}
