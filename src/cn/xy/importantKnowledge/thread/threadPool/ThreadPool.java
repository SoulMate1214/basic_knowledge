package cn.xy.importantKnowledge.thread.threadPool;

import java.util.LinkedList;

public class ThreadPool extends Thread {
    // 生产者线程集合
    LinkedList<Runnable> tasks;

    // 试图消费任务的线程
    public ThreadPool(int consumerQuantity, LinkedList<Runnable> tasks) {
        this.tasks = tasks;
        synchronized (tasks) {
            for (int i = 0; i < consumerQuantity; i++) {
                new TaskConsumeThread("消费者线程" + i).start();
            }
        }
    }

    class TaskConsumeThread extends Thread {
        public TaskConsumeThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println(this.getName() + "：就绪");
            Runnable task;
            while (true) {
                synchronized (tasks) {
                    while (tasks.isEmpty()) {
                        try {
                            // 表示 让占有tasks的线程等待，并临时释放占有
                            tasks.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    // 记录池里最后一个任务
                    task = tasks.removeLast();
                    // 允许添加任务的线程可以继续添加任务
                    tasks.notifyAll();
                }
                System.out.print(this.getName() + "：获取到");
                task.run();
                System.out.println(this.getName() + "：执行中……");
                System.out.println(this.getName() + "：执行完毕");
            }
        }
    }
}
