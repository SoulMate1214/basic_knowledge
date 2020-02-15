package cn.xy.importantKnowledge.thread.demo1;

/**
 *  multi thread 1：extends Thread
 *
 * @author Soul
 * @date 2020/2/3 20:12
 */
public class PeopleThread extends Thread {
    // declaring entity class attributes
    private String name;
    private int age;

    /**
     *  override constructor
     *
     * @author Soul
     * @date 2020/2/3 19:49
     * @param name name
     * @param age age
     */
    public PeopleThread(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     *  override Thread's run function
     *
     * @author Soul
     * @date 2020/2/3 20:10
     */
    @Override
    public void run() {
        System.out.println("我是" + name + ",我今年" + age + "岁");
    }

    // main function entry
    public static void main(String[] args) {
        PeopleThread peopleThread = new PeopleThread("张三", 18);
        PeopleThread peopleThread1 = new PeopleThread("李四", 20);
        PeopleThread peopleThread2 = new PeopleThread("王五", 25);
        peopleThread.start();
        peopleThread1.start();
        peopleThread2.start();
        System.out.println("张三的线程名称是：" + peopleThread.getName() + ",线程Id为" + peopleThread.getId());
        System.out.println("李四的线程名称是：" + peopleThread1.getName() + ",线程Id为" + peopleThread1.getId());
        System.out.println("王五的线程名称是：" + peopleThread2.getName() + ",线程Id为" + peopleThread2.getId());
    }
}
