package com.hxx.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * ApiDemoImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"}) //加载配置文件
public class ApiDemoTest {

    @Resource(name = "apiDemo")
    private ApiDemo apiDemo;

    @Test
    public void testWork() throws Exception {
        apiDemo.work(0);
    }


} 
