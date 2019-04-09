package com.qianhaijian.learnConcurrency;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 前路漫漫还相见 on 2019/4/8.
 */
@Controller
@Slf4j
public class TestContoller {

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "test";
    }

}
