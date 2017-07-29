package apple.springmvc.zxing.service;

import apple.springmvc.zxing.model.User;
import org.springframework.stereotype.Service;

/**
 * @author Ricky Fung
 */
@Service
public class UserService {

    public User getUser(Long userId) {
        User user = new User();
        user.setId(userId);
        user.setName("ricky");
        user.setAge(28);
        return user;
    }
}
