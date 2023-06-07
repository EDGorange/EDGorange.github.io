package com.example.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.util.WfThreadLocalMap;
import org.springframework.stereotype.Service;

/**
 * @description: br
 * @author: wang.chengcheng
 * @create: 2023-02-21 14:05
 **/

@Service

public class ThreadService {

        public JSONObject getLocalMap(String requstNo) {
            WfThreadLocalMap.set("requst", requstNo);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("requstNo", WfThreadLocalMap.get("requst"));
            return jsonObject;
        }
}
