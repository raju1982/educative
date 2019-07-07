package hashTable;

import java.util.Set;
import java.util.HashSet;

public class ArrayIsASubsetOfAnotherArray {

    static boolean find(int[] arr1, int[] array2){
        Set<Integer> set = new HashSet<Integer>();
        if(arr1.length > array2.length){
            for(int i=0; i<arr1.length; i++) {
                set.add(arr1[i]);
            }

            for(int i=0; i<array2.length; i++) {
                if(!set.contains(array2[i])){
                    return false;
                }
            }
        }
        else{
            for(int i=0; i<array2.length; i++) {
                set.add(array2[i]);
            }

            for(int i=0; i<arr1.length; i++) {
                if(!set.contains(arr1[i])){
                    return false;
                }
            }
        }

        return true;
    }


    public static void main(String[] args){
        int[] arr1 = new int[] {9,4,7,1,-2,6,5};
        int[] arr2 = new int[] {7,1,1,-2};
        System.out.println(find(arr1, arr2));
        System.out.println(find(arr2, arr1));

        int[] arr3 = new int[] {9,4,1,-2,6,5};
        //System.out.println(find(arr3, arr2));

    }
}
