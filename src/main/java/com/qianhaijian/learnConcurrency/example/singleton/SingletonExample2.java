package com.qianhaijian.learnConcurrency.example.singleton;

import com.qianhaijian.learnConcurrency.annotations.NotThreadSafe;
import com.qianhaijian.learnConcurrency.annotations.ThreadSafe;

/**
 * Created by 前路漫漫还相见 on 2019/4/9.
 */
/*
    饿汉模式
    多线程环境下线程安全
 */
@ThreadSafe
public class SingletonExample2 {

    private SingletonExample2() {

    }

    private static SingletonExample2 instance = new SingletonExample2();

    public static SingletonExample2 getInstance() {
        return instance;
    }

}
