package com.hxx;

import com.hxx.annotation.AnnotationDemo;
import com.hxx.annotation.Author;
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
        // 打印 Class 上的注解信息
        Annotation[] annotations = personClass.getAnnotations();
        printAnnotaitons(annotations);

        Method[] methods = personClass.getMethods();
        if (methods != null) {
            for (Method method : methods) {
                // 打印 Method 上的注解信息
                Annotation[] methodAnnotations = method.getAnnotations();
                printAnnotaitons(methodAnnotations);
            }
        }
    }

    private static void printAnnotaitons(Annotation[] annotations) {
        if (annotations != null) {
            for (Annotation annotation : annotations) {
                System.out.println(annotation.toString());
                if (annotation instanceof Author) {
                    System.out.println("This is Author Annotation");
                    Author author = (Author) annotation;
                    System.out.println("Author is " + author.value());
                }
                if (annotation instanceof AnnotationDemo) {
                    System.out.println("This is AnnotationDemo Annotation");
                    AnnotationDemo demo = (AnnotationDemo) annotation;
                    System.out.println("AnnotationDemo.name is " + demo.name());
                    System.out.println("AnnotationDemo.count is " + demo.count());
                    System.out.println("AnnotationDemo.time is " + demo.time());
                    System.out.println("AnnotationDemo.userType is " + demo.userType());
                }
            }
        }

    }
}
