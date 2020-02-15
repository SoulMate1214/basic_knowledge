package cn.xy.importantKnowledge.set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 与Collection接口区分开，Collections类是操作集合的一个工具类。而不是Set和List的顶层接口Collection
 *
 * @author Soul
 * @date 2020/2/10 23:20
 */
public class CollectionsDemo {

    /**
     * 反转
     *
     * @author Soul
     * @date 2020/2/10 23:23
     */
    private void reverse() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }
        System.out.println("集合中的数据:");
        System.out.println(numbers);
        Collections.reverse(numbers);
        System.out.println("翻转后集合中的数据:");
        System.out.println(numbers);
    }

    /**
     * 打乱
     *
     * @author Soul
     * @date 2020/2/10 23:23
     */
    private void shuffle() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }
        System.out.println("集合中的数据:");
        System.out.println(numbers);
        Collections.shuffle(numbers);
        System.out.println("混淆后集合中的数据:");
        System.out.println(numbers);

    }

    /**
     * 排序
     *
     * @author Soul
     * @date 2020/2/10 23:25
     */
    private void sort() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }
        System.out.println("集合中的数据:");
        System.out.println(numbers);
        Collections.shuffle(numbers);
        System.out.println("混淆后集合中的数据:");
        System.out.println(numbers);
        Collections.sort(numbers);
        System.out.println("排序后集合中的数据:");
        System.out.println(numbers);
    }

    /**
     * 移动
     *
     * @author Soul
     * @date 2020/2/10 23:26
     */
    private void rotate() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }
        System.out.println("集合中的数据:");
        System.out.println(numbers);
        Collections.rotate(numbers, 2);
        System.out.println("把集合向右滚动2个单位，标的数据后，集合中的数据:");
        System.out.println(numbers);
    }

    /**
     * 转为线程安全的集合
     *
     * @author Soul
     * @date 2020/2/10 23:27
     */
    private void synchronizedList() {
        List<Integer> numbers = new ArrayList<>();
        System.out.println("把非线程安全的List转换为线程安全的List");
        List<Integer> synchronizedNumbers = (List<Integer>) Collections.synchronizedList(numbers);
    }

    public static void main(String[] args) {
        CollectionsDemo demo = new CollectionsDemo();
        demo.reverse();
        demo.rotate();
        demo.shuffle();
        demo.sort();
        demo.synchronizedList();
    }
}
