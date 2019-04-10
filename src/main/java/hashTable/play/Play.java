package hashTable.play;

import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;

public class Play {

    public static boolean isSubset(int[] input1, int[] input2){

        Set<Integer> data = new HashSet<>();

        if(input1.length > input2.length){
            for(int i=0; i<input1.length; i++){
                data.add(input1[i]);
            }

            for(int i=0; i<input2.length; i++){
                if(!data.contains(input2[i])){
                    return false;
                }
            }

        }
        else{
            for(int i=0; i<input2.length; i++){
                data.add(input2[i]);
            }
            for(int i=0; i<input1.length; i++){
                if(!data.contains(input1[i])){
                    return false;
                }
            }

        }

        return true;

    }

    /*
    Set<Map.Entry<String,Integer>> s = m.entrySet();

        for (Map.Entry<String, Integer> it: s)
     */


    public static void findPath(Map<String, String> input){
        Set<String> to = new HashSet<String>();
        String start = null;
        String end ;
        int count = 1;

        for(Map.Entry<String,String> val : input.entrySet()){
            to.add(val.getValue());
        }

        for(Map.Entry<String,String> val : input.entrySet()){
            if(!to.contains(val.getKey())){
                start = val.getKey();
                break;
            }
        }

        while(count <= to.size()){
            end = input.get(start);
            System.out.println(start + "->" + end);
            start=end;
            count++;
        }
    }


    public static void findParis(int[] input){

        Map<Integer, Integer[]> data = new HashMap<>();

        for(int i=0; i<input.length; i++){
            for(int j=i+1; j<input.length; j++){
                if(data.containsKey(input[i] + input[j])){
                    Integer[] tmp = data.get(input[i] + input[j]);
                    System.out.println(input[i] + "," + input[j] + ":" + tmp[0] + "," + tmp[1]);
                }
                else{
                    data.put((input[i] + input[j]), new Integer[] {input[i], input[j]});
                }
            }
        }
    }



    public static void main(String[] args){
        int[] arr1 = new int[] {9,4,7,1,-2,6,5};
        int[] arr2 = new int[] {7,1,-2};
        System.out.println(isSubset(arr1, arr2));
        System.out.println(isSubset(arr2, arr1));

        int[] arr3 = new int[] {9,4,1,-2,6,5};
        System.out.println(isSubset(arr3, arr2));

        Map<String, String> input = new HashMap<>();
        input.put("A","B");
        input.put("B","C");
        input.put("C","D");

        findPath(input);

        findParis(new int[]{2,6,8,3,1,9,10,4});

    }


}