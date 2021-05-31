package theory.recursion;

import java.util.Collections;
import java.util.PriorityQueue;

public class RopeCuttingProblem {

    //solution 1
    static PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
    public static void sol(int ropeLength, int[] sizes, int count){
        if(ropeLength==0){
            heap.add(count);
            return;
        }

        for(int i=0; i<sizes.length; i++){
            if(ropeLength>=sizes[i]){
                sol(ropeLength-sizes[i], sizes, count+1);
            }
        }
    }




    //solution 2
    public static int solution(int totalLength, int len1, int len2, int len3){

        if(totalLength == 0){
            return 0;
        }

        if(totalLength < 0){
            return -1;
        }

        int res = Math.max( Math.max( solution(totalLength-len1, len1, len2, len3) , solution(totalLength-len2, len1, len2, len3) ) ,
                solution(totalLength-len3, len1, len2, len3) );

        if(res == -1){
            return -1;
        }

        return res + 1;
    }

    public static void main(String[] args){
        System.out.println(solution(5,2,5,1));
        System.out.println(solution(23,12,9,11));
        System.out.println(solution(5,4,2,6));
    }
}
