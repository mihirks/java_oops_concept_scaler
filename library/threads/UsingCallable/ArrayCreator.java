package threads.UsingCallable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class ArrayCreator implements Callable<List<Integer>> {
    private int n;

    public  ArrayCreator(int n) {
        this.n=n;
    }
    @Override
    public List<Integer> call() throws Exception {
        System.out.println("in " + Thread.currentThread().getName());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <=n; i++) {
            list.add(i);
        }
        return list;
    }
}
