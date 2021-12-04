package leetcode.editor.cn.multiThread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class FooBar_1115_CyclicBarrier {
    private int n;

    public FooBar_1115_CyclicBarrier(int n) {
        this.n = n;
    }

    CyclicBarrier barrier = new CyclicBarrier(2);

    // 用来控制 两个线程的起始和交替执行
    boolean fooFlag = true;

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 1; i <= n; i++) {
            while (!fooFlag){
            }
            printFoo.run();
            fooFlag = false;
            try {
                barrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 1; i <= n; i++) {
            try {
                //开始阻塞在这里，一组2个线程全部到达屏障后，向后执行
                barrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            printBar.run();
            fooFlag = true;
        }
    }

    public static void main(String[] args) {


        FooBar_1115_CyclicBarrier order = new FooBar_1115_CyclicBarrier(20);

        new Thread(
                () -> {
                    try {
                        order.foo(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("foo");
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        ).start();

        new Thread(
                () -> {
                    try {
                        order.bar(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("bar");
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        ).start();
    }
}
