package com.canthny.dubbo.account.service;

import com.alibaba.dubbo.common.utils.PojoUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONObject;
import com.canthny.dubbo.account.api.AccountInfo;
import com.canthny.dubbo.account.api.AccountOperateService;
import com.canthny.dubbo.account.api.AccountReq;
import com.canthny.dubbo.account.api.AccountSubInfo;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author： Canthny
 * @Description： 账户操作类
 * @Date： Created in 2018/11/6 15:41
 */
@Service(timeout = 5000)
public class AccountOperateServiceImpl implements AccountOperateService{

    @Override
    public String operateAccount(String accountNo) {
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "operateAccount is success:"+accountNo;
    }

    @Override
    public AccountInfo getAccountInfo(AccountReq accountReq) {
        Class clazz = this.getClass();
        try {
            Method method = clazz.getMethod("getAccountInfo", AccountReq.class);
            Map<Object,Object> map = new HashMap<>();
            map.put("id",1L);
            map.put("accountNo","canthny");
            map.put("accountName","测试");
            map.put("class","com.canthny.dubbo.account.api.AccountInfo");
            Object object = PojoUtils.realize(map,method.getReturnType(),method.getGenericReturnType());
            System.out.println(JSONObject.toJSONString(object));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        System.out.print(JSONObject.toJSONString(accountReq));
        AccountInfo accountInfo = new AccountInfo(1L,"canhtny","测试",new AccountSubInfo("备注"));
        return accountInfo;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Class clazz = AccountOperateServiceImpl.class;
        Method method = clazz.getMethod("getAccountInfo", AccountReq.class);
        Object object1 = PojoUtils.generalize(new AccountInfo(1L,"ce","测试",new AccountSubInfo("备注")));
        Object object2 = PojoUtils.realize(object1,method.getReturnType(),method.getGenericReturnType());
        System.out.println(JSONObject.toJSONString(object2));
    }
}
