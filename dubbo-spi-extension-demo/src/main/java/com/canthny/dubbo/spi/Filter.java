package com.canthny.dubbo.spi;

import com.alibaba.dubbo.common.extension.SPI;

/**
 * @Author： Canthny
 * @Description： 自定义filter扩展点
 * @Date： Created in 2018/11/26 1:31
 */
@SPI
public interface Filter {

    Object invoker();
}
