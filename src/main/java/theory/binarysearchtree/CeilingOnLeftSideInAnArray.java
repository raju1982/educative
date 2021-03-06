package theory.binarysearchtree;

import java.util.TreeSet;

public class CeilingOnLeftSideInAnArray {
    public static void main(String args[]) {
        int arr[] = {2, 8, 30, 15, 25, 12};
        int n = arr.length;

        printCeiling(arr, n);
    }

    //time complexity -> O(nlogn)
    public static void printCeiling(int arr[], int n) {
        System.out.print("-1" + " ");
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(arr[0]);
        for (int i = 1; i < n; i++) {
            //O(logn)
            Integer tmp = treeSet.ceiling(arr[i]);
            if (tmp != null)
                System.out.print(tmp + " ");
            else
                System.out.print("-1" + " ");
            //O(logn)
            treeSet.add(arr[i]);
        }
    }
}
