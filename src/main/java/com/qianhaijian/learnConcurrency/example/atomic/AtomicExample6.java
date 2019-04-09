package com.qianhaijian.learnConcurrency.example.atomic;

import com.qianhaijian.learnConcurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by 前路漫漫还相见 on 2019/4/8.
 */
@Slf4j
@ThreadSafe
public class AtomicExample6 {

    public static int clientTotal = 5000;
    public static int threadTotal = 200;
    public static AtomicBoolean isHappened = new AtomicBoolean(false);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    test();
                    semaphore.release();
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        countDownLatch.await();
        executorService.shutdown();
        System.out.println("status:" + isHappened);
    }

    private static void test() {
        if (isHappened.compareAndSet(false, true)) {
            System.out.println("happened");
        }
    }

}
