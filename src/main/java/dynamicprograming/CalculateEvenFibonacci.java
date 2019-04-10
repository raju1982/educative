package dynamicprograming;

public class CalculateEvenFibonacci {
    public int CalculateEvenFibonacci(int n) {
        if (n < 1)
            return n;
        if (n == 1)
            return 2;
        int n1 = 0, n2 = 2, temp;
        for (int i = 2; i <= n; i++) {
            temp = n1 + 4*n2;
            n1 = n2;
            n2 = temp;
        }
        return n2;
    }

    public static void main(String[] args) {
        CalculateEvenFibonacci fib = new CalculateEvenFibonacci();
        System.out.println("7th Fibonacci is ---> " + fib.CalculateEvenFibonacci(7));
    }
}
