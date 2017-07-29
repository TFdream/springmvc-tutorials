package apple.springmvc.restful.service;

import apple.springmvc.restful.domain.User;

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
