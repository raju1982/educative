package com.ds.algo.array;

import java.util.Arrays;

public class Tmp {

    public static int solution (int input, int a, int b, int c){

        if(input==0){
            return 0;
        }
        else if(input<0){
            return -1;
        }

        return 1 + Math.max(Math.max(solution(input-a,a,b,c), solution(input-b,a,b,c)),solution(input-c,a,b,c));
    }

    public static void main(String[] args){
        int input = 25;
        int a = 11, b = 12, c = 13;
        System.out.println(solution (input, a, b, c));
    }

}



