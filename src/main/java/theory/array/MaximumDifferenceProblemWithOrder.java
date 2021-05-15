package theory.array;

public class MaximumDifferenceProblemWithOrder {
    public static int sol(int[] input){
        int minVal = input[0];
        int maxDiff = input[1]-minVal;

        for(int i=1; i<input.length-1; i++){
            maxDiff =  Math.max(maxDiff, (input[i]-minVal) );
            minVal = Math.min(minVal, input[i]);
        }
        return maxDiff;
    }

    public static void main(String[] args){
        System.out.println(sol(new int[] {2,3,10,6,4,8,1}));
    }
}
