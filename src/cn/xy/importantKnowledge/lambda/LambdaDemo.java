package cn.xy.importantKnowledge.lambda;

import cn.xy.model.People;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class LambdaDemo {
    public LambdaDemo(int i, int i1) {
        System.out.println(i * i1);
    }

    private static int count(int a, int b) {
        return a + b;
    }

    private int delete(int a, int b) {
        return a - b;
    }

    public static void main(String[] args) {
        int number1 = 30, number2 = 20;
        // 普通调用
        int c = count(number1, number2);
        System.out.println(c);

        // 匿名函数调用
        Demo demo = new Demo() {
            @Override
            public Integer delete(int a, int b) {
                return a + b;
            }
        };
        System.out.println(demo.delete(number1, number2));

        // Lambda表达式,写lambda记住口诀"参数在前逻辑后，箭头符号表函数"
        Demo demo1 = (a, b) -> a - b;
        System.out.println(demo1.delete(number1, number2));

        // Lambda调用静态方法
        Demo demo2 = LambdaDemo::count;
        System.out.println(demo2.delete(number1, number2));

        // Lambda引用对象方法
        LambdaDemo lambdaDemo = new LambdaDemo(number1, number2);
        Demo demo3 = lambdaDemo::delete;
        System.out.println(demo3.delete(number1, number2));

        // Lambda引用构造方法
        Demo demo4 = LambdaDemo::new;
        LambdaDemo lambdaDemo1 = (LambdaDemo) demo4.delete(number1, number2);

        // Lambda聚合操作
        // 集合形式
        ArrayList<People> peoples = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            People newPeople = new People();
            newPeople.setHP(r.nextInt(1000));
            peoples.add(newPeople);
        }
        peoples.stream().filter((people -> people.getHP() > 100))
                .forEach(people -> System.out.println(people.getHP()));

        // 数组形式
        People people2[] = peoples.toArray(new People[peoples.size()]);
        Arrays.stream(people2)
                .forEach(people -> System.out.println(people.getHP()));
    }
}
