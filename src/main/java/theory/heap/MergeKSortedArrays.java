package theory.heap;

import java.util.*;

public class MergeKSortedArrays {

    static class Triplet{
        int value, arrayPositionInArrayList, positionInArray;

        public Triplet(int value, int arrayPositionInArrayList, int positionInArray){
            this.value = value;
            this.arrayPositionInArrayList = arrayPositionInArrayList;
            this.positionInArray = positionInArray;
        }

    }


    static List<Integer> mergeArr(List<List<Integer>> input){
        List<Integer> result=new ArrayList<>();
        PriorityQueue<Triplet> queue = new PriorityQueue<>((a1, a2) -> a1.value-a2.value);

        for(int i=0; i<input.size(); i++){
            queue.add(new Triplet(input.get(i).get(0), i, 0));
        }

        while(!queue.isEmpty()){
            Triplet tmp = queue.poll();
            result.add(tmp.value);
            int newPosition = tmp.positionInArray+1;
            if(newPosition<input.get(tmp.arrayPositionInArrayList).size()){
                queue.add(new Triplet(input.get(tmp.arrayPositionInArrayList).get(newPosition), tmp.arrayPositionInArrayList, newPosition));
            }
        }

        return result;
    }

    public static void main(String[] args){
        List<List<Integer>> arr=new ArrayList<>();

        List<Integer> a1 = new ArrayList<>();
        a1.add(10);
        a1.add(20);
        a1.add(30);
        arr.add(a1);

        List<Integer> a2 = new ArrayList<>();
        a2.add(5);
        a2.add(15);
        arr.add(a2);

        List<Integer> a3 = new ArrayList<>();
        a3.add(1);
        a3.add(9);
        a3.add(11);
        a3.add(18);
        arr.add(a3);

        System.out.println(Arrays.toString(mergeArr(arr).toArray()));
    }
}
