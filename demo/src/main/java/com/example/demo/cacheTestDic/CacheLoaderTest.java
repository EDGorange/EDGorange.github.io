package com.example.demo.cacheTestDic;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @description: br
 * @author: wang.chengcheng
 * @create: 2023-01-09 16:15
 **/

public class CacheLoaderTest {
    private LoadingCache<Integer, AtomicLong> loadingCache ;
    private final static Integer KEY = 1000;


    private final static LinkedBlockingQueue<Integer> QUEUE = new LinkedBlockingQueue<>(1000);


    private void init() throws InterruptedException {
        loadingCache = CacheBuilder.newBuilder()
                .expireAfterWrite(2, TimeUnit.SECONDS)
                .removalListener(new RemovalListener<Object, Object>() {
                    @Override
                    public void onRemoval(RemovalNotification<Object, Object> notification) {
                    }
                })
                .build(new CacheLoader<Integer, AtomicLong>() {
                    @Override
                    public AtomicLong load(Integer key) throws Exception {
                        AtomicLong atomicLong = new AtomicLong(0);
                        System.out.println("woshi load wode key shi " + key+"woshi  cache save" + atomicLong);
                        return atomicLong;
                    }
                });



        for (int i = 10; i < 15; i++) {
            QUEUE.put(i);
        }
    }

    private void checkAlert(Integer integer) {
        try {

            //loadingCache.put(integer,new AtomicLong(integer));
            System.out.println(System.currentTimeMillis()/1000);
            TimeUnit.SECONDS.sleep(3);
            System.out.println(System.currentTimeMillis()/1000);

            long l = loadingCache.get(KEY).incrementAndGet();
            System.out.println("wo shi cache get wode key shi "+ KEY + "wode zhi shi " +l);

        } catch (ExecutionException e ) {
            System.out.println("e");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        CacheLoaderTest cacheLoaderTest = new CacheLoaderTest() ;
        cacheLoaderTest.init();



        while (true) {

            try {
                Integer integer = QUEUE.poll(200, TimeUnit.MILLISECONDS);
                if (null == integer) {
                    break;
                }
                //TimeUnit.SECONDS.sleep(5);
                cacheLoaderTest.checkAlert(integer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
