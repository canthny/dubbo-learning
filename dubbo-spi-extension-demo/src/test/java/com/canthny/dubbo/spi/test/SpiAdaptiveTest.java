package com.canthny.dubbo.spi.test;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.canthny.dubbo.spi.TestSpiDemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author： Canthny
 * @Description： spi扩展点测试类
 * @Date： Created in 2018/11/25 23:22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpiAdaptiveTest.class)
public class SpiAdaptiveTest {

    @Test
    public void test(){
        ExtensionLoader<TestSpiDemoService> loader = ExtensionLoader.getExtensionLoader(TestSpiDemoService.class);
        TestSpiDemoService testSpiDemoService = loader.getAdaptiveExtension();
        System.out.println(testSpiDemoService.testSpi());
    }
}
