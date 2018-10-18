package com.hxx.aop;

import com.hxx.annotation.AnnotationDemo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * <ul>
 * <li>功能说明：</li>
 * <li>作者：tal on 2018/10/17 0017 17:20 </li>
 * <li>邮箱：houxiangxiang@cibfintech.com</li>
 * </ul>
 */
public class SpringAspect {

    public Object doAround(ProceedingJoinPoint point) throws Throwable {
        System.out.println("---------------> ");
        MethodSignature methodSig = (MethodSignature) point.getSignature();
        AnnotationDemo annotation = methodSig.getMethod().getAnnotation(AnnotationDemo.class);
        System.out.println("---------------> " + annotation);
        return point.proceed();
    }
}
