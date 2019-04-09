package com.qianhaijian.learnConcurrency.example.publish;

import com.qianhaijian.learnConcurrency.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by 前路漫漫还相见 on 2019/4/9.
 */
@NotThreadSafe
public class UnSafePublish {

    private String[] states = {"a", "b", "c"};

    public String[] getStates() {
        return states;
    }

    public static void main(String[] args) {
        UnSafePublish unSafePublish = new UnSafePublish();
        String[] states = unSafePublish.getStates();
        System.out.println(states.toString());

        states[0] = "d";
        System.out.println(states.toString());


    }

}
