package springmvc.tutorials.async.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final AtomicInteger counter = new AtomicInteger(1);

    @RequestMapping("/callable")
    @ResponseBody
    public Callable<Object> request() {

        final int seq = counter.getAndIncrement();
        logger.info("收到请求seq:{} 线程:{}", seq, Thread.currentThread().getName());

        Callable<Object> callable = new Callable<Object>() {
            @Override
            public Object call() throws Exception {

                int time = (int) (Math.random() * 5000);
                logger.info("请求seq:{} 处理开始, time:{}, 处理线程:{}", seq, time, Thread.currentThread().getName());
                sleep(time);
                logger.info("请求seq:{} 处理结束, 处理线程:{}", seq, Thread.currentThread().getName());

                Map<String, String> map = new HashMap<>();
                map.put("seq", String.valueOf(seq));
                map.put("time", String.valueOf(time));
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
        logger.info("收到请求seq:{} 线程:{}", seq, Thread.currentThread().getName());

        Callable<List<String>> callable = new Callable<List<String>>() {
            @Override
            public List<String> call() throws Exception {

                int time = (int) (Math.random() * 5000);
                logger.info("请求seq:{} 处理开始, time:{}, 处理线程:{}", seq, time, Thread.currentThread().getName());
                sleep(time);
                logger.info("请求seq:{} 处理结束, 处理线程:{}", seq, Thread.currentThread().getName());

                List<String> list = new ArrayList<>();
                list.add(String.valueOf(seq));
                list.add(Thread.currentThread().getName());
                return list;
            }
        };

        WebAsyncTask asyncTask = new WebAsyncTask(4000, callable);
        asyncTask.onTimeout(new Callable<Map<String, String>>() {
            public Map<String, String> call() throws Exception {

                logger.info("请求seq:{} 执行超时, 处理线程:{}", seq, Thread.currentThread().getName());
                Map<String, String> map = new HashMap<>();
                map.put("seq", String.valueOf(seq));
                map.put("desc", "执行超时");
                return map;
            }
        });
        return asyncTask;
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
