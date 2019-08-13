package com.service.impl;

import com.service.ResourceReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @ClassName FileSystemResourceReader
 * @Description TODO
 * @Author acer
 * @Date 2019/7/18 17:18
 * @Version 1.0
 **/
public class FileSystemResourceReader implements ResourceReader {
    /**
     * @Author acer
     * @Description 读取服务器地址文件
     * @Date 2019/7/18 17:18
     * @Params [path]
     * @Return java.io.InputStream
     **/
    @Override
    public InputStream getInputStream(String path) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        return inputStream;
    }
}
