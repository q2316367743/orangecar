package com.qsd.orange.controller;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.file.FileWriter;
import com.qsd.orange.global.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * 资源上传
 * @Author Esion
 * @Date 2020/9/24 18:19
 * @Version 1.0
 */
@RestController
@RequestMapping("system/resource")
public class SystemResourceController {

    public static final String IMAGE_PATH = "F:\\nginx\\nginx-image\\html";

    @PostMapping("image/add")
    public R updateImage(MultipartFile file){
        String name = "temp";
        String temp = file.getName();
        System.out.println(temp);
        temp = "png";
        name = System.currentTimeMillis() + "." + temp;
        try(InputStream inputStream = file.getInputStream();) {
            FileWriter fileWriter = new FileWriter(new File(IMAGE_PATH, name));
            BufferedOutputStream outputStream = fileWriter.getOutputStream();
            IoUtil.copy(inputStream, outputStream);
        } catch (IOException e) {
            e.printStackTrace();
            return R.error();
        }
        return R.success().data("image", name);
    }

}
