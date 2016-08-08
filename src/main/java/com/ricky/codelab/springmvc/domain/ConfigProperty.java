package com.ricky.codelab.springmvc.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2016-08-08 15:49
 */
@Component("configProperty")
public class ConfigProperty {

    @Value("#{config[name]}")
    private String name;

    @Value("#{config[age]}")
    private Integer age;

    @Value("#{config[password]}")
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
