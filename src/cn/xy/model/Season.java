package cn.xy.model;

/**
 * enum class
 * 1. can implements interface's method
 * 2. can custom enum value
 * 3. can only define enum variables not assignment
 */
public enum Season {
    SPRING("春天"), SUMMER("夏天"), AUTUMN("秋天"), WINTER("冬天");

    private String name;

    Season(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
