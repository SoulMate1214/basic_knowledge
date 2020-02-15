package cn.xy.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * a hero object
 *
 * @author Soul
 * @date 2020/1/28 21:57
 */
public class Hero implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private short attackPower;
    private short moveSpeed;
    private int Hp;
    private int Mp;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(short attackPower) {
        this.attackPower = attackPower;
    }

    public short getMoveSpeed() {
        return moveSpeed;
    }

    public void setMoveSpeed(short moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    public int getHp() {
        return Hp;
    }

    public void setHp(int hp) {
        Hp = hp;
    }

    public int getMp() {
        return Mp;
    }

    public void setMp(int mp) {
        Mp = mp;
    }

    public Hero(String name, short attackPower, short moveSpeed, int hp, int mp) {
        this.name = name;
        this.attackPower = attackPower;
        this.moveSpeed = moveSpeed;
        Hp = hp;
        Mp = mp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hero)) return false;
        Hero hero = (Hero) o;
        return getAttackPower() == hero.getAttackPower() &&
                getMoveSpeed() == hero.getMoveSpeed() &&
                getHp() == hero.getHp() &&
                getMp() == hero.getMp() &&
                getName().equals(hero.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAttackPower(), getMoveSpeed(), getHp(), getMp());
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", attackPower=" + attackPower +
                ", moveSpeed=" + moveSpeed +
                ", Hp=" + Hp +
                ", Mp=" + Mp +
                '}';
    }
}
