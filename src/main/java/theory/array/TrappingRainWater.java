package theory.array;

public class TrappingRainWater {

    public static int solution(int[] input){
        int result  = 0;
        int size = input.length;
        int[] leftMax = new int[size];
        int[] rightMax = new int[size];

        leftMax[0] = input[0];
        for(int i=1; i<size; i++){
            leftMax[i] = Math.max(input[i], leftMax[i-1]);
        }

        rightMax[size-1] = input[size-1];
        for(int i=size-2; i>=0; i--){
            rightMax[i] = Math.max(input[i], rightMax[i+1]);
        }

        for(int i=1; i<size-1; i++){
            result = result + (Math.min(leftMax[i], rightMax[i]) - input[i]);
        }

        return result;
    }

    public static void main(String[] args){
        System.out.println(solution(new int[] {3,0,1,2,5}));
    }

}
