package com.hxx.model;

import com.hxx.annotation.AnnotationDemo;
import com.hxx.annotation.Author;
import com.hxx.enums.UserType;

/**
 * <ul>
 * <li>功能说明：</li>
 * <li>作者：tal on 2018/8/30 0030 14:59 </li>
 * <li>邮箱：hou_xiangxiang@126.com</li>
 * </ul>
 */
@Author("houxx")
public class Person {
    @AnnotationDemo(time = 1, count = 2, name = "admin", userType = UserType.SYSTEM_ADMIN)
    public void work() {
        System.out.println("Now,to work!");
    }
}
