package theory.array;

public class FindCountOfMaximumConsecutive1sInBinaryArray {

    public static int solution(int[] input){
        int oldCount = 0;
        int runningCount = 0;
        for(int i=0; i<input.length; i++){
            if(input[i]==1){
                runningCount++;
            }
            else{
                oldCount = Math.max(runningCount, oldCount);
                runningCount = 0;
            }
        }
        return Math.max(runningCount, oldCount);
    }

    public static void main(String[] args){
        System.out.println(solution(new int[]{1,0,1,1,1,1,0,1,1}));
    }
}
