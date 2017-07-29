package com.bytebeats.springmvc.ch1.service;

import com.bytebeats.springmvc.ch1.domain.User;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2016-07-18 10:36
 */
public interface IUserService {

    User findUserByName(String username);

    List<User> queryList(int limit);
}
