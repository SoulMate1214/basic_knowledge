package cn.xy.importantKnowledge.thread.threadPool;

import java.util.LinkedList;

public class TestThread {
    // 生成者个数
    int producerQuantity = 3;
    // 消费者个数
    int consumerQuantity = 5;
    // 任务个数
    int taskQuantity = 10;
    // 生产者线程集合
    static LinkedList<Runnable> tasks = new LinkedList<Runnable>();

    public void add(Runnable r) {
        synchronized (tasks) {
            tasks.add(r);
            // 每加入一个生成者线程，表示自己可以被占用，消费者线程快来执行我
            tasks.notifyAll();
        }
    }

    public void producer() {
        for (int i = 0; i < taskQuantity; i++) {
            // 生产者线程创建任务
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    //任务可能是打印一句话，可能是访问文件，可能是做排序
                    System.out.println("任务：吃东西");
                }
            };
            System.out.println("生产者线程" + i + "：成功发布任务");
            // 将所创建任务加入集合
            this.add(task);
        }
    }

    public static void main(String[] args) {
        TestThread testThread = new TestThread();
        System.out.println("共" + testThread.taskQuantity + "任务");
        System.out.println("将有" + testThread.producerQuantity + "个生产者发布任务");
        System.out.println("将有" + testThread.consumerQuantity + "个消费者执行任务");
        System.out.println("-------------------------");
        testThread.producer();
        new ThreadPool(testThread.consumerQuantity, tasks);
    }
}