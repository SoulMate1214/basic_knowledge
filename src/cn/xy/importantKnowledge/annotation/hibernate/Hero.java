package cn.xy.importantKnowledge.annotation.hibernate;

@MyEntity
@MyTable(name="hero")
public class Hero {
    private int id;
    private String name;
    private int damage;
    private int armor;

    @MyId
    @MyGeneratedValue(strategy = "identity")
    @MyColumn("id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @MyColumn("name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @MyColumn("damage")
    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    @MyColumn("armor")
    public int getArmor() {
        return armor;
    }
    public void setArmor(int armor) {
        this.armor = armor;
    }

}