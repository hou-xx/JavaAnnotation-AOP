package com.hxx.annotation;

import java.lang.annotation.*;

/**
 * <ul>
 * <li>功能说明：注解测试 -- 单属性</li>
 * <li>作者：houxx on 2018/8/29 0029 16:50 </li>
 * <li>邮箱：hou_xiangxiang@126.com</li>
 * </ul>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Author {
    String value();
}
