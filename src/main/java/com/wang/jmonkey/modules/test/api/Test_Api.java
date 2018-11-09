package com.wang.jmonkey.modules.test.api;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class Test_Api {

    @GetMapping(value = "/list")
    @ResponseBody
    public List<String> test(){
        return new ArrayList<String>(){{
            add("string");
            add("string123");
        }};
    }

    @GetMapping(value = "/list2")
    @ResponseBody
    public List<String> test2(){
        return new ArrayList<String>(){{
            add("string2");
            add("string2");
        }};
    }

    @GetMapping(value = "/list3")
    @ResponseBody
    public List<String> test3(){
        return new ArrayList<String>(){{
            add("string3");
            add("string3");
        }};
    }
}
