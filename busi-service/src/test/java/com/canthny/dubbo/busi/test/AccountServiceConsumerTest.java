package com.canthny.dubbo.busi.test;

import com.alibaba.dubbo.config.annotation.Reference;
import com.canthny.dubbo.account.api.AccountOperateService;
import com.canthny.dubbo.busi.BusiServiceStarter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author： Canthny
 * @Description： 账务服务消费者测试类
 * @Date： Created in 2018/11/6 19:49
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BusiServiceStarter.class)
public class AccountServiceConsumerTest {

    @Reference
    AccountOperateService accountOperateService;

    @Test
    public void testAccountOperateService(){
        System.out.println(accountOperateService.operateAccount("tanghao"));
    }
}
