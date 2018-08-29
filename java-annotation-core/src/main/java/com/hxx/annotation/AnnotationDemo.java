package com.hxx.annotation;

import com.hxx.enums.UserType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <ul>
 * <li>功能说明：注解测试</li>
 * <li>作者：houxx on 2018/8/29 0029 16:50 </li>
 * <li>邮箱：hou_xiangxiang@126.com</li>
 * </ul>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AnnotationDemo {
    long time() default 0;

    int count() default 0;

    String name() default "XiaoMing";

    UserType userType() default UserType.SYSTEM_ADMIN;

}
