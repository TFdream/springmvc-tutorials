package com.bytebeats.springmvc.ch1.service.impl;

import com.bytebeats.springmvc.ch1.domain.User;
import com.bytebeats.springmvc.ch1.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2016-07-18 10:37
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Override
    public User findUserByName(String username) {
        User user = new User();
        user.setUsername(username);
        user.setPassword("123");
        user.setEmail(username+"@163.com");
        user.setAge(27);

        return user;
    }

    @Override
    public List<User> queryList(int limit) {

        List<User> list = new ArrayList<>(limit);
        for (int i=0; i<limit;i++){
            User user = new User();
            user.setUsername("ricky_"+i);
            user.setPassword("12345");
            user.setAge(i);

            list.add(user);
        }

        return list;
    }
}
