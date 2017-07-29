package com.bytebeats.springmvc.ch2.async;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.ModelAndView;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2017-01-05 23:43
 */
@RestController
@RequestMapping("/springmvc")
public class DeferredResultController {

    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(4);

    @RequestMapping(value = "/async", method = RequestMethod.GET)
    public DeferredResult<ModelAndView> testDeferredResult(){

        final DeferredResult<ModelAndView> deferredResult = new DeferredResult<ModelAndView>();

        final AsyncTaskCallback callback = new AsyncTaskCallback() {
            @Override
            public void notify(Object result) {
                System.out.println("异步调用执行完成, thread id is : " + Thread.currentThread().getId());
                ModelAndView mav = new ModelAndView("remotecalltask");
                mav.addObject("result", result);
                deferredResult.setResult(mav);
            }
        };

        int time = 5;

        System.out.println("完成此任务需要 : " + time + " 秒");
        scheduler.schedule(new Runnable() {
            @Override
            public void run() {

                callback.notify("长时间异步调用完成.");
            }
        }, time, TimeUnit.SECONDS);

        return deferredResult;
    }
}
