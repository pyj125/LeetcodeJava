package leetcode.editor.cn.multiThread;

import java.util.concurrent.Semaphore;

public class Foo_1114_Semaphore {
    public Foo_1114_Semaphore() {
    }

    Semaphore first = new Semaphore(0);
    Semaphore second = new Semaphore(0);

    public void first(Runnable printFirst) throws InterruptedException {

        printFirst.run();
        first.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        first.acquire();
        printSecond.run();
        second.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        second.acquire();
        printThird.run();
    }
}
