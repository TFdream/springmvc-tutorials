package apple.springmvc.restful.controller;

import apple.springmvc.restful.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2016-07-12 16:32
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(User user, Model model){

        System.out.println("update user:"+user);
        model.addAttribute("user", user);

        return "success";
    }

    @RequestMapping("/view")
    public String view(@RequestParam(value="username", required=true) String username, Model model){
        System.out.println("view username:"+username);
        model.addAttribute("username", username);
        return "login";
    }

    @RequestMapping("add")
    public String register(User user, Map<String, Object> map){

        map.put("user", user);

        return "success";
    }

    @RequestMapping("register")
    public ModelAndView register(User user){

        ModelAndView mv = new ModelAndView("success");
        mv.addObject("user", user);

        return mv;
    }

    @RequestMapping("/login")
    public String login(@RequestParam(value="username", required=true) String username, @RequestParam(value="password", required=true)String password) {
        System.out.println("login username:"+username+",password:"+password);
        return "login";
    }

    @RequestMapping("test")
    public String register(HttpServletRequest request, HttpServletResponse response){
        System.out.println("request:"+request);
        return "login";
    }
}
