package com.bytebeats.springmvc.ch1.service.impl;

import com.bytebeats.springmvc.ch1.domain.User;
import com.bytebeats.springmvc.ch1.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2016-07-18 10:37
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    public User findUserByName(String username) {
        User user = new User();
        user.setUsername(username);
        user.setPassword("123");
        user.setEmail(username+"@163.com");
        user.setAge(27);

        return user;
    }
}
