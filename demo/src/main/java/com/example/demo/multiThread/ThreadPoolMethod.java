package com.example.demo.multiThread;

/**
 * @description: br
 * @author: wang.chengcheng
 * @create: 2023-05-30 15:51
 **/

public class ThreadPoolMethod {


    static class MyThread1 implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "正在执行--------");

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        /*ArrayBlockingQueue<Runnable> runnables = new ArrayBlockingQueue<>(20);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 5, 50, TimeUnit.MILLISECONDS, runnables);
        MyThread1 myThread1 = new MyThread1();
        MyThread1 myThread2 = new MyThread1();
        MyThread1 myThread3 = new MyThread1();
        MyThread1 myThread4 = new MyThread1();
        MyThread1 myThread5 = new MyThread1();

        threadPoolExecutor.execute(myThread1);
        threadPoolExecutor.execute(myThread2);
        threadPoolExecutor.execute(myThread3);
        threadPoolExecutor.execute(myThread4);
        threadPoolExecutor.execute(myThread5);

        threadPoolExecutor.shutdown();

        System.out.println(Runtime.getRuntime().availableProcessors());*/
        Ticket ticket = new Ticket();

        new Thread(()-> { for (int i = 0; i < 60; i++) ticket.sale(); },"A").start();
        new Thread(()-> { for (int i = 0; i < 60; i++) ticket.sale(); },"B").start();
        new Thread(()-> { for (int i = 0; i < 60; i++) ticket.sale(); },"C").start();
        new Thread(()-> { for (int i = 0; i < 60; i++) ticket.sale(); },"D").start();


    }

}
class Ticket {
    private static int number = 50;

    //卖票方式
    public synchronized void sale() {
        if (number > 0) {
            System.out.println(Thread.currentThread().getName() + "购买了第" + (number--) + "张票,剩余票数为" + number);
        }
    }
}



