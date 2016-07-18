package com.ricky.codelab.springmvc.service;

import com.ricky.codelab.springmvc.domain.User;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2016-07-18 10:36
 */
public interface IUserService {

    public User findUserByName(String username);
}
