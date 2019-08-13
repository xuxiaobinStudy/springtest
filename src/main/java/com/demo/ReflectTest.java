package com.demo;

import com.domain.User;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ReflectTest
 * @Description 反射
 * @Author acer
 * @Date 2019/8/6 9:19
 * @Version 1.0
 **/
public class ReflectTest {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
//        reflectField();
        reflectMethod();
//        reflectConstruct();
//        reflectAnnotation();
//        reflectDenericity();
    }

    // 反射获取属性
    public static void reflectField() {
        Class<User> userClass = User.class;
        Field[] fields = userClass.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());
            Type genericType = field.getGenericType();
            field.getAnnotations();
            String typeName = genericType.getTypeName();
            System.out.println(typeName);
        }
    }

    // 反射获取方法
    public static void reflectMethod() throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<User> userClass = User.class;
        User user = userClass.newInstance();
        Method method = userClass.getMethod("t", List.class);
        List<User> list = new ArrayList<>();
        list.add(user);
        method.invoke(user, list);
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        method.getGenericExceptionTypes();
        method.getGenericReturnType();

        for (Type genericParameterType : genericParameterTypes) {
            System.out.println(genericParameterType);
            String typeName = genericParameterType.getTypeName();
            System.out.println(typeName);
        }
    }

    // 反射获取构造方法
    public static void reflectConstruct() throws NoSuchMethodException {
        Class<User> userClass = User.class;
        Constructor<User>[] constructors = (Constructor<User>[]) userClass.getConstructors();
        userClass.getConstructor(null);
        Constructor<User> declaredConstructor = userClass.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
    }

    // 反射获取注解
    public static void reflectAnnotation() {

    }

    // 反射获取泛型
    public static void reflectDenericity() {

    }
}
