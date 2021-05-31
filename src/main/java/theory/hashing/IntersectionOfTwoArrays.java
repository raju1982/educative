package theory.hashing;

import java.util.*;

public class IntersectionOfTwoArrays {

    static List<Integer> solution(int[] inputA, int[] inputB){
        List<Integer> result = new ArrayList<>();
        Set<Integer> setA = new HashSet<>();
        for(int i: inputA){
            setA.add(i);
        }
        for(int i: inputB){
            if(setA.contains(i) && !result.contains(i)){
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(solution(new int[]{10,15,20,5,30}, new int[]{30,5,30,80}));
    }
}
