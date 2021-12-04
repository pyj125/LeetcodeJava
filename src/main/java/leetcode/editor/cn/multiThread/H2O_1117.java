package leetcode.editor.cn.multiThread;

import java.util.concurrent.Semaphore;

public class H2O_1117 {
    public H2O_1117() {

    }

    // 这种方式生成的都是 HHO HHO 这样的固定顺序
    // H 设置两个许可
    Semaphore hy = new Semaphore(2);
    // 0 设置0个许可，开始O线程会阻塞，直到两个H线程完成后并增加0的许可，才会继续执行
    Semaphore ox = new Semaphore(0);


    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        hy.acquire();
        releaseHydrogen.run();
        ox.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        // 需要两个许可，一开始阻塞，直到每一个H线程完成并释放信号量，达到两个O的许可，才会继续执行
        ox.acquire(2);
        releaseOxygen.run();
        hy.release(2);
    }

    public static void main(String[] args) {
        H2O_1117 a = new H2O_1117();

        for (int i = 0; i < 20; i++) {
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


        for (int i = 0; i < 10; i++) {
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
