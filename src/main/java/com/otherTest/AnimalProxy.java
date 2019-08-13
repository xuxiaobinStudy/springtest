package com.otherTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName AnimalProxy
 * @Description TODO
 * @Author acer
 * @Date 2019/7/14 19:35
 * @Version 1.0
 **/
public class AnimalProxy {

    private Object target;

    public AnimalProxy(Object obj){
        this.target=obj;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("抓到鱼");
                        method.invoke(target,args);
                        return null;
                    }
                });
    }

}
