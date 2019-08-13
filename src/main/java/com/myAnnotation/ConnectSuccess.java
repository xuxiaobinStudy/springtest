package com.myAnnotation;

import java.lang.annotation.*;

/**
 * @Author acer
 * @Description 自定义注解
 * @Date 2019/8/6 11:10
 * @Params
 * @Return
 **/
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ConnectSuccess {
    public boolean flag() default false;
}
