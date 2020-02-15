package cn.xy.service;

import cn.xy.model.Hero;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * an ordinary Hero interface
 */
public interface HeroService {
    /**
     * function of MP and HP change
     *
     * @param hero   hero
     * @param number change number
     * @param remark identify if it is HP or MP
     * @author Soul
     * @date 2020/2/3 19:33
     */
    void HpAndMpChange(Hero hero, int number, String remark) throws Exception;

    /**
     * function of MS and AP change
     *
     * @param hero   hero
     * @param number change number
     * @param remark identify if it is HP or MP
     * @author Soul
     * @date 2020/2/3 19:33
     */
    void MoveSpeedAndAttackPowerChange(Hero hero, short number, String remark) throws Exception;

    /**
     * static function, which can be implemented directly, but cannot be overridden, and is called directly through the interface name
     *
     * @param heroList a hero's list
     * @author Soul
     * @date 2020/2/3 19:36
     */
    static void war(List<Hero> heroList) {
        Optional.ofNullable(heroList).orElse(new ArrayList<>()).forEach(item -> {
            System.out.print(item.getName() + " ");
        });
        System.out.println("和您参与激烈的战斗");
    }

    /**
     * default function"kill", can be overridden and needs to be called through the implementation class
     *
     * @param hero 英雄
     * @return java.lang.String
     * @author Soul
     * @date 2020/2/3 19:36
     */
    default String kill(Hero hero) {
        return "恭喜您，击杀了敌方英雄:" + hero.getName();
    }

    /**
     * default function"assists", can be overridden and needs to be called through the implementation class
     *
     * @param killHero completed killing hero
     * @param dieHero  be killed hero
     * @return java.lang.String
     * @author Soul
     * @date 2020/2/3 19:36
     */
    default String assists(Hero killHero, Hero dieHero) {
        return "您帮助队友:" + killHero.getName() + "击杀了敌方英雄:" + dieHero.getName() + ",真是好队友";
    }

    /**
     * default function"die", can be overridden and needs to be called through the implementation class
     *
     * @param hero hero
     * @return java.lang.String
     * @author Soul
     * @date 2020/2/3 19:38
     */
    default String die(Hero hero) {
        return "非常不幸，您被敌方英雄:" + hero.getName() + "击杀,再接再厉";
    }
}
