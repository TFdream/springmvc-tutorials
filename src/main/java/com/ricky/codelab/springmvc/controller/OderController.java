package com.ricky.codelab.springmvc.controller;

import com.alibaba.fastjson.JSON;
import com.ricky.codelab.springmvc.domain.Oder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.atomic.AtomicLong;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2016-07-26 10:08
 */
@Controller
@RequestMapping("/order")
public class OderController {

    private AtomicLong counter = new AtomicLong(1);

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public Oder create(@RequestBody String data){

        System.out.println("data:"+data);

        Oder order = JSON.parseObject(data, Oder.class);
        order.setId(counter.getAndIncrement());

        return order;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Oder create(@RequestBody Oder oder){

        System.out.println("order:"+ oder);
        oder.setId(counter.getAndIncrement());

        return oder;
    }
}
