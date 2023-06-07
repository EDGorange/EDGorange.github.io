package com.example.demo.abstractClass;

/**
 * @description: br
 * @author: wang.chengcheng
 * @create: 2022-11-17 14:11
 **/

public abstract class AbstractDemo {

    private static ThreadLocal<String> threadLocal = new ThreadLocal();

    public AbstractDemo() {
    }

    public static void setNbrTracingId(String id) {
        threadLocal.set(id);
    }

    public static String getNbrTracingId() {
        return (String)threadLocal.get();
    }

    public static void clearNbrId() {
        threadLocal.remove();
    }
}
