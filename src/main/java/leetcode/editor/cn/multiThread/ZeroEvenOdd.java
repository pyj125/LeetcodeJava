package leetcode.editor.cn.multiThread;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;

    // 默认 zero 有一个信号量可用
    private Semaphore zero = new Semaphore(1);

    // 默认 even 和 odd 没有可用信号量
    private Semaphore even = new Semaphore(0);
    private Semaphore odd = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    /**
     * 可以使用信号量，初始值表示当前的可用资源数目
     */
    public void zero(IntConsumer printNumber) throws InterruptedException {

        for (int i = 1;i <= n; i++){
            // 首次执行时， zero 有一个可用的信号量
            zero.acquire();
            printNumber.accept(0);
            if(i % 2 == 1){
                // 可以理解为 odd 增加一个信号量，这样 odd 可以继续走流程
                odd.release();
            }else{
                // 可以理解为 even 增加一个信号量， 这样 even 可以继续走流程
                even.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n;i += 2){
            // 等待信号量，获取到了信号后，往下走
            even.acquire();
            printNumber.accept(i);
            // 发送信号量给 zero
            zero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {

        for (int i = 1; i <= n; i += 2){
            // 等待信号量，获取到了信号后，往下走
            odd.acquire();
            printNumber.accept(i);
            // 发送信号量给 zero
            zero.release();
        }
    }
}

