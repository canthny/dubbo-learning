package com.canthny.dubbo.spi.test;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.canthny.dubbo.spi.TestSpiDemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author： Canthny
 * @Description： spi扩展点加在测试类
 * @Date： Created in 2018/11/25 23:22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpiAdaptiveTest.class)
public class SpiAdaptiveTest {

    @Test
    public void test(){
        ExtensionLoader<TestSpiDemoService> loader = ExtensionLoader.getExtensionLoader(TestSpiDemoService.class);
        TestSpiDemoService testSpiDemoService = loader.getAdaptiveExtension();
        URL url = URL.valueOf("http://127.0.0.1/test?");
        System.out.println(testSpiDemoService.testSpi(url));
    }

    @Test
    public void test2(){
        ExtensionLoader<TestSpiDemoService> loader = ExtensionLoader.getExtensionLoader(TestSpiDemoService.class);
        TestSpiDemoService testSpiDemoService = loader.getAdaptiveExtension();
        URL url = URL.valueOf("http://127.0.0.1/test?type=asyn");
        System.out.println(testSpiDemoService.testSpi(url));
        URL url2 = URL.valueOf("http://127.0.0.1/test?type=syn");
        System.out.println(testSpiDemoService.testSpi(url2));
    }
}
