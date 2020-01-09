package com.huawei.todo.controller;

import com.huawei.todo.bean.TestBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TestController {

    @GetMapping(path = "/test")
    public String test(){
        return "Works";
    }

    @GetMapping(path = "/test-bean")
    public TestBean testBean(){
        return new TestBean("Test Bean");
    }

    @GetMapping("/test/path-variable/{name}")
    public TestBean testBeanPathVariable(@PathVariable String name){
       // throw new RuntimeException("Something went wrong");
        return new TestBean(String.format("Test Bean, %s", name));
    }
}
