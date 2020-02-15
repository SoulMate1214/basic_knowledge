package cn.xy.model;

import cn.xy.service.FunctionalService;

public class InnerClassTest {
    private String name;
    private int age;
    private boolean sex;

    class Eat {
        public Eat() {
            name = "soul";
            System.out.println(name + ":我能访问外部属性,我需要外部实例才能调用");
        }
    }

    static class Run {
        public Run() {
            System.out.println("我不能访问外部类的属性,我不需要外部实例才能调用");
        }
    }

    public static void main(String[] args) {
        class Drink {
            private Drink() {
                System.out.println("我是本地类,类似与匿名类，只是我不需要接口或者抽象类为前提");
            }
        }
        // call ordinary inner class
        InnerClassTest innerClassTest = new InnerClassTest();
        Eat eat = innerClassTest.new Eat();
        // call static inner class
        Run run = new Run();
        // call anonymous inner class
        FunctionalService functionalService = new FunctionalService() {
            @Override
            public void create() {
                System.out.println("我是匿名内部类");
            }
        };
        // call local inner class
        Drink drink = new Drink();
    }
}
