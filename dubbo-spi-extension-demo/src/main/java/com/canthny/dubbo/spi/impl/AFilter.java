package com.canthny.dubbo.spi.impl;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.canthny.dubbo.spi.Filter;

/**
 * @Author： Canthny
 * @Description： Afilter实现类
 * @Date： Created in 2018/11/26 1:33
 */
@Activate
public class AFilter implements Filter{
    @Override
    public Object invoker() {
        return null;
    }
}
