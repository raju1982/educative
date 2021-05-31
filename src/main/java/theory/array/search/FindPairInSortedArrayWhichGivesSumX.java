package theory.array.search;

public class FindPairInSortedArrayWhichGivesSumX {
    public static boolean sol(int[] input, int sum){
        if(input==null){
            throw new IllegalArgumentException("invalid input array");
        }

        if(sum<=input[0]){
            return false;
        }

        int low = 0;
        int high = input.length-1;

        while(low<=high){
            int tmpSum = input[low]+input[high];
            if(sum==tmpSum){
                System.out.println(input[low] + "\t" + input[high]);
                return true;
            }
            else if(tmpSum>sum){
                high--;
            }
            else{
                low++;
            }
        }

        return false;
    }

    public static void main(String[] args){
        int[] input = {1,2,3,5,8,9,11};
        System.out.println(sol(input, 11));

    }
}
