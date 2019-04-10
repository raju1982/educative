package dynamicprograming.group1;

public class StairCase {

    public static int calculate(int n){
        //(n-1) + (n-2) + (n-3)
        if(n<2){
            return 1;
        }
        if(n==2){
            return 2;
        }
        if(n==3){
            return 4;
        }
        int N0=1, N1=2,N2=4;

        for(int i=4; i<=n; i++){
            int tmp = N0+ N1+N2;
            N0=N1;
            N1=N2;
            N2 = tmp;
        }
        return N2;
    }

    public static void main(String[] str){
        System.out.println(calculate(4));
    }
}

/*
f (n < 2) return 1;
    if (n == 2) return 2
 */

//At every step, we have three options: either jump 1 step, 2 steps, or 3 steps.
//https://www.youtube.com/watch?v=CFQk7OQO_xM
