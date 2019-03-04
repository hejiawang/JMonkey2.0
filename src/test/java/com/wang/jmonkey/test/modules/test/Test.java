package com.wang.jmonkey.test.modules.test;

import com.xiaoleilu.hutool.date.DateUtil;

import java.util.Date;

public class Test {

    @org.junit.Test
    public void t(){
        System.out.println(DateUtil.now());
        // System.out.println(DateUtil.offsetDay(new Date(), -7).toString("yyyy-MM-dd"));
    }

}

