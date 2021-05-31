package theory.array;

public class MaximumSumOfKConsecutiveElements {
    public static int sol(int[] input, int count){
        int result = 0;
        for(int i=0; i<count; i++){
            result = result + input[i];
        }
        int runningResult = result;
        for(int i=1; i<input.length-count+1; i++){
            runningResult = runningResult-input[i-1]+input[i+count-1];
            result = Math.max(runningResult, result);
        }

        return result;
    }

    public static void main(String[] args){
        System.out.println(sol(new int[]{1,8,30,-5,20,7}, 3));
    }
}
