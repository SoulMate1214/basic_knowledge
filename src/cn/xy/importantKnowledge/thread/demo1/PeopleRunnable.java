package cn.xy.importantKnowledge.thread.demo1;

/**
 * multi thread 2：implements Runnable
 * Thread’s Run method essence is to achieve Runnable‘s Run method
 *
 * @author Soul
 * @date 2020/2/3 20:12
 */
public class PeopleRunnable implements Runnable {
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
    public PeopleRunnable(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     *  override Runnable's run function
     *
     * @author Soul
     * @date 2020/2/3 20:09
     */
    @Override
    public void run() {
        System.out.println("我是" + name + ",我今年" + age + "岁");
    }

    // main function entry
    public static void main(String[] args) {
        PeopleRunnable peopleRunnable = new PeopleRunnable("张三", 18);
        PeopleRunnable peopleRunnable1 = new PeopleRunnable("李四", 20);
        PeopleRunnable peopleRunnable2 = new PeopleRunnable("王五", 25);

        Thread thread = new Thread(peopleRunnable);
        Thread thread1 = new Thread(peopleRunnable1);
        Thread thread2 = new Thread(peopleRunnable2);
        thread.start();
        thread1.start();
        thread2.start();
        System.out.println("张三的线程名称是：" + thread.getName() + ",线程Id为" + thread.getId());
        System.out.println("李四的线程名称是：" + thread1.getName() + ",线程Id为" + thread1.getId());
        System.out.println("王五的线程名称是：" + thread2.getName() + ",线程Id为" + thread2.getId());
    }
}
