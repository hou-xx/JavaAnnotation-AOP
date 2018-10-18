package com.hxx.aop;

import com.hxx.annotation.AnnotationDemo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * <ul>
 * <li>功能说明：</li>
 * <li>作者：tal on 2018/10/17 0017 17:20 </li>
 * <li>邮箱：houxiangxiang@cibfintech.com</li>
 * </ul>
 */
@Aspect
public class AnnotationAspect {

    @Around("@annotation(annotation)")
    public Object doAround(ProceedingJoinPoint point, AnnotationDemo annotation) throws Throwable {
        return point.proceed();
    }
}
