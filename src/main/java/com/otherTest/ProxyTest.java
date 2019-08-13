package com.otherTest;

/**
 * @ClassName ProxyTest
 * @Description TODO
 * @Author acer
 * @Date 2019/7/14 19:51
 * @Version 1.0
 **/
public class ProxyTest {
    public static void main(String[] args){
        /*Animal a = new Cat();
        AnimalProxy ap = new AnimalProxy(a);
        Animal proxy = (Animal)ap.getProxy();
        proxy.eat();*/
        Car car = new Car();
        CglibTest t = new CglibTest(car);
        Car proxy = (Car)t.getProxy();
        proxy.driver();
    }

}
