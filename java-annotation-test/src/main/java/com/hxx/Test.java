package com.hxx;

import com.hxx.model.Person;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * <ul>
 * <li>功能说明：</li>
 * <li>作者：tal on 2018/8/30 0030 14:40 </li>
 * <li>邮箱：houxiangxiang@cibfintech.com</li>
 * </ul>
 */

public class Test {
    public static void main(String[] args) {
        Person person = new Person();
        Class<? extends Person> personClass = person.getClass();
        // 打印 Class 的注解信息
        Annotation[] annotations = personClass.getAnnotations();
        printAnnotaitons(annotations);

        Method[] methods = personClass.getMethods();
        if (methods != null) {
            for (Method method : methods) {
                // 打印方法的注解信息
                Annotation[] methodAnnotations = method.getAnnotations();
                printAnnotaitons(methodAnnotations);
            }
        }
    }

    private static void printAnnotaitons(Annotation[] annotations) {
        if (annotations != null) {
            for (Annotation annotation : annotations) {
                System.out.println(annotation.toString());
            }
        }
    }
}
