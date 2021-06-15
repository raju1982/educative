package theory.dynamicprograming;

public class Fibonacci {

    public static int sol(int num){
        int[] fib = new int[num+1];
        fib[0] = 0;
        fib[1] = 1;

        for(int i=2; i<=num; i++){
            fib[i] = fib[i-1] + fib[i-2];
        }

        return fib[num];
    }

    public static void main(String[] args){
        System.out.println();
    }

}
