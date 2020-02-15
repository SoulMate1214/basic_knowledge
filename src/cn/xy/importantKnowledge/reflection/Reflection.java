package cn.xy.importantKnowledge.reflection;

import cn.xy.model.HelloWorld;

import java.io.*;

public class Reflection {
    public static void main(String[] args) {
        // 三种形式，同时写的话只能有一个起作用，因为类对象只有一个
        // .class形式不会执行静态代码块，构造代码块，构造函数
        Class class1 = HelloWorld.class;
        // .forName形式只会执行静态代码块
        try {
            Class class3 = Class.forName("cn.xy.model.HelloWorld");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // new形式会执行静态代码块，构造代码块，构造函数
        Class class2 = new HelloWorld().getClass();

//     1、两者创建对象的方式不同，前者是实用类的加载机制，后者则是直接创建一个类：
//　　2、newInstance创建类是这个类必须已经加载过且已经连接，new创建类是则不需要这个类加载过
//　　3、newInstance: 弱类型(GC是回收对象的限制条件很低，容易被回收)、低效率、只能调用无参构造，new 强类型（GC不会自动回收，只有所有的指向对象的引用被移除是才会被回收，若对象生命周期已经结束，但引用没有被移除，经常会出现内存溢出）

//        如果在接口的设计中很多类实现了该接口，我们只需要使用Class中的forName方法加载一下类就可以了，
//        可以将这一段代码提出来作为一个工具类方法，不管有多少类只要实现了该接口我们只要传入需要实例化的路径名就可以实例化，这样大大节省了我们的代码
//        （注：newInstance实例化对象是只能调用无参构造方法，在A、B类中并没有构造方法，是因为每个创建的类都有一个默认的无参构造方法，如果你重写了一个带参构造方法，
//        想要使用newInstance，则必须指定一个无参构造方法，否则会报初始化错误)

        // 创建实例的普通形式
        HelloWorld helloWorld = new HelloWorld();
        // 创建实例的发射形式
        try {
            HelloWorld helloWorld1 = HelloWorld.class.getConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 读取文件创建实例
        File file = new File("D:/jetbrainsSoftware/workspace/idea/basic_knowledge/src/cn/xy/importantKnowledge/Reflection/ClassName.txt");
        System.out.println("判断是否存在：" + file.exists());
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while (true) {
                String line = br.readLine();
                if (null == line) break;
                System.out.println(Class.forName(line).getConstructor().newInstance());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 访问属性，对于private修饰的成员，需要使用setAccessible(true)才能访问和修改
        try {
            Class helloWord = Class.forName("cn.xy.model.HelloWorld");
            // 新建实例
            Object object = helloWord.getConstructor().newInstance();
            // 修改属性值
            helloWord.getDeclaredField("h").set(object, "newHelloWord");
            // 输出属性值
            System.out.println((helloWord.getDeclaredField("h").get(object)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 访问函数
        try {
            Class helloWord = Class.forName("cn.xy.model.HelloWorld");
            // 新建实例
            Object object = helloWord.getConstructor().newInstance();
            // 调用函数并传参，如果不用填参数直接getMethod("Method").invoke(object);
            helloWord.getMethod("method", String.class).invoke(object, "soul");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
