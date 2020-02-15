package cn.xy.model;

public class AdHero extends Hero {
    public AdHero(String name, short attackPower, short moveSpeed, int hp, int mp) {
        super(name, attackPower, moveSpeed, hp, mp);
    }

    private String hurt() {
        return "我是物理伤害";
    }
}
