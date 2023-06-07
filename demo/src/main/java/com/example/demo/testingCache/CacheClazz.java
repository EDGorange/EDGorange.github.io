package com.example.demo.testingCache;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.util.concurrent.Callable;

/**
 * @description: br
 * @author: wang.chengcheng
 * @create: 2023-01-06 17:17
 **/

public class CacheClazz {

    private static Runnable myRunnable = new Runnable() {

        @Override
        public void run() {
            System.out.println("wo shi run fangfa");
        };
        public void testing123(){
            System.out.println("wo shi testing123");
        }
    };

    static class CacheLoaderCallable implements Callable<Table<String, String, String>> {
        private String cacheName;
        HashBasedTable<String, String, String> objectObjectObjectHashBasedTable = HashBasedTable.create();
        @Override
        public Table<String, String, String> call() throws Exception {
            objectObjectObjectHashBasedTable.put("1","1","1");
            System.out.println(objectObjectObjectHashBasedTable);
            cacheName = objectObjectObjectHashBasedTable.get("1","1");
            System.out.println(cacheName);
            return objectObjectObjectHashBasedTable;
        }
    }
    public static void getTesting(){
        System.out.println("wo shi getTesting");
        System.out.println(myRunnable.getClass());
    }
}
