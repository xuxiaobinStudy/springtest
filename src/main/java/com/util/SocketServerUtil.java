package com.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName SocketServerUtil
 * @Description socket服务端
 * @Author acer
 * @Date 2019/8/5 14:59
 * @Version 1.0
 **/
public class SocketServerUtil {

    // 服务端，监听端口
    private static final Integer PORT = 8081;

    // 使用main方法启动Socket服务端
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket accept = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            // 创建ServerSocket对象，参数是监听的端口
            serverSocket = new ServerSocket(PORT);
            // 通过accept()方法获取客户端请求的Socket对象，如果没有客户端的请求，服务端线程将堵塞，直到有客户端的请求
            accept = serverSocket.accept();
            // 通过InputStream获取客户端发送的报文
            inputStream = accept.getInputStream();
            int len = 0;
            byte[] b = new byte[1024];
            StringBuilder str = new StringBuilder();
            while ((len = inputStream.read(b)) > 0) {
                inputStream.read(b, 0, len);
                str.append(new String(b, "utf-8"));
            }
            String result = str.toString();
            System.out.println("------客户端发送的报文是：" + result + "------");
            // ---------下面是双向通信--------
            // 通过Socket对象，获取OutputStream，将信息返回给客户端
            outputStream = accept.getOutputStream();
            String re = "服务器接收成功，返回信息!";
            outputStream.write(re.getBytes("utf-8"));
        } catch (IOException e) {
            System.out.println("------Socket服务端异常------");
        } finally {
            try {
                if (null != outputStream) {
                    outputStream.close();
                }
                if (null != inputStream) {
                    inputStream.close();
                }
                if (null != accept) {
                    accept.close();
                }
                if (null != serverSocket) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                System.out.println("socket服务端异常");
            }
        }
    }
}
