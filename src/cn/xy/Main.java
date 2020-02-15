package cn.xy;

import cn.xy.model.AdHero;
import cn.xy.model.ApHero;
import cn.xy.model.HelloWorld;
import cn.xy.model.Hero;
import cn.xy.service.HeroService;
import cn.xy.service.implement.HeroServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * main function entry
 *
 * @author Soul
 * @date 2020/2/3 19:30
 */
public class Main {
    public static void main(String[] args) throws Exception {
        // 1.HelloWorld method
        HelloWorld helloWorld = new HelloWorld();

        // 2.class and object
        Hero Galen = new Hero("盖伦", (short) 50, (short) 150, 5000, 0);
        Hero Ashe = new Hero("艾希", (short) 100, (short) 100, 2000, 3000);
        Hero Annie = new Hero("安妮", (short) 100, (short) 50, 2000, 5000);
        List<Hero> heroList = Arrays.asList(Galen, Ashe, Annie);
        Optional.of(heroList).orElse(new ArrayList<>()).forEach(System.out::println);

        // 3.method call
        HeroService heroServiceImpl = new HeroServiceImpl();
        HeroService.war(heroList);
        heroServiceImpl.HpAndMpChange(Galen, -1000, "HP");
        heroServiceImpl.HpAndMpChange(Galen, 1000, "MP");
        heroServiceImpl.MoveSpeedAndAttackPowerChange(Galen, (short) 50, "AP");
        heroServiceImpl.MoveSpeedAndAttackPowerChange(Galen, (short) -50, "MS");
        System.out.println(heroServiceImpl.kill(Galen));
        System.out.println(heroServiceImpl.assists(Ashe, Annie));
        System.out.println(heroServiceImpl.die(Annie));
        System.out.println(Galen);


        // down transformation
        AdHero adHero = new AdHero("盖伦", (short) 50, (short) 150, 5000, 0);
//        adHero = (AdHero) Galen;
        System.out.println(adHero instanceof AdHero);
        // up transformation
        Hero hero = adHero;
        System.out.println(hero instanceof AdHero);
        System.out.println(adHero.getName());
        System.out.println(hero.getName());

        // abstract class and abstract method
        ApHero apHero = new ApHero("安妮", (short) 100, (short) 50, 2000, 5000) {
            @Override
            public String hurt() {
                return "我是魔法伤害";
            }
        };
        System.out.println(apHero.getName());
    }
}
