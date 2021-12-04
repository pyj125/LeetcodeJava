package leetcode.editor.cn.multiThread;

import java.util.concurrent.Semaphore;

public class CountNumNew {
    public volatile int cnt = 0;
    final static int TOTAL = 1000;

    Semaphore sema = new Semaphore(1);
    Semaphore main = new Semaphore(0);

    /**
     * 分析：
     * 多个线程需要对一个整形变量加1，这个加1操作应该在临界区进行，需要进行同步
     * 1.多个个线程在执行计数操作，每次只有一个线程能够进入临界区，进行加1操作，因此需要一个许可，当线程进入时，获取这个许可，许可证数为0，其他线程就在等待，
     * 直到获取了许可证的线程完成加1操作并释放许可证后，线程重新开始竞争这个许可证
     * 2.主线程一开始就要阻塞，直到所有任务都完成后，才打印任务完成，那如何感知呢？因此需要一个信号量来告诉主线程，任务完成。
     * 当前线程获取到一个许可，就进行后续操作，如果当前计数小于指定值，那么做+1操作，否则说明多线程计数全部执行完毕，释放主线程的信号量，主线程不再阻塞
     */
    public void addNum() throws InterruptedException {

        for(int i=1;i<=TOTAL;i++){
            //如果许可证足够的话，拿走一个许可，否则阻塞在这里
            sema.acquire(1);
            if (cnt < TOTAL) {
                cnt = cnt + 1;
                System.out.println(Thread.currentThread().getName() + " cnt=" + cnt);
            } else {
                // 任务执行完毕，释放主线程的许可证，主线程不再阻塞
                main.release();
            }
            //释放这个许可证，同其他线程继续竞争
            sema.release();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        CountNumNew c = new CountNumNew();
        for(int i=0;i<5;i++){
            new Thread(() -> {
                try {
                    c.addNum();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        // 主线程最开始没有许可，阻塞在这里，只有等任务全部结束了才能获得这个许可
        c.main.acquire();
        System.out.println("main thread finished");

    }
}
