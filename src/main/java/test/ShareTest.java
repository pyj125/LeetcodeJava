package test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ShareTest {
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();

    public void print5(){
        try{
            lock.lock();
            while (number!=1){
                conditionA.await();
            }
            for(int i=0;i<5;i++){
                System.out.print("A");
            }
            System.out.println();
            number++;
            conditionB.signal();

        }catch (Exception e){

        } finally {
            lock.unlock();
        }
    }

    public void print10(){
        try{
            lock.lock();
            while (number!=2){
                conditionB.await();
            }
            for(int i=0;i<5;i++){
                System.out.print("B");
            }
            System.out.println();
            number++;
            conditionC.signal();

        }catch (Exception e){

        } finally {
            lock.unlock();
        }
    }

    public void print15(){
        try{
            lock.lock();
            while (number!=3){
                conditionC.await();
            }
            for(int i=0;i<5;i++){
                System.out.print("C");
            }
            System.out.println();
            number=1;
            conditionA.signal();

        }catch (Exception e){

        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ShareTest shareTest = new ShareTest();
        new Thread(()->{
            for(int i=1;i<10;i++){
                shareTest.print5();
            }
        },"A").start();
        new Thread(()->{
            for(int i=1;i<10;i++){
                shareTest.print10();
            }
        },"B").start();
        new Thread(()->{
            for(int i=1;i<10;i++){
                shareTest.print15();
            }
        },"C").start();
    }

}
