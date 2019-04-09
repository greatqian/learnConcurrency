package com.qianhaijian.learnConcurrency.example.publish;

import com.qianhaijian.learnConcurrency.annotations.NotRecommend;
import com.qianhaijian.learnConcurrency.annotations.NotThreadSafe;

/**
 * Created by 前路漫漫还相见 on 2019/4/9.
 */
@NotThreadSafe
@NotRecommend
public class Escape {

    private int thisCanBeEscape = 0;
    private String name = "Escape";

    public Escape () {
        new InnerClass();
    }

    public static void main(String[] args) {
        new Escape();
    }

    private class InnerClass {

        public InnerClass() {
            System.out.println(Escape.this.thisCanBeEscape);
            System.out.println(name);
        }

    }

}
