package cn.xy.importantKnowledge.thread.demo2;

public class SynchronizeThread extends Thread {
    // 边加血边扣血最后应该还是10滴血，但是并不是这样
    // 没用线程同步
    final int[] hp = {10};

    private void uselessSynchronization() {
        new Thread() {
            @Override
            public void run() {
                while (hp[0] != 20) {
                    hp[0]++;
                    System.out.println("加血，当前血量" + hp[0]);
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                while (hp[0] != 0) {
                    hp[0]--;
                    System.out.println("扣血，当前血量" + hp[0]);
                }
            }
        }.start();
    }

    private void useSynchronization() {
        new Thread() {
            @Override
            public void run() {
                synchronized (hp) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    while (hp[0] != 20) {
                        hp[0]++;
                        System.out.println("加血，当前血量" + hp[0]);
                    }
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                synchronized (hp) {
                    while (hp[0] != 0) {
                        hp[0]--;
                        System.out.println("扣血，当前血量" + hp[0]);
                    }
                }
            }
        }.start();
    }

    public static void main(String[] args) {
        SynchronizeThread synchronizeThread = new SynchronizeThread();
        synchronizeThread.useSynchronization();
        System.out.println("最终血量：" + synchronizeThread.hp[0]);
    }
}
