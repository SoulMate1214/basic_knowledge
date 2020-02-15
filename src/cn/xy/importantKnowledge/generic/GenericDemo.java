package cn.xy.importantKnowledge.generic;

import cn.xy.model.AdHero;
import cn.xy.model.Hero;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *  注意：父子泛型不能相互转换
 *
 * @author Soul
 * @date 2020/2/11 20:41
 */
public class GenericDemo {

    private void GenericDemo1() {
        LinkedList<? super Hero> heroList;
        // ? super Hero 表示 heroList的泛型是Hero或者其父类泛型
        // heroList 的泛型可以是Hero
        // heroList 的泛型可以是Object
        heroList = new LinkedList<Object>();
        // 所以就可以插入Hero
        heroList.add(new Hero("盖伦", (short) 50, (short) 150, 5000, 0));
        // 也可以插入Hero的子类
        heroList.add(new AdHero("盖伦", (short) 50, (short) 150, 5000, 0));
        // 但是，不能从里面取数据出来,因为其泛型可能是Object,而Object是强转Hero会失败
        // Hero h= heroList.get(0);
    }

    private void GenericDemo2() {
        ArrayList<AdHero> adHeroes = new ArrayList<AdHero>();
        adHeroes.add(new AdHero("盖伦", (short) 50, (short) 150, 5000, 0));
        //? extends Hero 表示这是一个Hero泛型的子类泛型
        //heroList 的泛型可以是Hero
        //heroList 的泛型可以使APHero
        //heroList 的泛型可以使ADHero
        ArrayList<? extends Hero> heroList;
        heroList = adHeroes;
        //可以确凿的是，从heroList取出来的对象，一定是可以转型成Hero的
        Hero h = heroList.get(0);
        //但是，不能往里面放东西
        //编译错误，因为heroList的泛型 有可能是APHero
        // heroList.add(new Hero("盖伦", (short) 50, (short) 150, 5000, 0));
    }

    public static void main(String[] args) {
        GenericDemo genericDemo = new GenericDemo();
        genericDemo.GenericDemo1();
        genericDemo.GenericDemo2();
    }
}
