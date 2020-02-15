package cn.xy.importantKnowledge.thread.demo2;

public class Deadlock extends Thread {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        final Integer[] count = new Integer[1];
        new Thread() {
            @Override
            public void run() {
                synchronized (a) {
                    try {
                        System.out.println("我已占用了a，等1秒，让另一个进程有充足时间占用b");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("尝试占用b…………");
                    synchronized (b) {
                        count[0] = a + b;
                        System.out.println(count[0]);
                    }
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                synchronized (b) {
                    try {
                        System.out.println("我已占用了b，等1秒，让另一个进程有充足时间占用a");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("尝试占用a…………");
                    synchronized (a) {
                        count[0] = a + b;
                        System.out.println(count[0]);
                    }
                }
            }
        }.start();
    }
}
