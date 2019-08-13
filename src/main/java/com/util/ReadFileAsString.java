package com.util;

import com.service.ResourceReader;
import com.service.impl.ClassPathResourceReader;
import com.service.impl.FileSystemResourceReader;
import org.springframework.stereotype.Service;

import java.io.InputStream;

/**
 * @ClassName ReadFileAsString
 * @Description 读取文件，并转换为字符串
 * @Author acer
 * @Date 2019/7/18 16:57
 * @Version 1.0
 **/
@Service
public class ReadFileAsString {

    /**
     * @Author acer
     * @Description 将文件读取为字符串的方法
     * @Date 2019/7/18 17:02
     * @Params [path]
     * @Return java.lang.String
     **/
    public String transToString1(String path) {
        ResourceReader resourceReader = new ClassPathResourceReader();
        InputStream inputStream = resourceReader.getInputStream(path);
        return prin(inputStream);
    }

    /**
     * @Author acer
     * @Description //TODO
     * @Date 2019/7/18 17:22
     * @Params [path]
     * @Return java.lang.String
     **/
    public String transToString2(String path) {
        ResourceReader resourceReader = new FileSystemResourceReader();
        InputStream inputStream = resourceReader.getInputStream(path);
        return prin(inputStream);
    }

    public String prin(InputStream inputStream) {
        StringBuilder str = new StringBuilder();
        try {
            byte[] b = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(b)) > 0) {
                str.append(new String(b));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return str.toString();
    }
}
