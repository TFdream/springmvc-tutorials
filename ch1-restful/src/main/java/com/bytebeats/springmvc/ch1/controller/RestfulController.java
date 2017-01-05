package com.bytebeats.springmvc.ch1.controller;

import com.bytebeats.springmvc.ch1.domain.User;
import com.bytebeats.springmvc.ch1.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Spring MVC RESTful JSON
 *
 * @author Ricky Fung
 * @create 2016-07-13 11:41
 */
@RestController
@RequestMapping("/demo")
public class RestfulController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/user/{username}", method = RequestMethod.GET)
    public User query(@PathVariable String username){

        System.out.println("view username:"+username);

        return userService.findUserByName(username);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> queryList(@RequestParam int limit){

        System.out.println("limit:"+limit);

        return userService.queryList(limit);
    }

}
