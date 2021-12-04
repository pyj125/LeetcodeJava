package test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestCase implements Runnable {

    private static volatile int cnt = 0;

    private static Object obj = new Object();
    private Lock lock = new ReentrantLock();
    private static Object obj2 = new Object();

    public static void main(String[] args) throws InterruptedException {

        // 10 个线程对一个整数进行自增操作，初始值为0，累计到1000后所有线程结束，在主线程输出结果

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new TestCase());
            t.start();
        }

        synchronized (TestCase.class) {
            while (cnt < 1000) {
                obj2.wait();
            }
        }

        System.out.println("主线程输出1000");

    }


    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                if (cnt >= 1000) {
                    break;
                }
                cnt = cnt + 1;
                System.out.println(Thread.currentThread().getName() + ":" + cnt);

            }
        }
    }
}
