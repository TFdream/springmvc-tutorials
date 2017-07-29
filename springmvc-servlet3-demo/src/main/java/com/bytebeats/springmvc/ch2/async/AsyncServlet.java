package com.bytebeats.springmvc.ch2.async;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2017-01-06 00:02
 */
@WebServlet(name="asyncServlet", urlPatterns="/async", asyncSupported=true)
public class AsyncServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.getWriter().write("hello, async test");
        resp.getWriter().println("async start："+new Date()+".<br/>");
        resp.getWriter().flush();

        final AsyncContext async = req.startAsync(req,resp);
        async.setTimeout(3000);
        async.start(new Runnable() {
            @Override
            public void run() {
                ServletRequest request = async.getRequest();
                try {
                    Thread.sleep(2000);
                    async.getResponse().getWriter().write("aync thread processing");
                    async.getResponse().getWriter().flush();
                    async.getResponse().getWriter().println("async end："+new Date()+".<br/>");
                    async.getResponse().getWriter().flush();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        async.addListener(new AsyncListener() {
            @Override
            public void onComplete(AsyncEvent asyncEvent) throws IOException {

            }

            @Override
            public void onTimeout(AsyncEvent asyncEvent) throws IOException {

            }

            @Override
            public void onError(AsyncEvent asyncEvent) throws IOException {

            }

            @Override
            public void onStartAsync(AsyncEvent asyncEvent) throws IOException {

            }
        });
        resp.getWriter().println("async end："+new Date()+".<br/>");
        resp.getWriter().flush();

    }
}
