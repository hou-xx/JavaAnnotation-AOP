package com.hxx.api.impl;

import com.hxx.annotation.AnnotationDemo;
import com.hxx.api.ApiDemo;
import com.hxx.enums.UserType;

import org.springframework.stereotype.Service;

@Service("apiDemo")
public class ApiDemoImpl implements ApiDemo {

    @AnnotationDemo(time = 1, count = 2, name = "admin", userType = UserType.SYSTEM_ADMIN)
    public int work(int input) {
        System.out.println("------->> ApiDemo work");
        return 3 / input;
    }

//    @AnnotationTwo("houxx")
    public int workTwo(int input) {
        System.out.println("------->> ApiDemo workTwo");
        return 5 / input;
    }

}
