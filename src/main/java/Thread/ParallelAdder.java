package Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class CallableAdder implements Callable<Integer> {
    Integer operand1;
    Integer operand2;

    CallableAdder(Integer operand1, Integer operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " says : partial Sum for " + operand1 + " and " + operand2 + " is " + (operand1 + operand2));
        return operand1 + operand2;
    }
}


public class ParallelAdder {
    public Integer parallelSum() {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Future<Integer>> list = new ArrayList<>();
        int count = 1;
        int prev = 0;
        for (int i = 1; i <= 10; i++) {
            System.out.println("Prev :" + prev + " current: " + i);
            Future<Integer> future = executor.submit(new CallableAdder(prev, i));
            list.add(future);
            prev = i;
            count++;
        }
        int totsum = 0;
        for (Future<Integer> fut : list) {
            try {
                totsum = totsum + fut.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Total Sum is " + totsum);
        return totsum;
    }

    public static void main(String[] args) {
        ParallelAdder adder = new ParallelAdder();
        int pSum = adder.parallelSum();
        System.out.println("parallel Sum equals to Sequential Sum = " + pSum);
    }
}