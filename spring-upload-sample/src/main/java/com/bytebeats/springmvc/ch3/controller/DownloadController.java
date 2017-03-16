package com.bytebeats.springmvc.ch3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2016-08-30 23:58
 */
@Controller
@RequestMapping("/file")
public class DownloadController {

    private File dir = new File("D:/temp");

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public String download(@RequestParam("filename") String fileName, HttpServletRequest request,
                           HttpServletResponse response) throws IOException {

        System.out.println("download filename:"+fileName);
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;fileName="
                + URLEncoder.encode(fileName,"UTF-8"));

        InputStream in = null;
        OutputStream out = null;
        try{
            in = new FileInputStream(new File(dir, fileName));
            out = response.getOutputStream();
            byte[] buf = new byte[2048];
            int len = -1;
            while ((len = in.read(buf, 0, buf.length)) > 0) {
                out.write(buf, 0, len);
            }
            out.flush();
        }finally {
            if(out!=null){
                out.close();
            }
            if(in!=null){
                in.close();
            }
        }

        return "success";
    }
}
