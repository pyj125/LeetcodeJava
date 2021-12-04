package leetcode.editor.cn.multiThread;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class FizzBuzz_1195_Update {
    private int n;
    public FizzBuzz_1195_Update(int n) {
        this.n = n;
    }

    /**
     * 当某个线程使用完共享资源后，释放信号量，并将信号量内部的计数器加1，之前进入休眠的线程将被唤醒并再次试图获得信号量
     */
    Semaphore fizz = new Semaphore(0);
    Semaphore buzz = new Semaphore(0);
    Semaphore fizzbuzz = new Semaphore(0);

    // 该信号量控制最开始的线程启动 此时其余线程阻塞在它们第一个要打印的数的位置，
    Semaphore number = new Semaphore(1);
    //如果所有任务结束后，要在主线程输出，可以加这个信号量
    Semaphore main = new Semaphore(0);


    public void fizz(Runnable printFizz) throws InterruptedException {

        for (int i = 1; i <= n; i++) {
            if (i % 5 != 0 && i % 3 == 0) {
                fizz.acquire();
                printFizz.run();
                number.release();
                if(i == n){
                    main.release();
                }
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {

        for (int i = 1; i <= n; i++) {
            if (i % 3 != 0 && i % 5 == 0) {
                buzz.acquire();
                printBuzz.run();
                number.release();
                if(i == n){
                    main.release();
                }
            }

        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                fizzbuzz.acquire();
                printFizzBuzz.run();
                number.release();
                if(i == n){
                    main.release();
                }
            }

        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            // 如果既不能被3 也不能被5整除
            number.acquire();
            if (i % 3 != 0 && i % 5 != 0) {
                printNumber.accept(i);
                number.release();
            } else if (i % 5 != 0 && i % 3 == 0) {
                // 释放许可
                fizz.release();
            } else if (i % 3 != 0 && i % 5 == 0) {
                buzz.release();
            } else {
                fizzbuzz.release();
            }
            if(i == n){
                main.release();
            }
        }

    }


    public static void main(String[] args) throws InterruptedException {
        FizzBuzz_1195_Update order = new FizzBuzz_1195_Update(150);

        new Thread(
                () -> {
                    try {
                        order.fizz(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("fizz");
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
                        order.buzz(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("buzz");
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
                        order.fizzbuzz(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("fizzbuzz");
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
                        order.number(new IntConsumer() {
                            @Override
                            public void accept(int value) {
                                System.out.println(value);
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        ).start();
        order.main.acquire();
        System.out.println("main finished");
    }
}
