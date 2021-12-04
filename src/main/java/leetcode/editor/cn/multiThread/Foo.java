package leetcode.editor.cn.multiThread;

class Foo {

    boolean first = false;
    boolean second = false;
    Object obj = new Object();

    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (obj) {
            first = true;
            printFirst.run();
            obj.notifyAll();//唤醒其他线程
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (obj) {
            while (!first) {//当线程1执行的时候，线程2在等待，线程1设置了first=true，while条件不成立，线程2开始执行
                obj.wait();
            }
            printSecond.run();
            second = true;
            obj.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (obj) {
            while (!second) {
                obj.wait();
            }
            printThird.run();
            obj.notifyAll();
        }
    }
}

