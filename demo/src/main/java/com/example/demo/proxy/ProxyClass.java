package com.example.demo.proxy;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.intface.impl.Demo4DynamicProxyImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @description: br
 * @author: wang.chengcheng
 * @create: 2022-11-15 15:05
 **/

public class ProxyClass implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Demo4DynamicProxyImpl demo4DynamicProxy = new Demo4DynamicProxyImpl();
        //System.out.println(args);
        method.invoke(demo4DynamicProxy, "1111");
        return new JSONObject().put("代理类","1");
    }
}
