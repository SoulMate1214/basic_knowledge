package cn.xy.importantKnowledge.set;

import cn.xy.model.Hero;

import java.util.*;

public class ListDemo {

    /**
     * 插入删除速度快
     */
    private void linkedList() {
        LinkedList<Hero> heroes = new LinkedList<>();
        heroes.addFirst(new Hero("盖伦", (short) 50, (short) 150, 5000, 0));
        heroes.addLast(new Hero("赵信", (short) 50, (short) 150, 5000, 0));
        //查看最前面的英雄
        System.out.println(heroes.getFirst());
        //查看最后面的英雄
        System.out.println(heroes.getLast());
        //取出最前面的英雄,会被移除
        System.out.println(heroes.removeFirst());
        //取出最后面的英雄,会被移除
        System.out.println(heroes.removeLast());

        Queue queue = new LinkedList();
        //加在队列的最后面
        queue.offer(new Hero("盖伦", (short) 50, (short) 150, 5000, 0));
        //取出第一个Hero,不会被删除
        System.out.println(queue.peek());
        //取出第一个Hero,会被删除
        System.out.println(queue.poll());
        List<Hero> stack = new Stack<>();
    }

    /**
     * 顺序读取速度快
     */
    private void arrayList() {
        List<Hero> heroes = new ArrayList<>();
        List<Hero> heroes2 = new ArrayList<>();
        // 添加
        heroes.add(new Hero("盖伦", (short) 50, (short) 150, 5000, 0));
        heroes.add(new Hero("赵信", (short) 50, (short) 150, 5000, 0));
        // 判断是否存在
        System.out.println(heroes.contains(new Hero("赵信", (short) 50, (short) 150, 5000, 0)));
        // List大小
        System.out.println(heroes.size());
        // 对象所处位置
        System.out.println("盖伦所处的位置:" + heroes.indexOf(new Hero("盖伦", (short) 50, (short) 150, 5000, 0)));
        // 根据下标删除
        heroes.remove(1);
        // 根据对象删除
        heroes.remove(new Hero("盖伦", (short) 50, (short) 150, 5000, 0));
        // 替换对象
        heroes.add(new Hero("盖伦", (short) 50, (short) 150, 5000, 0));
        heroes.add(new Hero("赵信", (short) 50, (short) 150, 5000, 0));
        heroes.set(0, new Hero("艾希", (short) 50, (short) 150, 1500, 2000));
        heroes.set(1, new Hero("安妮", (short) 50, (short) 150, 1500, 2000));
        System.out.println("--------------------");
        // 转为数组
        System.out.println(Arrays.toString(heroes.toArray(new Hero[]{})));
        System.out.println("--------------------");
        // 另一个容器所有对象都加进来
        heroes2.add(new Hero("机器人", (short) 50, (short) 150, 5000, 0));
        heroes2.add(new Hero("蒙多", (short) 50, (short) 150, 5000, 0));
        heroes.addAll(heroes2);
        // 清空
        heroes2.clear();
        System.out.println(Arrays.toString(heroes2.toArray(new Hero[]{})));
        System.out.println("--------------------");
        // foreach遍历
        for (Hero hero : heroes) {
            System.out.println(hero);
        }
        System.out.println("--------------------");
        // for遍历
        for (int i = 0; i < heroes.size(); i++) {
            System.out.println(heroes.get(i));
        }
        System.out.println("--------------------");
        // 迭代器之for遍历
        for (Iterator<Hero> heroIterator = heroes.iterator(); heroIterator.hasNext(); ) {
            System.out.println(heroIterator.next());
        }
        System.out.println("--------------------");
        // 迭代器之while遍历
        Iterator<Hero> heroIterator = heroes.iterator();
        while (heroIterator.hasNext()) {
            System.out.println(heroIterator.next());
        }
    }

    public static void main(String[] args) {
        ListDemo listDemo = new ListDemo();
        listDemo.linkedList();
    }
}
