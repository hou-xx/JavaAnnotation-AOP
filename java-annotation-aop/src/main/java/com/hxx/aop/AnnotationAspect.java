package com.hxx.aop;

import com.hxx.annotation.AnnotationTwo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * <ul>
 * <li>功能说明：</li>
 * <li>作者：tal on 2018/10/17 0017 17:20 </li>
 * <li>邮箱：houxiangxiang@cibfintech.com</li>
 * </ul>
 */
@Aspect
@Component
public class AnnotationAspect {

    /**
     * 定义切入点
     */
    @Pointcut("@annotation(com.hxx.annotation.AnnotationTwo)")
    public void doPoint() {
    }

    /**
     * 围绕 切入点 doPoint() 执行的方法
     *
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("doPoint()")
    public Object doAround(ProceedingJoinPoint point) throws Throwable {
        System.out.println("---------------> around start");
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        AnnotationTwo annotation = methodSignature.getMethod().getAnnotation(AnnotationTwo.class);
        System.out.println("annotation ---------------> " + annotation);
        Object proceed = 0;
        try {
            proceed = point.proceed();
        } catch (Throwable throwable) {
            throw throwable;
        }
        System.out.println("---------------> around end");
        return proceed;
    }

    /**
     * 被注解方法执行前执行的方法
     *
     * @param point
     */
    @Before("doPoint()")
    public void doBefore(JoinPoint point) {
        System.out.println("---------------> before ");
    }

    /**
     * 被注解方法执行前执行的方法
     *
     * @param point
     */
    @After("doPoint()")
    public void doAfter(JoinPoint point) {
        System.out.println("---------------> after");
    }

    /**
     * 后置异常通知：在方法抛出异常之后执行,可以访问到异常信息,且可以指定出现特定异常信息时执行代码
     *
     * @param point
     */
    @AfterThrowing(pointcut = "doPoint()", throwing = "throwable")
    public void afterThrowing(JoinPoint point, Throwable throwable) {
        System.out.println("---------------> afterThrowing");
        System.out.println(throwable.getMessage());
    }

    /**
     * @param point
     * @param returnValue
     */
    @AfterReturning(pointcut = "doPoint()", returning = "returnValue")
    public void afterReturning(JoinPoint point, int returnValue) {
        System.out.println("---------------> afterReturning +++ " + returnValue);
    }

}
