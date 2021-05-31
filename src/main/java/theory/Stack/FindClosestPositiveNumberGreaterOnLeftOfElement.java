package theory.Stack;

import java.util.Arrays;
import java.util.Stack;

public class FindClosestPositiveNumberGreaterOnLeftOfElement {
    public static int[] solution(int[] input){
        int[] result = new int[input.length];
        result[0] = -1;
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        stack.add(0);

        for(int i=1; i<input.length; i++){
            while(!stack.isEmpty()){
                if(input[stack.peek()]>input[i]){
                    result[i] = input[stack.peek()];
                    break;
                }
                else{
                    stack.pop();
                }
            }
            stack.add(i);
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(solution(new int[] {15,10,18,12,4,6,2,8})));
    }
}
