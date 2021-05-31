package theory.array;

public class SubarrayWithGivenSum {

    public static boolean sol(int[] input, int sum){

        int initialSum = input[0];
        int start = 0;

        for(int end=1; end<=input.length; end++){
            while(initialSum>sum && start<end-1){
                initialSum = initialSum - input[start];
                start++;
            }

            if(initialSum == sum){
                System.out.println("start: " + start + " end: " + end);
                return true;
            }

            if(end<input.length) {
                initialSum = initialSum + input[end];
            }
        }
        return false;
    }


    public static void main(String[] args){
        System.out.println(sol(new int[]{1,4,20,3,10,5}, 33));
    }
}
