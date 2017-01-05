package com.bytebeats.springmvc.ch1.controller;

import com.bytebeats.springmvc.ch1.domain.Order;
import com.bytebeats.springmvc.common.util.JsonUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2016-07-26 10:08
 */
@RestController
@RequestMapping("/demo")
public class OrderController {

    private AtomicLong counter = new AtomicLong(1);

    @RequestMapping(value = "/orders/{userId}", method = RequestMethod.GET)
    public List<Order> query(@PathVariable Long userId){

        List<Order> list = new ArrayList<>();
        for (int i=0; i<5; i++){
            Order order = new Order();
            order.setId(i);
            order.setCategory("IT数码");
            order.setUserId(userId);
            order.setAmount(i+3);

            list.add(order);
        }
        return list;
    }

    //表单提交
    @RequestMapping(value = "/order/submit", method = RequestMethod.POST)
    public Order create(@RequestParam Order order){

        return order;
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public Order create(@RequestBody String data){

        System.out.println("data:"+data);

        Order order = JsonUtils.fromJson(data, Order.class);
        order.setId(counter.getAndIncrement());

        return order;
    }

    @RequestMapping(value = "/order/{id}", method = RequestMethod.POST)
    public Order createWithId(@PathVariable Long id, @RequestBody Order oder){

        System.out.println("order:"+ oder);

        oder.setId(id);

        return oder;
    }
}
