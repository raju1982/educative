package hashTable;

import java.util.Map;
import java.util.HashMap;

public class FindTwoPairsInArray {

    static void find(int[] arr){
        Map<Integer, int[]> data = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                if(data.containsKey(arr[i] + arr[j])){
                    System.out.println(arr[i] + " , " + arr[j]);
                    int[] result = data.get(arr[i] + arr[j]);
                    for(int u:result){
                        System.out.print(u + " , ");
                    }
                    System.out.println();
                }
                else{
                    data.put((arr[i] + arr[j]), new int[] {arr[i], arr[j]});
                }

            }
        }
    }

    public static void main(String[] args){
        int[] arr = {3, 4, 7, 1, 12, 9};
        find(arr);
    }
}
