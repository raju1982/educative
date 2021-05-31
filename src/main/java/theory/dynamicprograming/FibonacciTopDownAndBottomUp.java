package theory.dynamicprograming;
import java.util.*;

public class FibonacciTopDownAndBottomUp {
    //Top down
    static int[] data;
    public static int sol(int n){

        if(data == null){
            data = new int[n];
            Arrays.fill(data, -1);
        }

        if(n<2){
            return n;
        }

        if(data[n-1] == -1){
            data[n-1] = sol(n-1);
        }

        if(data[n-2] == -1){
            data[n-2] = sol(n-2);;
        }

        return data[n-1] + data[n-2];
    }



    //bottom up

    public static int sol2(int n){
        if(n<2){
            return n;
        }
        int x=0, y=1, count = 2;
        int result=0;
        while(count<=n){
            result = x+y;
            x=y;
            y=result;
            count++;
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(sol(10));

        System.out.println(sol2(10));
    }
}
