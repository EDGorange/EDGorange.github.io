package com.example.demo.adstract;

/**
 * @description: br
 * @author: wang.chengcheng
 * @create: 2022-12-27 14:20
 **/

public abstract class  AbStractParent {
    public String testName;
    public String getTestName() {
        return testName;
    }
    abstract String getDescription();
    public void setTestName(String testName) {
        this.testName = testName;
    }
}
