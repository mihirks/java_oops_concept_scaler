package threads.UsingRunable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Adder adder = new Adder(5);
        Thread thread1 = new Thread(adder);
        Thread thread2 = new Thread(adder);
        System.out.println("Adding in main " + Thread.currentThread().getName());
        thread1.start();
        thread2.start();
        thread1.join();
        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.submit(adder);
//        executorService.submit(adder);
        Future future = executorService.submit(adder);
        Future future1 = executorService.submit(adder);

        future.get();
        future1.get();


        executorService.shutdown();
    }
}
