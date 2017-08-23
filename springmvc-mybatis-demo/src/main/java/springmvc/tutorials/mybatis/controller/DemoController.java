package springmvc.tutorials.mybatis.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ricky Fung
 */
@RestController
public class DemoController {

    @RequestMapping(value = "/user/{username}", method = RequestMethod.GET)
    public Object query(@PathVariable String username){

        System.out.println("view username:"+username);
        Map<String, String> map = new HashMap<>();
        map.put("username", username);
        map.put("desc", "good");

        return map;
    }
}
