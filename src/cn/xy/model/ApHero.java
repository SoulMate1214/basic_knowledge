package cn.xy.model;

public abstract class ApHero extends Hero{
    public ApHero(String name, short attackPower, short moveSpeed, int hp, int mp) {
        super(name, attackPower, moveSpeed, hp, mp);
    }
    public abstract String hurt();
}
