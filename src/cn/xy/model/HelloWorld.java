package cn.xy.model;

/*
 * begin a hello world class
 *
 * @author Soul
 * @date 2020/2/3 19:30
 */
public class HelloWorld {
    public String h = "HelloWorld";
    public int age = 10;

    static {
        System.out.println("我是静态代码块");
    }

    {
        System.out.println("我是构造代码块");
    }

    public HelloWorld() {
        System.out.println("我是构造函数");
    }

    public void method(String name) {
        System.out.println("我是一个普通的函数"+name);
    }
}
