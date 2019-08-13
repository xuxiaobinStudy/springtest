package com.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @ClassName AopTest
 * @Description TODO
 * @Author acer
 * @Date 2019/8/6 11:16
 * @Version 1.0
 **/
@Component
@Aspect
public class AopTest {
    @Pointcut("")
    public void pointcut(){}
}
