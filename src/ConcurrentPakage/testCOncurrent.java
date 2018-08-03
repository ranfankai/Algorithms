package ConcurrentPakage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by haha on 2018/8/2.
 */

class reentrainetLock{
    private static Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public  void afterLock()
    {
        lock.lock();
        try {
            condition.await();
            System.out.println("after");
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }
    public  void beforeLock()
    {
        lock.lock();
        try {
            //condition.await();
            System.out.println("before");
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }
    public void func()
    {
        lock.lock();
        try {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getId()+" "+i);
                Thread.sleep(500);
            }
            System.out.println(Thread.currentThread().getId()+"end normal");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }
    public synchronized void before() {
        System.out.println("before");
        notifyAll();
    }

    public synchronized void after() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after");
       // notify();
    }
    public synchronized void mid() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("mid");
    }
}
public class testCOncurrent {
    public static void main(String[] args) {
        ExecutorService executorService =Executors.newCachedThreadPool();
        reentrainetLock re1 = new reentrainetLock();
        reentrainetLock re2 = new reentrainetLock();
        executorService.execute(()->re1.afterLock());
        //executorService.execute(()->re1.mid());
        executorService.execute(()->re1.beforeLock());
//        executorService.execute(()->re1.func());
//        executorService.execute(()->re2.func());
        executorService.shutdown();
    }


}
