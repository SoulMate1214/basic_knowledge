package cn.xy.importantKnowledge.thread.demo2;

import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 15, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

        // 等待执行的runnable
        Runnable runnable = () -> {
            try {
                System.out.println("我是正在执行的线程");
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        // 启动的任务数量
        for (int i = 0; i < 100; i++) {
            threadPool.execute(runnable);
        }

        while (true) {
            System.out.println();
            int queueSize = threadPool.getQueue().size();
            System.out.println("当前排队线程数：" + queueSize);
            int activeCount = threadPool.getActiveCount();
            System.out.println("当前活动线程数：" + activeCount);
            long completedTaskCount = threadPool.getCompletedTaskCount();
            System.out.println("执行完成线程数：" + completedTaskCount);
            long taskCount = threadPool.getTaskCount();
            System.out.println("总线程数：" + taskCount);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
