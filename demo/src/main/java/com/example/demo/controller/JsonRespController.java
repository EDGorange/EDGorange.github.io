package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.abstractClass.SpringContext;
import com.example.demo.intface.Demo4DynamicProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: br
 * @author: wang.chengcheng
 * @create: 2022-11-17 13:36
 **/

@RestController
@RequestMapping("/test/")
public class JsonRespController {
    @Autowired
    private Demo4DynamicProxy demo4DynamicProxy;
    /*@Autowired
    private ThreadService threadService;*/
    @RequestMapping(value = "error/v1", method = RequestMethod.POST)
    public JSONObject testErrorResp(@RequestBody JSONObject params){
     return new JSONObject();
    }

    @RequestMapping(value = "thread/v1", method = RequestMethod.GET)
    public JSONObject testThereadLocal(@RequestParam(value = "requstNo") String requstNo) {
        ApplicationContext applicationContext = SpringContext.getApplicationContext();
        Object threadService = applicationContext.getBean("threadService");

        System.out.println(threadService);
        //JSONObject localMap = threadService.getLocalMap(requstNo);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("122", threadService);
        return jsonObject;
    }
}
