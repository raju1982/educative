package array.sort;

import java.util.Arrays;

public class CheckIfArrayCanBeSortedWithOneSwap {

    public static boolean check(int[] input){
        int[] newArray = Arrays.copyOf(input, input.length);
        Arrays.sort(newArray);
        int count = 0;

        for(int i=0; i<input.length; i++){
            if(newArray[i] != input[i]){
                count++;
            }
        }

        if(count>2){
            return false;
        }

        return true;
    }

    public static boolean check2(int arr[]){

        int first=0, second=0, count = 0;

        for(int i=1;i<arr.length; i++){
            if(arr[i] < arr[i-1]){
                count++;
                if(first ==0){
                    first=i;
                }
                else{
                    second=i;
                }
            }
        }


        if(count == 0){
            return true;
        }

        if(count>2){
            return false;
        }

        if(count == 1){
            swap(first, first-1, arr);
        }

        if(count == 2){
            swap(first-1, second, arr);
        }

        for(int i=1;i<arr.length; i++){
            if(arr[i] < arr[i-1]){
                return false;
            }
        }
        return true;
    }

    public static void swap(int i, int j, int[] input){
        int tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }

    public static void main(String[] args){
        System.out.println(check( new int[] {1, 2, 7, 4, 5, 6, 3, 8}));
        System.out.println(check( new int[] {1, 2, 5, 3, 7, 8, 6, 4}));

        System.out.println(check2( new int[] {1, 2, 7, 4, 5, 6, 3, 8}));
        System.out.println(check2( new int[] {1, 2, 5, 3, 7, 8, 6, 4}));
    }

}
