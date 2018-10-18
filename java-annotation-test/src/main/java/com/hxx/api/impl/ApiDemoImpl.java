package com.hxx.api.impl;

import com.hxx.annotation.AnnotationDemo;
import com.hxx.api.ApiDemo;
import com.hxx.enums.UserType;

import org.springframework.stereotype.Service;

/**
 * <ul>
 * <li>功能说明：</li>
 * <li>作者：tal on 2018/10/18 0018 14:35 </li>
 * <li>邮箱：houxiangxiang@cibfintech.com</li>
 * </ul>
 */

@Service("apiDemo")
public class ApiDemoImpl implements ApiDemo {

    @AnnotationDemo(time = 1, count = 2, name = "admin", userType = UserType.SYSTEM_ADMIN)
    public void work() {
        System.out.println("------->> ApiDemo work");
        int a = 3/0;
    }

}
