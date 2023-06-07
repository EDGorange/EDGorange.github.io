package com.example.demo.adstract;

/**
 * @description: br
 * @author: wang.chengcheng
 * @create: 2022-12-27 14:24
 **/

public class ChildTestName extends AbStractParent {
    @Override
    String getDescription() {
        return this.getTestName();
    }

    public static void main(String[] args) {
        ChildTestName childTestName = new ChildTestName();
        childTestName.setTestName("nihao");
        System.out.println(childTestName.getDescription());
    }
}
