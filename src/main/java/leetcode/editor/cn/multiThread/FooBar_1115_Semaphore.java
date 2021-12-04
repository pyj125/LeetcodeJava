package leetcode.editor.cn.multiThread;

import java.util.concurrent.Semaphore;

public class FooBar_1115_Semaphore {
    private int n;
    public FooBar_1115_Semaphore(int n) {
        this.n = n;
    }

    Semaphore foo = new Semaphore(1);
    Semaphore bar = new Semaphore(0);


    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            foo.acquire();
            printFoo.run();
            bar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            bar.acquire();
            printBar.run();
            foo.release();
        }
    }

    public static void main(String[] args) {


        FooBar_1115_Semaphore order = new FooBar_1115_Semaphore(20);

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
