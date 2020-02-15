package cn.xy.model;

import java.util.Objects;

public class People {
    int HP;

    @Override
    public String toString() {
        return "People{" +
                "HP=" + HP +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof People)) return false;
        People people = (People) o;
        return getHP() == people.getHP();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHP());
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }
}
