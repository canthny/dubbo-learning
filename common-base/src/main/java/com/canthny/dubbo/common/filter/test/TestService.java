package com.canthny.dubbo.common.filter.test;

import com.alibaba.dubbo.common.utils.PojoUtils;
import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestService {

    public ResultVo test(String t){
//        List<ResultDto> list = new ArrayList<>();
//        list.add(new ResultDto(1,"测试1"));
//        list.add(new ResultDto(2,"测试2"));

        return new ResultVo(1,new ResultDto(1,"测试1"));
    }

    public ResultDto test2(String t){
//        List<ResultDto> list = new ArrayList<>();
//        list.add(new ResultDto(1,"测试1"));
//        list.add(new ResultDto(2,"测试2"));

        return new ResultDto(1,"测试1");
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = TestService.class.getMethod("test", String.class);
//        List<ResultDto> list = new ArrayList<>();
//        list.add(new ResultDto(1,"测试1"));
//        list.add(new ResultDto(2,"测试2"));
//        Object object = PojoUtils.generalize(new ResultDto(1,"测试1")) ;
//        System.out.println(JSONObject.toJSONString(object));
//        Object object2 = PojoUtils.realize(object,method.getReturnType(),method.getGenericReturnType());
//        System.out.println(JSONObject.toJSONString(object2));

        Object object = PojoUtils.generalize(new ResultVo(1,new ResultDto(1,"测试1"))) ;
        System.out.println(JSONObject.toJSONString(object));
        String returnJson = GsonUtil.toJsonString(object);
        Object object3 = GsonUtil.fromJson(method.getReturnType(), returnJson);
        System.out.println(JSONObject.toJSONString(object3));
        Object object2 = PojoUtils.realize(object,method.getReturnType(),method.getGenericReturnType());
        System.out.println(JSONObject.toJSONString(object2));


//        Class clazz = ResultVo.class;
//        try {
////            clazz.newInstance();
//            Constructor[] c0=clazz.getConstructors();
//            for(Constructor t:c0){
//                System.out.println(JSONObject.toJSONString(t));
//                t.setAccessible(true);
//                int count = t.getParameterCount();
//                if(count>=0){
//                    Object[] o = new Object[count];
//                    t.newInstance(o);
//                }else{
//                    t.newInstance();
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

}
