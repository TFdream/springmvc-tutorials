package springmvc.tutorials.async.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.WebAsyncTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Ricky Fung
 */
@Controller
@RequestMapping("/foo")
public class FooController {
    private final AtomicInteger counter = new AtomicInteger(1);

    @RequestMapping("/callable")
    @ResponseBody
    public Callable<Object> request() {

        final int seq = counter.getAndIncrement();
        System.out.println("请求seq:"+seq+"开始 in thread:"+Thread.currentThread().getName());

        Callable<Object> callable = new Callable<Object>() {
            @Override
            public Object call() throws Exception {

                System.out.println("请求seq:"+seq+"处理开始 in thread:"+Thread.currentThread().getName());
                sleep(2000);
                System.out.println("请求seq:"+seq+"处理结束 in thread:"+Thread.currentThread().getName());

                Map<String, String> map = new HashMap<>();
                map.put("seq", String.valueOf(seq));
                map.put("thread", Thread.currentThread().getName());
                return map;
            }
        };
        return callable;
    }

    @RequestMapping("/webAsyncTask")
    @ResponseBody
    public WebAsyncTask<List<String>> req() {

        final int seq = counter.getAndIncrement();
        System.out.println("请求seq:"+seq+"开始 in thread:"+Thread.currentThread().getName());

        Callable<List<String>> callable = new Callable<List<String>>() {
            @Override
            public List<String> call() throws Exception {

                System.out.println("请求seq:"+seq+"处理开始 in thread:"+Thread.currentThread().getName());
                sleep(2000);
                System.out.println("请求seq:"+seq+"处理结束 in thread:"+Thread.currentThread().getName());

                List<String> list = new ArrayList<>();
                list.add(String.valueOf(seq));
                list.add(Thread.currentThread().getName());
                return list;
            }
        };

        return new WebAsyncTask<>(10000, callable);
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
