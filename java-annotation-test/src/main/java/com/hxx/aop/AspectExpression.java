package com.hxx.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * <ul>
 * <li>功能说明：AspectJ Pointcut expression demo</li>
 * <li>作者：tal on 2018/10/22 0022 15:18 </li>
 * <li>邮箱：hou_xiangxiang@126.com</li>
 * </ul>
 */
@Aspect
@Component
public class AspectExpression {

    @Pointcut("execution(* com.hxx.api.impl.*.*(*)))")
    public void doPointExecution() {
    }

    @Pointcut("within(com.hxx.api.impl.*)")
    public void doPointWithIn() {
    }

    @Pointcut("this(com.hxx.api.ApiDemo)")
    public void doPointThis() {
    }

    /**
     * 围绕 切入点执行的方法
     *
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("doPointThis()")
    public Object doAround(ProceedingJoinPoint point) throws Throwable {
        System.out.println("---------------> around start");
        Object proceed = 0;
        try {
            proceed = point.proceed();
        } catch (Throwable throwable) {
            throw throwable;
        }
        System.out.println("---------------> around end");
        return proceed;
    }

}

