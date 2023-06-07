package com.example.demo.adstract;

/**
 * @description: br
 * @author: wang.chengcheng
 * @create: 2023-03-09 16:23
 **/

public abstract class ParentFactory {

    public ParentFactory nextNode;

    public ParentFactory setNextNode(ParentFactory fuckNextNode) {
        if (this.nextNode == null) {
            this.nextNode = fuckNextNode;
        }
        return nextNode;
    };

    public abstract boolean  checkResult(String success);
}