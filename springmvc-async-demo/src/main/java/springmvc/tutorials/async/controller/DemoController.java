package springmvc.tutorials.async.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Ricky Fung
 */
@Controller
@RequestMapping("/demo")
public class DemoController {
    private final AtomicInteger counter = new AtomicInteger(1);
    //业务处理线程池
    private final ExecutorService pool = Executors.newFixedThreadPool(5);

    @RequestMapping("/deferredResult")
    @ResponseBody
    public DeferredResult<Object> request(@RequestParam String username) {

        int seq = counter.getAndIncrement();
        System.out.println("请求seq:"+seq+"开始 in thread:"+Thread.currentThread().getName());
        DeferredResult<Object> deferredResult = new DeferredResult<>(5000L);
        //异步处理
        dealInOtherThread(deferredResult, seq);
        return deferredResult;
    }

    private void dealInOtherThread(final DeferredResult<Object> deferredResult, final int seq) {

        pool.execute(new Runnable() {
            @Override
            public void run() {

                System.out.println("请求seq:"+seq+"处理开始 in thread:"+Thread.currentThread().getName());
                sleep(2000);
                System.out.println("请求seq:"+seq+"处理结束 in thread:"+Thread.currentThread().getName());

                Map<String, String> map = new HashMap<>();
                map.put("seq", String.valueOf(seq));
                map.put("thread", Thread.currentThread().getName());
                deferredResult.setResult(map);
            }
        });
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
