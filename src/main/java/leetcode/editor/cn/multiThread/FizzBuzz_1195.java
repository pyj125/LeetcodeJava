package leetcode.editor.cn.multiThread;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class FizzBuzz_1195 {
    private int n;

    public FizzBuzz_1195(int n) {
        this.n = n;
    }

    public final static int TOTAL = 1500;

    Semaphore semaphore = new Semaphore(1);
    Semaphore main = new Semaphore(0);
    public int cnt = 1;


    /**
     * 只能被3整除 printFizz.run() outputs "fizz"
     *
     * @param printFizz
     * @throws InterruptedException
     */
    public void fizz(Runnable printFizz) throws InterruptedException {
        semaphore.acquire();
        if(cnt<=n){
            if (cnt % 15 != 0 && cnt % 3 == 0) {
                printFizz.run();
                cnt++;
            }
            semaphore.release();
        }else{
            main.release();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        semaphore.acquire();
        if(cnt<=n){
            if (cnt % 15 != 0 && cnt % 5 == 0) {
                printBuzz.run();
                cnt++;
            }
            semaphore.release();
        }else{
            main.release();
        }

    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        semaphore.acquire();
        if(cnt<=n){
            if (cnt % 15 == 0) {
                printFizzBuzz.run();
                cnt++;
            }
            semaphore.release();
        }else{
            main.release();
        }

    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        semaphore.acquire();
        if(cnt<=n){
            if (cnt % 3 != 0 && cnt % 5 != 0) {
                printNumber.accept(cnt);
                cnt++;
            }
            semaphore.release();
        }else{
            main.release();
        }

    }


    public static void main(String[] args) throws InterruptedException {
        FizzBuzz_1195 order = new FizzBuzz_1195(20);

        new Thread(
                () -> {
                    for (int i = 0; i < TOTAL; i++) {
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
                }
        ).start();


        new Thread(
                () -> {
                    for (int i = 0; i < TOTAL; i++) {
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
                }
        ).start();

        new Thread(
                () -> {
                    for (int i = 0; i < TOTAL; i++) {
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
                }
        ).start();

        new Thread(
                () -> {
                    for (int i = 0; i < TOTAL; i++) {
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

                }
        ).start();
        order.main.acquire();
        System.out.println("main finished");
    }
}
