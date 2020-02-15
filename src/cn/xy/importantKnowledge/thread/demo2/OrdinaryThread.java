package cn.xy.importantKnowledge.thread.demo2;

public class OrdinaryThread extends Thread {
    int number1 = 0;
    int number2 = 10;

    @Override
    public void run() {
        try {
            while (number2 > number1) {
                number1++;
                Thread.sleep(1000);
                if (number1 == number2) {
                    System.out.println("number1:" + number1 + "与number2:" + number2 + "相等了");
                } else {
                    System.out.println("number1:" + number1 + "尚不等于number2:" + number2 + "，继续执行");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        OrdinaryThread ordinaryThread = new OrdinaryThread();
        OrdinaryThread ordinaryThread1 = new OrdinaryThread();

//        // 设置进程优先级，去掉sleep才能看出效果
//        ordinaryThread.setPriority(10);
//        ordinaryThread1.setPriority(1);

//        // 变成守护线程，若是全部成为守护线程则终止了进程
//        ordinaryThread.setDaemon(true);
        ordinaryThread.start();

//        // 线程临时暂停
//        ordinaryThread.yield();

//            //ordinaryThread线程加入到main线程中来，只有ordinaryThread线程运行结束，才会继续往下走
//        try {
//            ordinaryThread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        // 变成守护线程，若是全部成为守护线程则终止了进程
//        ordinaryThread1.setDaemon(true);
        ordinaryThread1.start();
    }

}
