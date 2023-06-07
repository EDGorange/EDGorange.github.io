package com.example.demo.multiThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @description: br
 * @author: wang.chengcheng
 * @create: 2023-05-30 15:19
 **/

public class MultiThread  implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Thread.sleep(20000);
        int i = 0;
        for (; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "" + i);
        }
        return i;
    }

    public static void main(String[] args) {
        MultiThread multiThread = new MultiThread();
        FutureTask futureTask = new FutureTask(multiThread);
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "循环变量i得值"+i);
            if (i == 20) {
                new Thread(futureTask, "有返回值得线程").start();
            }
        }
        try {
            System.out.println("子线程得返回值:"+ futureTask.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println("我跑完了");


       /* FutureTask futureTask1 = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                TimeUnit.SECONDS.sleep(20);
                return "我是子线程" + UUID.randomUUID().toString();
            }
        });

        new Thread(futureTask1).start();
        *//*System.out.println(futureTask1.get());
        System.out.println("我是主线程");*//*

        CompletableFuture<Object> objectCompletableFuture = CompletableFuture.completedFuture(futureTask1.get());
        System.out.println(objectCompletableFuture.get());
        System.out.println("我是主线程");
*/
       /* CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return UUID.randomUUID().toString();
        });
        stringCompletableFuture.whenComplete((uuid, exception) -> {
            System.out.println("----------------");
            System.out.println(uuid);
            System.out.println(Thread.currentThread().getName());
        });
        System.out.println("1111111");
        Thread.sleep(5000);
        System.out.println("2222222");*/

    }
}



