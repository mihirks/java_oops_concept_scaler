package threads.BinaryTreeSize;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.left = new Node(8);
        root.right.left.right = new Node(9);
        root.right.right.right = new Node(10);

        ExecutorService executorService = Executors.newFixedThreadPool(15);

        TreeSizeCalculator sizeCount= new TreeSizeCalculator(root, executorService);


        Future<Integer> f1 = executorService.submit(sizeCount);
        System.out.println(f1.get());

        executorService.shutdown();

    }
}
