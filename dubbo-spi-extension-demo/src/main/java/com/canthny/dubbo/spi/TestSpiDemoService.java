package com.canthny.dubbo.spi;

import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.SPI;

/**
 * @Author： Canthny
 * @Description： 扩展点demo接口
 * @Date： Created in 2018/11/25 20:14
 */
@SPI("syn")
public interface TestSpiDemoService {

    @Adaptive
    String testSpi();
}
