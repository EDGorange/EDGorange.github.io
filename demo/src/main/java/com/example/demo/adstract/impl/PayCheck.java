package com.example.demo.adstract.impl;

import com.example.demo.adstract.ParentFactory;

/**
 * @description: br
 * @author: wang.chengcheng
 * @create: 2023-03-09 17:28
 **/

public class PayCheck extends ParentFactory {
    @Override
    public boolean checkResult(String success) {

        if ("success".equals(success)) {
            System.out.println("pay success");
            if (this.nextNode != null) {
                return this.nextNode.checkResult(success);
            }
        }
        return false;

    }
}
