package com.otherTest;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ClassName CglibTest2
 * @Description TODO
 * @Author acer
 * @Date 2019/7/14 22:04
 * @Version 1.0
 **/
public class CglibTest2 implements MethodInterceptor {
    private Object target;

    public CglibTest2(Object obj) {
        this.target = obj;
    }

    public CglibTest2(){}

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("没加油");
        //Object invoke = methodProxy.invoke(target, objects);
        Object o1 = methodProxy.invokeSuper(o, objects);
        return o1;
    }
}
