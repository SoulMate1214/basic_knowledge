package cn.xy.importantKnowledge.lambda;

import cn.xy.model.People;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

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

    public Integer add(int a, int b, int c, Demo<Integer> demo1) {
        return a + demo1.delete(b, c);
    }

    public void consumer(double money, Consumer<Double> c) {
        c.accept(money);
    }

    public void supplier(Supplier<Double> s) {
        System.out.println(s.get());
    }

    public void function(Integer age, Function<Integer, String> f) {
        System.out.println(f.apply(age));
    }

    public void predicate(double money, Predicate<Double> p) {
        System.out.println(p.test(money));
    }

    public static void main(String[] args) {
        int number1 = 30, number2 = 20;
        // 普通调用
        int c = count(number1, number2);
//        System.out.println(c);
//
//        // 实现类形式调用
//        Demo<Integer> demo = new DemoImpl();
//        System.out.println(demo.delete(10, 20));
//
//        // 匿名函数调用
//        Demo<Integer> demo1 = new Demo() {
//            @Override
//            public Integer delete(int a, int b) {
//                return a - b;
//            }
//        };
//        System.out.println(demo1.delete(20, 10));
//
//        // Lambda表达式,写lambda记住口诀"参数在前逻辑后，箭头符号表函数"
//        Demo demo2 = (a, b) -> a - b;
//        System.out.println(demo2.delete(number1, number2));
//
//        // Lambda调用静态方法
//        Demo demo3 = LambdaDemo::count;
//        System.out.println(demo3.delete(number1, number2));
//
//        // Lambda引用对象方法
        LambdaDemo lambdaDemo = new LambdaDemo(number1, number2);
//        lambdaDemo.add(10, 20, 30, (a, b) -> a - b);
//        Demo demo4 = lambdaDemo::delete;
//        System.out.println(demo4.delete(number1, number2));
//
//        // Lambda引用构造方法
//        Demo demo5 = LambdaDemo::new;
//        LambdaDemo lambdaDemo1 = (LambdaDemo) demo5.delete(number1, number2);
//
//        // Lambda聚合操作
//        // 集合形式
//        ArrayList<People> peoples = new ArrayList<>();
//        Random r = new Random();
//        for (int i = 0; i < 5; i++) {
//            People newPeople = new People();
//            newPeople.setHP(r.nextInt(1000));
//            peoples.add(newPeople);
//        }
//        peoples.stream().filter((people -> people.getHP() > 100))
//                .forEach(people -> System.out.println(people.getHP()));
//
//        // 数组形式
//        People people2[] = peoples.toArray(new People[peoples.size()]);
//        Arrays.stream(people2)
//                .forEach(people -> System.out.println(people.getHP()));

//        // 集合遍历
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
//        for (int element : numbers) {
//            System.out.println(element);
//        }
//        // Lambda形式
//        numbers.forEach(element -> System.out.println(element));

//        // 消费型接口
//        lambdaDemo.consumer(10, (x) -> System.out.println(x));
//        // 供给型接口
//        lambdaDemo.supplier(() -> 10D);
//        // 函数型接口
//        lambdaDemo.function(18, x -> x.toString());
//        // 断言型接口
//        lambdaDemo.predicate(10D, (x) -> x > 5D);

//        // Stream之reduce
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
//        int sum = numbers.stream().reduce((x, y) -> x + y).get();
//        System.out.println(sum);

//        // Stream之map
//        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);
//        List<Integer> mapped = numbers1.stream().map(x -> x * 2).collect(Collectors.toList());
//        mapped.forEach(System.out::println);
    }
}
