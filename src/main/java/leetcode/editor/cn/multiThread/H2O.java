package leetcode.editor.cn.multiThread;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

class H2O {

    private final Semaphore hSem = new Semaphore(2);
    private final Semaphore oSem = new Semaphore(1);
    private final CyclicBarrier barrier = new CyclicBarrier(3);

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hSem.acquire();
        try {
            barrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        hSem.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oSem.acquire();
        try {
            barrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        // releaseOxygen.run() outputs "H". Do not change or remove this line.
        releaseOxygen.run();
        oSem.release();
    }

    public static void main(String[] args) {
        H2O a = new H2O();

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

