package cn.xy.importantKnowledge.set;

import cn.xy.model.Hero;

import java.util.HashSet;

public class SetDemo {
    private void hashSet() {
        //  不能重复，只能添加一个相同的
        HashSet<String> strings = new HashSet<>();
        strings.add("123");
        strings.add("123");
        strings.add("3254");
        strings.add("111");
        // 和hashMap一样，是无序的，它会根据asc码自排序
        System.out.println(strings);
        HashSet<Hero> heroes = new HashSet<Hero>();
        heroes.add(new Hero("钢铁雄心盖伦", (short) 50, (short) 150, 5000, 0));
        heroes.add(new Hero("钢铁雄心盖伦", (short) 50, (short) 150, 5000, 0));
        System.out.println(heroes);
    }

    public static void main(String[] args) {
        SetDemo setDemo = new SetDemo();
        setDemo.hashSet();
    }
}
