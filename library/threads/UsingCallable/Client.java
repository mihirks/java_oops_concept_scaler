package threads.UsingCallable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Subtractor subtractor = new Subtractor(5,4);
        ArrayCreator arrayCreator = new ArrayCreator(10000000);
        System.out.println("in " + Thread.currentThread().getName());
        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.submit(makeArray);
//        executorService.submit(subtractor);
        Future<List<Integer>> future = executorService.submit(arrayCreator);
        Future<Integer> future1 = executorService.submit(subtractor);
        int ans=future1.get();
        System.out.println(ans);
        List<Integer> list = future.get();
//        System.out.println(list);

//        executorService.submit(adder);
        List<Integer> numbers = Arrays.asList(324,34,434,23,12,4,54,65,76);
        MergeSortThreading arraySortor =new MergeSortThreading(numbers,executorService);
        Future<List<Integer>> future2 = executorService.submit(arraySortor);
        List<Integer> list2 = future2.get();
        System.out.println(list2);

        executorService.shutdown();
    }
}

