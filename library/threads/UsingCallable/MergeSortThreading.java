package threads.UsingCallable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class MergeSortThreading implements Callable<List<Integer>> {
    private List<Integer> list;
    private ExecutorService executorService;
    public MergeSortThreading(List<Integer> list, ExecutorService executorService) {
        this.list = list;
        this.executorService = executorService;
    }
    @Override
    public List<Integer> call() throws Exception {
        if(list.size() < 2){
            return list;
        }
        System.out.println("in " + Thread.currentThread().getName());
        int n = list.size();
        int mid = n/2;
        List<Integer> leftlist = list.subList(0,mid);
        List<Integer> rightlist = list.subList(mid,n);
        MergeSortThreading mergeLeft = new MergeSortThreading(leftlist,executorService);
        MergeSortThreading mergeRight = new MergeSortThreading(rightlist,executorService);
        Future<List<Integer>> futureLeft = executorService.submit(mergeLeft);
        Future<List<Integer>> futureRight = executorService.submit(mergeRight);
        List<Integer> leftSorted = futureLeft.get();
        List<Integer> rightSorted = futureRight.get();

        return mergeSortedArrays(leftSorted,rightSorted);
//        return list;
    }

    public List<Integer> mergeSortedArrays(List<Integer> leftSorted, List<Integer> rightSorted) {
        List<Integer> newList = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < leftSorted.size() && j < rightSorted.size()) {
            if (leftSorted.get(i) < rightSorted.get(j)) {
                newList.add(leftSorted.get(i++));
            }
            else {
                newList.add(rightSorted.get(j++));
            }
        }
        while (i < leftSorted.size()) {
            newList.add(leftSorted.get(i++));
        }
        while (j < rightSorted.size()) {
            newList.add(rightSorted.get(j++));
        }
        return newList;
    }

}
