package cn.xy.importantKnowledge.set;

import cn.xy.model.Hero;

import java.util.HashMap;

public class MapDemo {
    HashMap<String, Hero> heroHashMap = new HashMap<>();

    private void hashMap() {
        // 键不可重复，会被覆盖
        heroHashMap.put("盖伦", new Hero("盖伦", (short) 50, (short) 150, 5000, 0));
        heroHashMap.put("盖伦", new Hero("钢铁雄心盖伦", (short) 50, (short) 150, 5000, 0));
        // 值可以重复
        heroHashMap.put("钢铁雄心盖伦", new Hero("钢铁雄心盖伦", (short) 50, (short) 150, 5000, 0));
        System.out.println(heroHashMap.get("盖伦"));
        System.out.println(heroHashMap);
    }

    public static void main(String[] args) {
        MapDemo mapDemo = new MapDemo();
        mapDemo.hashMap();
    }
}
