package com.zheng.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by zhenglian on 2016/9/22.
 */
@Controller
public class UploadController {

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(MultipartFile file) throws Exception {
        String path = "D://test/";
        String fileName = file.getOriginalFilename();
        File diskFile = new File(path + fileName);
        if (!diskFile.getParentFile().exists()) {
            diskFile.getParentFile().mkdirs();
        }

        if (!diskFile.exists()) {
            diskFile.createNewFile();
        }

        BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(diskFile));
        output.write(file.getBytes());
        output.flush();
        output.close();

        return "上传成功";

    }

    /**
     * 多文件上传主要是使用了multipartServletRequest来处理请求的多个文件
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/multiFileUpload", method = RequestMethod.POST)
    @ResponseBody
    public String multiFileUpload(MultipartHttpServletRequest request) throws IOException {
        List<MultipartFile> files = request.getFiles("file");
        BufferedOutputStream output = null;
        String fileName = null;
        String path = "D://test/";
        File diskFile = null;
        for (MultipartFile file : files) {
            fileName = file.getOriginalFilename();
            diskFile = new File(path + fileName);
            if (!diskFile.getParentFile().exists()) {
                diskFile.getParentFile().mkdirs();
            }

            if (!diskFile.exists()) {
                diskFile.createNewFile();
            }

            output = new BufferedOutputStream(new FileOutputStream(diskFile));
            output.write(file.getBytes());
            output.flush();
            output.close();
        }

        return "上传成功";
    }
}
