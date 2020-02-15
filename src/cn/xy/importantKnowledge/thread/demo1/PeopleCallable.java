package cn.xy.importantKnowledge.thread.demo1;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * multi thread 3.1：implements Callable
 * Callable can do some exception handle and return message,is an upgraded version of Runnable
 *
 * @author Soul
 * @date 2020/2/3 20:12
 */
public class PeopleCallable implements Callable<String> {
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
    public PeopleCallable(String name, int age) {
        this.name = name;
        this.age = age;
    }


    /**
     *  toString method
     *
     * @author Soul
     * @date 2020/2/3 20:09
     * @return java.lang.String
     */
    @Override
    public String toString() {
        return "PeopleCallable{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    /**
     *  override Callable's call function
     *
     * @author Soul
     * @date 2020/2/3 20:09
     * @return java.lang.String
     */
    @Override
    public String call() throws Exception {
        try {
            return "我是" + name + ",我今年" + age + "岁";
        } catch (Exception e) {
            throw new Exception("参数异常");
        }
    }

    public static void main(String[] args) throws Exception {
        PeopleCallable peopleCallable = new PeopleCallable("张三", 18);
        FutureTask<String> futureTask = new FutureTask<>(peopleCallable);
        Thread thread = new Thread(futureTask, "Thread1");
        thread.start();
        try {
            System.out.println(futureTask.get());
        } catch (Exception e) {
            throw new Exception("未能获取到返回值");
        }
    }
}
