package com.otherTest;

import org.springframework.cglib.proxy.*;

import java.lang.reflect.Method;

/**
 * @ClassName CglibTest
 * @Description TODO
 * @Author acer
 * @Date 2019/7/14 21:08
 * @Version 1.0
 **/
public class CglibTest implements MethodInterceptor {
    private Object target;

    public CglibTest(Object obj) {
        this.target = obj;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("加油");
        //Object invoke = methodProxy.invoke(target, objects);
        Object o1 = methodProxy.invokeSuper(o, objects);
        return o1;
    }

    public Object getProxy(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallbacks(new Callback[]{this,new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("没加油");
                //Object invoke = methodProxy.invoke(target, objects);
                Object o1 = methodProxy.invokeSuper(o, objects);
                return o1;
            }
        }});
        enhancer.setCallbackFilter(new CallbackFilter(){
            @Override
            public int accept(Method method) {
                if(method.getName().equals("driver")){
                    System.out.println(method.getName());
                    return 0;
                }else{
                    System.out.println(method.getName());
                    return 1;
                }
            }
        });
        return enhancer.create();
    }

}
