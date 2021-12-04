package leetcode.editor.cn.multiThread;

public class FooBar_1115 {
    private int n;
    public FooBar_1115(int n) {
        this.n = n;
    }

    Object obj = new Object();
    // 表示第一个线程执行任务是否完成
    boolean first_flag  = false;
    // 表示第二个线程执行任务是否完成 初始时第二个线程完成，因为第一个运行的是线程1
    boolean second_flag = true;

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // printFoo.run() outputs "foo". Do not change or remove this line.
            synchronized (obj){
                while (!second_flag){
                    obj.wait();
                }
                printFoo.run();
                obj.notifyAll();
                first_flag = true;
                second_flag = false;
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // printBar.run() outputs "bar". Do not change or remove this line.
            synchronized (obj){
                while (!first_flag){
                    obj.wait();
                }
                printBar.run();
                obj.notifyAll();
                second_flag = true;
                first_flag = false;
            }
        }
    }
}
