package com.canthny.dubbo.account;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.alibaba.dubbo.registry.Registry;
import com.alibaba.dubbo.registry.RegistryFactory;
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
//        setLimit();
//        Thread.sleep(999999999);
    }

    public static void setLimit() {
        //获得注册工程的spi扩展实例
        RegistryFactory registryFactory = ExtensionLoader.getExtensionLoader(RegistryFactory.class).getAdaptiveExtension();
        //根据url的zookeeper，确定是zookeeper注册中心，通过ip和端口号，连上zookeeper注册中心
        Registry registry = registryFactory.getRegistry(URL.valueOf("zookeeper://127.0.0.1:2181"));
        //向注册中心写入配置规则
        registry.register(URL.valueOf("override://0.0.0.0/com.canthny.dubbo.account.api.AccountOperateService?tps=5&category=configurators"
        ));

    }
}
