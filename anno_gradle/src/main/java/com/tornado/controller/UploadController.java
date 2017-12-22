package com.tornado.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

@Controller
public class UploadController {

    @GetMapping("/toUpload.html")
    public String toUpload() {
        return "upload/upload";
    }

    @RequestMapping("upload.html")
    public void springUpload(HttpServletRequest request, PrintWriter out) throws IllegalStateException, IOException {

        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());

        if (multipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;

            Iterator iterator = multiRequest.getFileNames();

            while (iterator.hasNext()) {
                MultipartFile file = multiRequest.getFile(iterator.next().toString());
                String path = request.getSession().getServletContext().getRealPath("/upload") + "\\" + file.getOriginalFilename();
                file.transferTo(new File(path));
            }
        }

        out.print("success");
    }

}
