package com.qianhaijian.learnConcurrency.example.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 前路漫漫还相见 on 2019/4/8.
 */
public class SynchronizedExample2 {

    public void test0() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }

    public static void test1(int j) {
        synchronized (SynchronizedExample2.class) {
            for (int i = 0; i < 100; i++) {
                System.out.println(j + "--->" + i);
            }
        }
    }

    public static synchronized void test2(int j) {
        for (int i = 0; i < 100; i++) {
            System.out.println(j + "--->" + i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample2 example1 = new SynchronizedExample2();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            example1.test2(1);
        });
        executorService.execute(() -> {
            example1.test2(2);
        });

    }

}
