package cn.xy.importantKnowledge.thread.demo2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableThread implements Callable<String> {
    int number1 = 0;
    int number2 = 10;

    @Override
    public String call() throws Exception {
        while (number1 < number2) {
            number1++;
            Thread.sleep(1000);
            if (number1 == number2) {
                System.out.println("number1:" + number1 + "与number2:" + number2 + "相等了");
            } else {
                System.out.println("number1:" + number1 + "尚不等于number2:" + number2 + "，继续执行");
            }
        }
        return "结束";
    }

    public static void main(String[] args) {
        CallableThread callableThread = new CallableThread();
        CallableThread callableThread1 = new CallableThread();
        FutureTask<String> futureTask = new FutureTask<>(callableThread);
        FutureTask<String> futureTask1 = new FutureTask<>(callableThread1);
        new Thread(futureTask).start();
        new Thread(futureTask1).start();
        try {
            System.out.println(futureTask.get());
            System.out.println(futureTask1.get());
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
