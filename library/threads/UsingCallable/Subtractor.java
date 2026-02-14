package threads.UsingCallable;

import java.util.concurrent.Callable;

public class Subtractor implements Callable<Integer> {
    private final int a;
    private final int b;

    public Subtractor(int a, int b) {
        this.a = a;
        this.b = b;
    }
    @Override
    public Integer call() throws Exception {
        System.out.println("in " + Thread.currentThread().getName());
        return a-b;
    }
}
