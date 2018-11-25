package com.canthny.dubbo.spi.impl;

import com.alibaba.dubbo.common.extension.Activate;
import com.canthny.dubbo.spi.TestSpiDemoService;

/**
 * @Author： Canthny
 * @Description： 同步实现方式
 * @Date： Created in 2018/11/25 23:14
 */
public class SynSpiDemoServiceImpl implements TestSpiDemoService{
    @Override
    public String testSpi() {
        return "testSpi use syn type";
    }
}
