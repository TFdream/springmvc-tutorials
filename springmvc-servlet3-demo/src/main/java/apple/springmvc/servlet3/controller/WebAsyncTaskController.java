package apple.springmvc.servlet3.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.WebAsyncTask;
import org.springframework.web.servlet.ModelAndView;
import java.util.concurrent.Callable;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2017-01-06 00:19
 */
@RestController
@RequestMapping("/springmvc")
public class WebAsyncTaskController {

    @RequestMapping(value="/task", method = RequestMethod.GET)
    public WebAsyncTask longTimeTask(){

        System.out.println("WebAsyncTask被调用 thread: " + Thread.currentThread().getName());

        Callable<ModelAndView> callable = new Callable<ModelAndView>() {
            @Override
            public ModelAndView call() throws Exception {

                Thread.sleep(3000); //假设是一些长时间任务
                ModelAndView mav = new ModelAndView("success");
                mav.addObject("result", "执行成功");
                System.out.println("执行成功 thread : " + Thread.currentThread().getName());
                return mav;
            }
        };

        return new WebAsyncTask(4000, callable);
    }
}
