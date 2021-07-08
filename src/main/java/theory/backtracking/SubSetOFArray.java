package theory.backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubSetOFArray {
    static List<List<Integer>> result = new ArrayList<>();
    public static void sol(int[] num, int index, List<Integer> osf){
        if(index==num.length){
            result.add(new ArrayList<>(osf));
            return;
        }
        osf.add(num[index]);
        sol(num, index+1, osf);
        osf.remove(osf.size() -1);
        sol(num, index+1, osf);
    }

    public static void main(String[] args){
        sol(new int[]{1,2,3}, 0, new ArrayList<>());
        for(List<Integer> tmp : result){
            System.out.println(tmp);
        }
    }


    //GenerateSubsets of String
    static List<String> subst = new ArrayList<>();
    public static void subsets(String input, int depth, StringBuilder runningString){

        if(input.length() == depth){
            subst.add(runningString.toString());
            return;
        }

        runningString.append(input.charAt(depth));
        subsets(input, depth+1, runningString);
        runningString.setLength(runningString.length()-1);
        subsets(input, depth+1, runningString);
    }
}


/*
[1, 2, 3]
[1, 2]
[1, 3]
[1]
[2, 3]
[2]
[3]
[]
 */