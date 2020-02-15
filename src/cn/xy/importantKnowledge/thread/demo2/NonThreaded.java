package cn.xy.importantKnowledge.thread.demo2;

// 非线程
public class NonThreaded {
    int number1 = 0;
    int number2 = 10;

    private void thread() {
        try {
            number1++;
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void equal() {
        if (number1 == number2) {
            System.out.println("number1:" + number1 + "与number2:" + number2 + "相等了");
        } else {
            System.out.println("number1:" + number1 + "尚不等于number2:" + number2 + "，继续执行");
        }
    }

    public static void main(String[] args) {
        NonThreaded nonThreaded = new NonThreaded();
        NonThreaded nonThreaded1 = new NonThreaded();

        while (nonThreaded.number1 < nonThreaded.number2) {
            nonThreaded.thread();
            nonThreaded.equal();
        }
        while (nonThreaded1.number1 < nonThreaded1.number2) {
            nonThreaded1.thread();
            nonThreaded1.equal();
        }
    }
}
