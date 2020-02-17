package cn.xy.importantKnowledge.collector;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    /**
     * 数据结构收集collectors
     *
     * @author Soul
     * @date 2020/2/17 23:09
     */
    private void collectors() {
        List<String> data = Arrays.asList("张三", "王五", "李四");
        List<String> list = data.stream().collect(Collectors.toList());
        Set<String> set = data.stream().collect(Collectors.toSet());
        LinkedList<String> linkedList = data.stream().collect(Collectors.toCollection(LinkedList::new));
        System.out.println(list);
        System.out.println(set);
        System.out.println(linkedList);
        Collectors.toSet();
        Collectors.toCollection(LinkedList::new);
        Collectors.toCollection(CopyOnWriteArrayList::new);
        Collectors.toCollection(TreeSet::new);
    }

    /**
     * 拼接器joining
     *
     * @author Soul
     * @date 2020/2/17 23:09
     */
    private void joining() {
        List<String> list = Arrays.asList("springBoot", "springCloud", "netty");
        String result1 = list.stream().collect(Collectors.joining());
        String result2 = list.stream().collect(Collectors.joining("——"));
        String result3 = list.stream().collect(Collectors.joining("—", "【", ""));
        String result4 = Stream.of("hello", "world").collect(Collectors.joining("—", "【", "】"));

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
    }

    /**
     * 分组器partitioning
     *
     * @author Soul
     * @date 2020/2/17 23:11
     */
    private void partitioning() {
        List<String> list = Arrays.asList("sdfsdf", "xxxx", "bbb", "bbb");
        Map<Boolean, List<String>> collect = list.stream().collect(Collectors.partitioningBy(obj -> obj.length() > 3));
        System.out.println(collect);
    }

    /**
     * 统计器counting
     *
     * @author Soul
     * @date 2020/2/17 23:11
     */
    private void counting() {
        List<Student> students = Arrays.asList(new Student("⼴东", 23),
                new Student("⼴东", 24),
                new Student("⼴东", 23),
                new Student("北京", 22),
                new Student("北京", 20),
                new Student("北京", 20),
                new Student("海南", 25));
        // 通过名称分组
        Map<String, List<Student>> listMap = students.stream().collect(Collectors.groupingBy(obj -> obj.getProvince()));
        listMap.forEach((key, value) -> {
            System.out.println("========");
            System.out.println(key);
            value.forEach(obj -> {
                System.out.println(obj.getAge());
            });
        });
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        // 根据名称分组，并统计每个分组的个数
        Map<String, Long> map = students.stream().collect(Collectors.groupingBy(Student::getProvince, Collectors.counting()));
        map.forEach((key, value) -> {
            System.out.println(key + "省人数有" + value);
        });
    }

    /**
     * 统计器summarizing
     *
     * @author Soul
     * @date 2020/2/17 23:13
     */
    private void summarizing() {
        List<Student> students = Arrays.asList(new Student("⼴东", 23),
                new Student("⼴东", 24),
                new Student("⼴东", 23),
                new Student("北京", 22),
                new Student("北京", 20),
                new Student("北京", 20),
                new Student("海南", 25));
        // summarizingInt；  summarizingLong；    summarizingDouble
        IntSummaryStatistics summaryStatistics = students.stream().collect(Collectors.summarizingInt(Student::getAge));
        System.out.println("平均值：" + summaryStatistics.getAverage());
        System.out.println("人数：" + summaryStatistics.getCount());
        System.out.println("最大值：" + summaryStatistics.getMax());
        System.out.println("最小值：" + summaryStatistics.getMin());
        System.out.println("总和：" + summaryStatistics.getSum());
    }

    /**
     * 计算器reduce
     *
     * @author Soul
     * @date 2020/2/17 23:14
     */
    private void reduce() {
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

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.collectors();
        main.counting();
        main.joining();
        main.partitioning();
        main.reduce();
        main.summarizing();
    }
}
