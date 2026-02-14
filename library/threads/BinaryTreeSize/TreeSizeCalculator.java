package threads.BinaryTreeSize;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class TreeSizeCalculator implements Callable<Integer> {

    public Node root;
    public ExecutorService executorService;
    TreeSizeCalculator(Node root, ExecutorService threadPool) {
        this.root = root;
        this.executorService = threadPool;
    }

    @Override
    public Integer call() throws Exception {
        if(root == null){
            return 0;
        }
        TreeSizeCalculator treeSizeCalculatorLeft = new TreeSizeCalculator(root.left,executorService);
        TreeSizeCalculator treeSizeCalculatorRight = new TreeSizeCalculator(root.right,executorService);

        Future<Integer> futureLeft = executorService.submit(treeSizeCalculatorLeft);
        Future<Integer> futureRight = executorService.submit(treeSizeCalculatorRight);

        int leftCount = futureLeft.get();
        int rightCount = futureRight.get();

        return leftCount+rightCount +1 ;
//        return 0;
    }
}
