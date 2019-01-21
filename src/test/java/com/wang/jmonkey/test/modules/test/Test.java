package com.wang.jmonkey.test.modules.test;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class Test {

    @org.junit.Test
    public void t(){
        List<Us> list = new ArrayList<>();

        Us s = new Us();
        s.setName("asdf");
        list.add(s);

        Test.conver(list);
        System.out.println(list.get(0).getName());
    }

    public static void conver(List<Us> list) {
        List<Us> l = new ArrayList<>(list);
        Us s = l.get(0);

        Us sc = new Us();
        BeanUtils.copyProperties(s, sc);
        sc.setName("adfasdfasdf");
    }

}

class Us{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
