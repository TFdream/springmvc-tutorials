package com.bytebeats.spring.session.sample.controller;

import com.bytebeats.spring.session.sample.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-04-06 20:16
 */
@RestController
public class EchoController {

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public User query(String name, HttpServletRequest request, HttpSession session){

        System.out.println(session);

        User user = new User();
        user.setId(15L);
        user.setName(name);
        user.setPassword("root");
        user.setAge(28);

        session.setAttribute("user", user);

        return user;
    }
}
