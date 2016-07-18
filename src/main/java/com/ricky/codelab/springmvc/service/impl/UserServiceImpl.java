package com.ricky.codelab.springmvc.service.impl;

import com.ricky.codelab.springmvc.domain.User;
import com.ricky.codelab.springmvc.service.IUserService;
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
