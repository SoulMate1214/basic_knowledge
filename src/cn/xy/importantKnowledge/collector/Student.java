package cn.xy.importantKnowledge.collector;

class Student {
    private String province;
    private int age;
    public String getProvince() {
        return province;
    }
    public void setProvince(String province) {
        this.province = province;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Student(String province, int age) {
        this.age = age;
        this.province = province;
    }
}

