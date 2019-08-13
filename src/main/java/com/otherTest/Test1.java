package com.otherTest;

import com.util.Dom4jParseXmlUtil;


/**
 * @ClassName Test1
 * @Description TODO
 * @Author acer
 * @Date 2019/7/18 15:14
 * @Version 1.0
 **/
public class Test1 {
    public static void main(String[] args) {
//        ResourceReader resourceReader = new ClassPathResourceReader();
//        InputStream inputStream = resourceReader.getInputStream("spring/spring-mvc.xml");
//        Dom4jParseXmlUtil.getDocument(inputStream);
        Dom4jParseXmlUtil.generateXmlFile();
    }
}
