package com.util;

import java.io.*;
import java.net.Socket;

/**
 * @ClassName SocketClientUtil
 * @Description socket客户端
 * @Author acer
 * @Date 2019/8/5 14:38
 * @Version 1.0
 **/
public class SocketClientUtil {

    // ip和端口
    private static final String IP = "127.0.0.1";
    private static final Integer PORT = 8081;

    // 直接使用main方法启动socket客户端
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream outputStream = null;
        InputStream inputStream = null;
        try {
            // 创建Socket对象，参数是服务器端的ip和端口
            socket = new Socket(IP, PORT);
            // 通过OutputStream将内容传输到服务器端
            outputStream = socket.getOutputStream();

            // 字符串模拟报文，设置编码格式
            String context = "你好，我是客户端!";
            byte[] bytes = context.getBytes("utf-8");
            outputStream.write(bytes);
            // ---------下面是双向通信--------
            // 告诉服务端，客户端的信息传输完成，否则客户端会一直等待
            socket.shutdownOutput();
            // 通过InputStream获取服务器端返回的信息
            inputStream = socket.getInputStream();
            int len = 0;
            byte[] b = new byte[1024];
            StringBuilder str = new StringBuilder();
            while ((len = inputStream.read(b)) > 0) {
                inputStream.read(b, 0, len);
                str.append(new String(b, 0, len, "utf-8"));
            }
            String result = str.toString();
            System.out.println(result);
        } catch (IOException e) {
            System.out.println("------socket客户端出错------");
        } finally {
            try {
                if (null != inputStream) {
                    inputStream.close();
                }
                if (null != outputStream) {
                    outputStream.close();
                }
                if (null != socket) {
                    socket.close();
                }
            } catch (IOException e) {
                System.out.println("异常了");
            }
        }
    }
}
