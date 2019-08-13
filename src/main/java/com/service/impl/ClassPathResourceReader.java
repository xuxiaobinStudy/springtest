package com.service.impl;

import com.service.ResourceReader;
import org.springframework.stereotype.Service;

import java.io.InputStream;

/**
 * @ClassName ClassPathResourceReader
 * @Description TODO
 * @Author acer
 * @Date 2019/7/18 16:52
 * @Version 1.0
 **/
@Service
public class ClassPathResourceReader implements ResourceReader {
    /**
    *@Author acer
    *@Description 读取项目路径文件
    *@Date 2019/7/18 17:01
    *@Params [path]
    *@Return java.io.InputStream
    **/
    @Override
    public InputStream getInputStream(String path) {
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(path);
        return resourceAsStream;
    }
}
