package com.qianhaijian.learnConcurrency.example.singleton;

import com.qianhaijian.learnConcurrency.annotations.NotThreadSafe;

/**
 * Created by 前路漫漫还相见 on 2019/4/9.
 */
/*
    懒汉模式
    多线程环境下不安全
 */
@NotThreadSafe
public class SingletonExample1 {

    private SingletonExample1() {

    }

    private static SingletonExample1 instance = null;

    public static SingletonExample1 getInstance() {
        if (instance == null) {
            instance = new SingletonExample1();
        }
        return instance;
    }

}
