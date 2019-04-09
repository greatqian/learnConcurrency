package com.qianhaijian.learnConcurrency.example.singleton;

import com.qianhaijian.learnConcurrency.annotations.NotThreadSafe;
import com.qianhaijian.learnConcurrency.annotations.ThreadSafe;

/**
 * Created by 前路漫漫还相见 on 2019/4/9.
 */
/*
    懒汉模式
    使用synchronized关键字实现同时只能有一个线程访问getInstance方法，保证线程安全
    但是性能很差
 */
@ThreadSafe
public class SingletonExample3 {

    private SingletonExample3() {

    }

    private static SingletonExample3 instance = null;

    public synchronized static SingletonExample3 getInstance() {
        if (instance == null) {
            instance = new SingletonExample3();
        }
        return instance;
    }
git
}
