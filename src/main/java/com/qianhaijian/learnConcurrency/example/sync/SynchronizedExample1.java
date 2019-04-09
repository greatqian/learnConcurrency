package com.qianhaijian.learnConcurrency.example.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 前路漫漫还相见 on 2019/4/8.
 */
public class SynchronizedExample1 {

    public void test0() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }

    public void test1() {
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
            }
        }
    }

    public synchronized void test2() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample1 example1 = new SynchronizedExample1();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                example1.test2();
            });
        }

    }

}
