package cn.xy.importantKnowledge.thread.demo2;

public class RunnableThread implements Runnable {
    int number1 = 0;
    int number2 = 10;

    @Override
    public void run() {
        try {
            while (number1 < number2) {
                number1++;
                Thread.sleep(1000);
                if (number1 == number2) {
                    System.out.println("number1:" + number1 + "与number2:" + number2 + "相等了");
                } else {
                    System.out.println("number1:" + number1 + "尚不等于number2:" + number2 + "，继续执行");
                }
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public static void main(String[] args) {
        RunnableThread runnableThread = new RunnableThread();
        RunnableThread runnableThread1 = new RunnableThread();

        new Thread(runnableThread).start();
        new Thread(runnableThread1).start();
    }
}
