package com.ricky.codelab;

import com.ricky.codelab.springmvc.domain.ConfigProperty;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.annotation.Resource;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2016-07-12 17:15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class AppTest {

    @Resource(name = "configProperty")
    private ConfigProperty configProperty;

    @Test
    public void testProperty(){

        System.out.println("name:"+configProperty.getName());
        System.out.println("age:"+configProperty.getAge());
        System.out.println("password:"+configProperty.getPassword());
    }
}
