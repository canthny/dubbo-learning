package com.canthny.dubbo.common.filter.gateway;

public interface DubboRpcGatewayService {

    DubboRpcGatewayResp callInnerService(DubboRpcGatewayReq req);
}
