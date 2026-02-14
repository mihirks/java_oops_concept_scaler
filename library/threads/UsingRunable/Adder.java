package threads.UsingRunable;

public class Adder implements Runnable {
    private int number;
    public Adder(int number) {
        this.number = number;
    }
    @Override
    public void run() {
        System.out.println("Adding " + " "+ this.number + " " + Thread.currentThread().getName());
    }

}
