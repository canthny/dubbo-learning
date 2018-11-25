package com.canthny.dubbo.spi.impl;

import com.alibaba.dubbo.common.extension.Adaptive;
import com.canthny.dubbo.spi.TestSpiDemoService;

/**
 * @Author： Canthny
 * @Description： 异步实现方式
 * @Date： Created in 2018/11/25 23:16
 */
@Adaptive
public class AsynSpiDemoServiceImpl implements TestSpiDemoService{
    @Override
    public String testSpi() {
        return "testSpi use Asyn type";
    }
}
