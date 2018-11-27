package com.canthny.dubbo.spi;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.SPI;

/**
 * @Author： Canthny
 * @Description： 扩展点demo接口
 * @Date： Created in 2018/11/25 20:14
 */
@SPI("syn")
//注解里的value值表示当没有找到Adaptive类的时候取的默认值
public interface TestSpiDemoService {

    @Adaptive("type")
    String testSpi(URL url);
}
