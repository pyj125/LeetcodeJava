package leetcode.editor.cn.multiThread;

import java.util.function.IntConsumer;

public class ZeroEvenOdd_1116 {
    private int n;

    public ZeroEvenOdd_1116(int n) {
        this.n = n;
    }

    /**
     * 第一次输出0，每次输出奇数或者偶数时，都要先打印0
     * 奇数与偶数之间也有同步，奇数打印完，打印偶数
     *
     * 也可以使用信号量，初始值表示当前的可用资源数目
     */
    Object obj = new Object();


    // 表示状态当前是0，需要打印0  是1的话，下一次需要打印奇数，是2的话打印偶数
    private volatile int cur_value = 0;


    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            synchronized (obj) {
                while (cur_value != 0) {
                    obj.wait();
                }
                printNumber.accept(0);
                obj.notifyAll();
                // 0 打印完了 下面看看当前是偶数还是奇数
                if (i % 2 == 0) {
                    cur_value = 2;
                } else {
                    cur_value = 1;
                }
            }
        }

    }

    //打印偶数 先决条件：0和奇数打印完成
    public void even(IntConsumer printNumber) throws InterruptedException {

        for (int i = 2; i <= n; i = i + 2) {
            synchronized (obj) {

                while (cur_value != 2) {
                    obj.wait();
                }
                // 0和奇数打印完了
                printNumber.accept(i);
                obj.notifyAll();
                cur_value = 0;
            }
        }

    }

    //打印奇数
    public void odd(IntConsumer printNumber) throws InterruptedException {

        for (int i = 1; i <= n; i = i + 2) {
            synchronized (obj) {
                // 0打印完了 并且 偶数也打印完了
                while (cur_value != 1) {
                    obj.wait();
                }
                printNumber.accept(i);
                obj.notifyAll();
                cur_value = 0;
            }
        }

    }

    public static void main(String[] args) {
        ZeroEvenOdd_1116 a = new ZeroEvenOdd_1116(10);

        final Test t = new Test();

        new Thread(() -> {
            try {
                a.zero(t);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                a.odd(t);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                a.even(t);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


    }

    public static class Test implements IntConsumer {
        @Override
        public void accept(int value) {
            System.out.println(value);
        }

        public Test() {
        }
    }
}
