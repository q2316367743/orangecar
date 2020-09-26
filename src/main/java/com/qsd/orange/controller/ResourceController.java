package com.qsd.orange.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.file.FileWriter;
import cn.hutool.core.util.StrUtil;
import com.qsd.orange.enums.HttpResult;
import com.qsd.orange.vo.BaseVo;
import com.qsd.orange.vo.DataVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.stream.ImageInputStream;
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
@RequestMapping("resource")
public class ResourceController {

    public static final String IMAGE_PATH = "F:\\nginx\\nginx-image\\html";

    @PostMapping("image")
    public DataVo<String> updateImage(MultipartFile file){
        String name = file.getName();
        if(StrUtil.isBlank(name)){
            name = String.valueOf(System.currentTimeMillis()) + ".jpg";
        }
        try(InputStream inputStream = file.getInputStream();) {
            FileWriter fileWriter = new FileWriter(new File(IMAGE_PATH, name));
            BufferedOutputStream outputStream = fileWriter.getOutputStream();
            IoUtil.copy(inputStream, outputStream);
        } catch (IOException e) {
            e.printStackTrace();
            return new DataVo<>(HttpResult.SERVER_ERROR);
        }
        return new DataVo<>(HttpResult.SUCCESS, name);
    }

}
