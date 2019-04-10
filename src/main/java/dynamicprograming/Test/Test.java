package dynamicprograming.Test;
import java.util.Arrays;

public class Test {

    public static int fibonacci(int input){
        //0,1
        if(input<2){
            return input;
        }

        int f1=0;
        int f2=1;
        int sum = 0;
        int count=2;
        while(count<=input){
            sum = f1 + f2;
            f1=f2;
            f2=sum;
            count++;
        }

        return sum;
    }

    public static int noOfWays(int input){
        //0,1
        if(input<3){
            return 1;
        }
        if(input == 3){
            return 2;
        }
        if(input == 4){
            return 4;
        }

        int[] data = new int[input+1];
        data[1]=1;
        data[2]=1;
        data[3]=2;
        data[4]=4;
        int count = 5;
        int sum = 0;

        while(count <= input){
            data[count] = data[count-1]+data[count-3]+data[count-4];
            count++;
        }

        return data[count-1];
    }

    public static int minJump(int arr[]){

        int []jump = new int[arr.length];
        jump[0] = 0;
        for(int i=1; i < arr.length ; i++){
            jump[i] = Integer.MAX_VALUE-1;
        }

        for(int i=1; i < arr.length; i++){
            for(int j=0; j < i; j++){
                if(arr[j] + j >= i){
                    jump[i] = Math.min(jump[i], jump[j] + 1);
                }
            }
        }

        return jump[jump.length-1];
    }

    public static void main(String[] args){
        /*
        System.out.println(fibonacci(0));
        System.out.println(fibonacci(1));
        System.out.println(fibonacci(2));
        System.out.println(fibonacci(3));
        System.out.println(fibonacci(4));


        System.out.println(noOfWays(4));
        System.out.println(noOfWays(5));
        System.out.println(noOfWays(6));
          */

        int arr[] = {1,3,5,3,2,2,6,1,6,8,9}; //4
        //int r[] = new int[arr.length];
        int result = minJump(arr);
        System.out.println(result);

    }
//0,1,1,2,3,5,8,13
//0,1,2,3,4
}
