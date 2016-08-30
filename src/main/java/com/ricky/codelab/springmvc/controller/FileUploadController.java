package com.ricky.codelab.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * 文件上传功能
 *
 * @author Ricky Fung
 * @create 2016-08-30 22:45
 */
@Controller
@RequestMapping("/file")
public class FileUploadController {

    @RequestMapping(value = "/upload1", method = RequestMethod.POST)
    public String upload(HttpServletRequest request, HttpServletResponse response) throws IOException {

        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getServletContext());
        if(multipartResolver.isMultipart(request)){
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
            Iterator<String> it = multiRequest.getFileNames();
            while(it.hasNext()){
                //取得上传文件
                MultipartFile file = multiRequest.getFile(it.next());
                saveUploadFile(file);
            }
        }
        return "upload_success";
    }

    @RequestMapping(value = "/upload2", method = RequestMethod.POST)
    public String uploadOrigin(@RequestParam("file") CommonsMultipartFile[] files, HttpServletRequest request) throws IOException {

        if(files!=null && files.length>0){
            for(CommonsMultipartFile file : files){
                System.out.println("fileName---------->" + file.getOriginalFilename());

                if(file!=null && file.getSize()>0){
                    saveUploadFile(file);
                }
            }
        }

        return "upload_success";
    }

    @RequestMapping("/toUpload" )
    public String toUpload() {

        return "upload";
    }

    private void saveUploadFile(MultipartFile file) throws IOException {
        if(file != null){
            //取得当前上传文件的文件名称
            String myFileName = file.getOriginalFilename();
            //如果名称不为“”,说明该文件存在，否则说明该文件不存在
            if(myFileName.trim() !=""){
                System.out.println(myFileName);
                //重命名上传后的文件名
                String fileName = "upload_" + file.getOriginalFilename();
                //定义上传路径
                String path = "F:/upload/" + fileName;
                File localFile = new File(path);
                file.transferTo(localFile);
            }
        }
    }
}
