package com.util;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;
import java.util.List;

/**
 * @ClassName Dom4jParseXmlUtil
 * @Description 使用dom4j解析xml文件
 * @Author acer
 * @Date 2019/7/19 10:25
 * @Version 1.0
 **/
public class Dom4jParseXmlUtil {

    // 根据输入流，解析xml文件，返回document对象
    public static void getDocument(InputStream inputStream) {
        try {
            SAXReader sax = new SAXReader();
            Document document = sax.read(inputStream);//入参除了inputStream还可以是File对象
            String xmlEncoding = document.getXMLEncoding();
            Element rootElement = document.getRootElement();
            List<Element> elements = rootElement.elements();
            for (Element element : elements) {
                List<Attribute> attributes = element.attributes();
                for (Attribute attribute : attributes) {
                    System.out.println(attribute.getName() + "--->" + attribute.getValue());
                }
            }
        } catch (DocumentException e) {
            System.out.println(e);
        } finally {
            try {
                if (null != inputStream) {
                    inputStream.close();
                }
            } catch (IOException e) {
                System.out.println("关闭输入流失败");
            }
        }
    }

    // 生成xml文档
    public static void generateXmlFile() {
        // 获取Document对象
        Document document = DocumentHelper.createDocument();
        // 根据Document对象创建根标签
        Element root = document.addElement("root");
        //  根据根标签，创建子标签
        Element root1 = root.addElement("root1");
        Element root2 = root.addElement("root2");
        // 设置子标签的属性及属性值
        root1.addAttribute("name", "zhangsan");
        root2.addAttribute("id", "lisi");
        //  添加内容
        root1.addText("子标签1");
        // 格式化输出xml格式
        OutputFormat prettyPrint = OutputFormat.createPrettyPrint();
        prettyPrint.setEncoding("utf-8");
        File file = new File("d://test.xml");
        XMLWriter writer = null;
        try {
            writer = new XMLWriter(new FileOutputStream(file), prettyPrint);
            writer.write(document);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != writer) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
