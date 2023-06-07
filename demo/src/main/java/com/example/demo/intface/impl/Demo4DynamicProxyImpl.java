package com.example.demo.intface.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.intface.Demo4DynamicProxy;
import org.springframework.stereotype.Service;

/**
 * @description: br
 * @author: wang.chengcheng
 * @create: 2022-11-15 15:04
 **/
@Service
public class Demo4DynamicProxyImpl implements Demo4DynamicProxy {
    @Override
    public JSONObject hello(String args) {
        JSONObject jsonObject = new JSONObject();
        int i = Integer.parseInt(args);
        jsonObject.put("args",i);
        return jsonObject;
    }
}
