package ConcurrentPakage;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.zip.Inflater;

/**
 * Created by haha on 2018/8/2.
 */
public class CountdownLatchExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        final int totalThread = 10;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(totalThread);   //
        CountDownLatch countDownLatch = new CountDownLatch(totalThread);
        Semaphore semaphore = new Semaphore(3);
        //CountDownLatch countDownLatch2 = new CountDownLatch(totalThread);
        ExecutorService executorService = Executors.newFixedThreadPool(10);

//        for (int i = 0; i < totalThread; i++) {
//            executorService.execute(() -> {
//                countDownLatch.countDown();
//                System.out.println(Thread.currentThread().getId()+ " "+ System.nanoTime());
//            });
//        }

//        for (int i = 0; i < totalThread; i++) {
//            executorService.execute(() -> {
//                try {
//                    cyclicBarrier.await();
//                } catch (BrokenBarrierException | InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getId()+ " "+ System.nanoTime());
//            });
//        }

        for (int i = 0; i < totalThread; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getId()+ " get Semaphore "+ semaphore.availablePermits());
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    finally {
                        semaphore.release();
                    }
                }
            });
        }
        //countDownLatch.await();
        System.out.println("end");
        executorService.shutdown();
//        executorService.execute(() ->
//            System.out.println("i ma back")
//        );

    }
}
