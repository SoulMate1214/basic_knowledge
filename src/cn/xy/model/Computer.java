package cn.xy.model;

import java.util.Date;

public class Computer {
    // four different modifiers
    private String name;
    int price;
    protected static Date date;
    public String type;

    // static method,static is shared, no need to create an instance
    public static void showDate(Date date1) {
        System.out.println(date);
        System.out.println(date1);
    }

    public static void main(String[] args) {
        Computer.date = new Date();
        Computer.showDate(new Date());
        Computer computer = new Computer();
        computer.showDate(new Date());
    }
}
