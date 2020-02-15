package cn.xy.importantKnowledge.thread.demo2;

import java.util.concurrent.ThreadPoolExecutor;

public class PvThread extends Thread {
    public static void main(String[] args) {
        final int[] hp = {10};
        new Thread() {
            @Override
            public void run() {
                synchronized (hp) {
                    while (true) {
                        // 同P操作，占用加锁的资源
                        hp.notify();
                        hp[0]--;
                        System.out.println("我在扣血，现在血量：" + hp[0]);

                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (hp[0] == 1) {
                            try {
                                // 同V操作，释放加锁的资源，并让自己等待
                                hp.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                synchronized (hp) {
                    while (true) {
                        // 同P操作，占用加锁的资源
                        hp.notify();
                        hp[0]++;
                        System.out.println("我在加血，现在血量：" + hp[0]);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (hp[0] == 10) {
                            try {
                                // 同V操作，释放加锁的资源，并让自己等待
                                hp.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }.start();
    }
}
