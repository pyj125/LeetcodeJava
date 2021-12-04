package leetcode.editor.cn.multiThread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class H2O_1117_CyclicBarrier {

    public H2O_1117_CyclicBarrier() {

    }

    public final static int CNT = 10;

    /**
     * 分析：使用信号量和屏障来进行线程之间的同步
     * CyclicBarrier ： 所有线程都进行等待，直到所有线程都准备好（全部调用进入await()方法之后），所有线程同时开始执行。
     * 生成H的许可 2  生成O的许可 1   开启下一个水分子的条件  2个H 和 1个O都完成
     *
     *新增问题：如果要在每一个水分子后面打印一个分隔符'|'，该如何处理
     * CyclicBarrier 有一个getNumberWaiting()方法可以获得CyclicBarrier阻塞的线程数量
     * 在一个线程获得许可进入后续处理后，在await()前，判断当前的已经到达屏障的线程数量是否为 3-1=2
     */
    // H 设置两个许可
    Semaphore hy = new Semaphore(2);
    // 0 设置0个许可，开始O线程会阻塞，直到两个H线程完成后并增加0的许可，才会继续执行
    Semaphore ox = new Semaphore(1);

    CyclicBarrier barrier = new CyclicBarrier(3);


    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        hy.acquire();
        try {

            if(barrier.getNumberWaiting()==2){
                System.out.print("|");
            }
            barrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        releaseHydrogen.run();

        hy.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        // 需要两个许可，一开始阻塞，直到每一个H线程完成并释放信号量，达到两个O的许可，才会继续执行
        ox.acquire();
        try {
            if(barrier.getNumberWaiting()==2){
                System.out.print("|");
            }
            barrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        releaseOxygen.run();

        ox.release();
    }

    public static void main(String[] args) {
        H2O_1117_CyclicBarrier a = new H2O_1117_CyclicBarrier();

        for (int i = 0; i < CNT*2; i++) {
            new Thread(() -> {
                try {
                    a.hydrogen(new Runnable() {
                        @Override
                        public void run() {

                            System.out.print("H");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }).start();
        }


        for (int i = 0; i < CNT; i++) {
            new Thread(() -> {
                try {
                    a.oxygen(new Runnable() {
                        @Override
                        public void run() {
                            System.out.print("O");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }).start();
        }

    }
}
