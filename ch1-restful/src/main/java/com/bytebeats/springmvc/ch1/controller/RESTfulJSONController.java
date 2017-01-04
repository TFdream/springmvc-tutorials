package com.bytebeats.springmvc.ch1.controller;

import com.bytebeats.springmvc.ch1.domain.User;
import com.bytebeats.springmvc.ch1.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Spring MVC RESTful JSON
 *
 * @author Ricky Fung
 * @create 2016-07-13 11:41
 */
@Controller
@RequestMapping("/user")
public class RESTfulJSONController {

    @Autowired
    private IUserService userService;

    /**Spring MVC RESTful JSON**/
    @RequestMapping(value = "/view/{username}", method = RequestMethod.GET)
    @ResponseBody
    public User view(@PathVariable String username){

        System.out.println("view username:"+username);

        return userService.findUserByName(username);
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ResponseBody
    public User query(@RequestParam(value="username", required=true) String username){

        System.out.println("view username:"+username);

        return userService.findUserByName(username);
    }

}
