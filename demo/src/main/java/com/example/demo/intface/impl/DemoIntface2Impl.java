package com.example.demo.intface.impl;

import com.example.demo.intface.DemoIntface2;

/**
 * @description: br
 * @author: wang.chengcheng
 * @create: 2022-11-15 16:06
 **/

public class DemoIntface2Impl implements DemoIntface2 {
    @Override
    public String invoke(String args) {
        return args;
    }
}
