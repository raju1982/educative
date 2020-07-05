package com.ds.algo.array;


import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.assertEquals;

public class MaxElementInAnArray {
    //
    public static int maxElement(int[] input){
        if(Objects.isNull(input) || input.length == 0){
            throw new IllegalArgumentException("invalid input.");
        }
        int max = input[0];

        for(int x:input){
            if(max<x){
                max = x ;
            }
        }

        return max;
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void nullInput(){
        new MaxElementInAnArray().maxElement(null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void emptyInput(){
        new MaxElementInAnArray().maxElement(null);
    }

    @Test
    public void validInput(){
        assertEquals(new MaxElementInAnArray().maxElement(new int[]{5,7,2,6,1,9,3,5,6}), 9 );
    }

    public static void main(String[] args){
        //max element in an array
    }
}

