package cn.xy.importantKnowledge.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("张麻子", "李蛋", "王二狗", "Angell");
        List<Student> users = Arrays.asList(
                new Student("张三", 23),
                new Student("赵四", 24),
                new Student("二狗", 23),
                new Student("田七", 22),
                new Student("皮特", 20),
                new Student("Tony", 20),
                new Student("二柱子", 25));
        /**
         * map：对集合的每个对象做处理
         */
        List<String> collect = list.stream().map(obj -> "哈哈" + obj).collect(Collectors.toList());
        list.forEach(obj -> System.out.println(obj));
        System.out.println("----------------");
        collect.forEach(obj -> System.out.println(obj));

        /**
         * filter：boolean判断，用于条件过滤
         */
        System.out.println("----------------");
        Set<String> set = list.stream().filter(obj -> obj.length() > 2).collect(Collectors.toSet());
        set.forEach(obj -> System.out.println(obj));

        /**
         * sorted：对流进行自然排序
         */
        System.out.println("----------------");
        Set<String> sorteds = list.stream().sorted().collect(Collectors.toSet());
        sorteds.forEach(obj -> System.out.println(obj));
        // 自定义排序规则
        // 根据长度排序(正序)
        System.out.println("----------------");
        List<String> resultList = list.stream().sorted(Comparator.comparing(obj -> obj.length())).collect(Collectors.toList());
        resultList.forEach(obj -> System.out.println(obj));
        System.out.println("----------------");
        // 根据长度排序(倒序)
        List<String> resultList2 = list.stream().sorted(Comparator.comparing(obj -> obj.length(), Comparator.reverseOrder())).collect(Collectors.toList());
        resultList2.forEach(obj -> System.out.println(obj));
        System.out.println("----------------");
        // 手动指定排序规则(根据年龄大小排序)
        List<Student> collect2 = users.stream().sorted(
                Comparator.comparing(Student::getAge, (x, y) -> {
                    if (x > y) {
                        return 1;
                    } else {
                        return -1;
                    }
                })
        ).collect(Collectors.toList());
        collect2.forEach(obj -> System.out.println(obj.getAge() + " : " + obj.getProvince()));

        /**
         * limit：截取包含指定数量的元素
         */
        System.out.println("----------------");
        List<String> collect3 = list.stream().limit(2).collect(Collectors.toList());
        collect3.forEach(obj -> System.out.println(obj));

        /**
         * allMatch：匹配所有元素，只有全部符合才返回true
         */
        System.out.println("----------------");
        boolean flag = list.stream().allMatch(obj -> obj.length() > 2);
        System.out.println(flag);
        System.out.println("----------------");

        /**
         * anyMatch：匹配所有元素，至少一个元素满足就为true
         */
        boolean flag2 = list.stream().anyMatch(obj -> obj.length() > 2);
        System.out.println(flag2);
        System.out.println("----------------");

        /**
         * max和min：最大值和最小值
         */
        Optional<Student> max = users.stream().max(Comparator.comparingInt(Student::getAge));
        System.out.println(max.get().getAge() + " : " + max.get().getProvince());
        System.out.println("----------------");
        Optional<Student> min = users.stream().min((s1, s2) -> Integer.compare(s1.getAge(), s2.getAge()));
        System.out.println(min.get().getAge() + " : " + min.get().getProvince());

        /**
         * reduce：对Stream中的元素进行计算后返回一个唯一的值
         */
        // 计算所有值的累加
        int value = Stream.of(1, 2, 3, 4, 5).reduce((item1, item2) -> item1 + item2).get();
        // 100作为初始值，然后累加所有值
        int value2 = Stream.of(1, 2, 3, 4, 5).reduce(100, (sum, item) -> sum + item);
        // 找出最大值
        int value3 = Stream.of(1, 4, 5, 2, 3).reduce((x, y) -> x > y ? x : y).get();

        System.out.println(value);
        System.out.println(value2);
        System.out.println(value3);
    }
}


class Student {
    private String province;
    private int age;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(String province, int age) {
        this.age = age;
        this.province = province;
    }
}