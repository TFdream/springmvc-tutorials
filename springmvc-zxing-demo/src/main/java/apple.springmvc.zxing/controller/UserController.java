package apple.springmvc.zxing.controller;

import apple.springmvc.zxing.model.User;
import apple.springmvc.zxing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Ricky Fung
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
    public ModelAndView query(@PathVariable Long userId){

        User user = userService.getUser(userId);
        ModelAndView mv = new ModelAndView("show_user");
        mv.addObject("user", user);
        return mv;
    }
}
