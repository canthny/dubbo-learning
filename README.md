# dubbo-learning
## dubbo调用demo，springboot+dubbo整合
account-service账户服务提供者
busi-service业务服务提供者（调用账户服务）
account-api接口
common-base基础工具包

## dubbo源码学习

### dubbo-spi-extesion-demo，dubbo的spi扩展功能源码学习
ExtensionLoader
    --getExtensionLoader
        --getAdaptiveExtension


### ------------------------------服务暴露--------------------------------------

ServiceConfig实现ApplicationListener#onApplicationEvent（E event）方法
--export()->doExport(){
	...
	appendProperties();
	doExportUrls();

	..
}

//生成url，注册地址
registry://127.0.0.1:2181/com.alibaba.dubbo.registry.RegistryService?application=account-service&client=curator&dubbo=2.6.2&pid=5196&registry=zookeeper&timestamp=1543132199600

**local调用**

injvm://127.0.0.1/com.canthny.dubbo.account.api.AccountOperateService?anyhost=true&application=account-service&bind.ip=192.168.125.1&bind.port=20880&dubbo=2.6.2&generic=false&interface=com.canthny.dubbo.account.api.AccountOperateService&methods=operateAccount&pid=9680&side=provider&timeout=5000&timestamp=1543133608542

**远程调用**

DubboProtocol
	#export(Invoker<T> invoker)
		#openServer(url)#createServer(url)--默认使用netty
//监听地址
dubbo://192.168.125.1:20880/com.canthny.dubbo.account.api.AccountOperateService?anyhost=true&application=account-service&bind.ip=192.168.125.1&bind.port=20880&channel.readonly.sent=true&codec=dubbo&dubbo=2.6.2&generic=false&heartbeat=60000&interface=com.canthny.dubbo.account.api.AccountOperateService&methods=operateAccount&pid=9688&side=provider&timeout=5000&timestamp=1543140955500

### ------------------------------服务调用--------------------------------------
InvokerInvocationHandler#invoke（Object proxy,Method method,Object[] args）{
	...
	return invoker.invoke(new RpcInvocation(method, args)).recreate();
}

zookeeper://127.0.0.1:2181/com.alibaba.dubbo.registry.RegistryService?anyhost=true&application=busi-service&check=false&default.timeout=3000&dubbo=2.6.2&generic=false&interface=com.canthny.dubbo.account.api.AccountOperateService&methods=operateAccount&pid=6088&register.ip=192.168.125.1&remote.timestamp=1542816849522&side=consumer&timeout=5000&timestamp=1542816860959

MockClusterInvoker#invoke(Invocation rpcInvocation){
	
}