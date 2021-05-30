package com.canthny.dubbo.common.filter.gateway;

import java.io.Serializable;

public class DubboRpcGatewayResp implements Serializable {

    public DubboRpcGatewayResp(Object respData){
        this.respData = respData;
    }

    private Object respData;

    public Object getRespData() {
        return respData;
    }

    public void setRespData(Object respData) {
        this.respData = respData;
    }

    @Override
    public String toString() {
        return "DubboRpcGatewayResp{" +
                "respData=" + respData +
                '}';
    }
}
