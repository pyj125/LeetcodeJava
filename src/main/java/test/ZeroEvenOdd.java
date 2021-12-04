package test;

import java.util.function.IntConsumer;

public class ZeroEvenOdd {

    private int n;
    private Object prev;
    private Object self;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    //当前打印的是奇数 下一个就是偶数 满足条件加锁

    /**
     * wait
     * @param printNumber
     * @throws InterruptedException
     */
    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {

    }

    public void even(IntConsumer printNumber) throws InterruptedException {

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {

    }
}
