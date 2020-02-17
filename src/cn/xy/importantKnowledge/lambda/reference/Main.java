package cn.xy.importantKnowledge.lambda.reference;

import java.util.ArrayList;

public class Main {
    void constructorReference(PeopleInterface peopleInterface) {
        peopleInterface.test();
    }

    void staticReference(PeopleInterface peopleInterface) {
        peopleInterface.test();
    }

    void objectMethodReference(PeopleInterface peopleInterface) {
        peopleInterface.test();
    }

    void containerObjectMethodReference(ArrayList<People> peopleArrayList, PeopleInterface2 peopleInterface2) {
        for (People people : peopleArrayList) {
            peopleInterface2.test(people);
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        // 匿名函数调用构造器
        main.constructorReference(new PeopleInterface() {
            @Override
            public void test() {
                new People();
            }
        });
        // Lambda调用构造器
        main.constructorReference(() -> new People());
        // 构造器引用
        main.constructorReference(People::new);

        // 匿名函数调用静态函数
        main.staticReference(new PeopleInterface() {
            @Override
            public void test() {
                People.print2();
            }
        });
        // Lambda调用静态函数
        main.staticReference(() -> People.print2());
        // 静态函数引用
        main.staticReference(People::print2);

        // 匿名函数调用普通函数
        main.objectMethodReference(new PeopleInterface() {
            @Override
            public void test() {
                new People().print1();
            }
        });
        // Lambda调用普通函数
        main.objectMethodReference(() -> new People().print1());
        // 普通函数的引用
        People people = new People();
        main.objectMethodReference(people::print1);

        ArrayList<People> peopleArrayList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            peopleArrayList.add(new People());
        }
        // 匿名函数调用容器里面的普通函数
        main.containerObjectMethodReference(peopleArrayList, new PeopleInterface2() {
            @Override
            public void test(People people) {
                people.print1();
            }
        });
        // Lambda调用容器里面的普通函数
        main.containerObjectMethodReference(peopleArrayList, (people1) -> people1.print1());
        // 容器里面的普通函数引用
        main.containerObjectMethodReference(peopleArrayList, People::print1);
    }
}
