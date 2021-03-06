package com.hxx.aop;

import com.hxx.annotation.AnnotationDemo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * <ul>
 * <li>功能说明：使用 spring 的 XML 方式配置 AOP</li>
 * <li>作者：tal on 2018/10/17 0017 17:20 </li>
 * <li>邮箱：hou_xiangxiang@126.com</li>
 * </ul>
 */
public class SpringAspect {
    /**
     * 被注解方法执行前执行的方法
     *
     * @param point
     */
    public void doBefore(JoinPoint point) {
        System.out.println("---------------> before ");
    }

    public Object doAround(ProceedingJoinPoint point) throws Throwable {
        System.out.println("---------------> around start");
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        AnnotationDemo annotation = methodSignature.getMethod().getAnnotation(AnnotationDemo.class);
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
    public void doAfter(JoinPoint point) {
        System.out.println("---------------> after");
    }

    /**
     * 后置异常通知：在方法抛出异常之后执行,可以访问到异常信息,且可以指定出现特定异常信息时执行代码
     *
     * @param point
     */
    public void afterThrowing(JoinPoint point, Throwable throwable) {
        System.out.println("---------------> afterThrowing");
        System.out.println(throwable.getMessage());
    }

    /**
     * @param point
     * @param returnValue
     */
    public void afterReturning(JoinPoint point, int returnValue) {
        System.out.println("---------------> afterReturning +++ " + returnValue);
    }
}
