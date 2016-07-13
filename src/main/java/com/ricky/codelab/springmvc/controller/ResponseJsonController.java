package com.ricky.codelab.springmvc.controller;

import com.ricky.codelab.springmvc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2016-07-13 11:41
 */
@Controller
@RequestMapping("/json")
public class ResponseJsonController {

    @RequestMapping(value = "/view", method = RequestMethod.POST)
    @ResponseBody
    public User query(User user){

        System.out.println("query user:"+user);

        return user;
    }
}
