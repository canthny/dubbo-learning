package com.canthny.dubbo.spi.test;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.canthny.dubbo.spi.Filter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Author： Canthny
 * @Description: Spi自动激活，适合集合类扩展点，如FilterChain加载
 * @Date： Created in 2018/11/26 1:35
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpiActivateTest.class)
public class SpiActivateTest {

    @Test
    public void test1(){
        ExtensionLoader<Filter> loader = ExtensionLoader.getExtensionLoader(Filter.class);
        URL url = URL.valueOf("http://127.0.0.1/index?test=bfilter");
        List<Filter> list = loader.getActivateExtension(url,"test","");
        System.out.println(list);
    }
}
