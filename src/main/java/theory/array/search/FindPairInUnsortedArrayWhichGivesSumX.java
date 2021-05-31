package theory.array.search;

import java.util.HashSet;
import java.util.Set;

public class FindPairInUnsortedArrayWhichGivesSumX {
    public static boolean sol(int[] input, int sum){
        Set<Integer> data = new HashSet<>();

        for(int i=0; i<input.length; i++){
            if(data.contains(input[i])){
                System.out.println(input[i] + "\t" + (sum-input[i]));
                return true;
            }
            else{
                data.add(sum-input[i]);
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[] input = {3,5,9,2,8,1,11};
        System.out.println(sol(input, 17));

        int[] input1 = {8,4,6};
        System.out.println(sol(input1, 11));
    }
}
