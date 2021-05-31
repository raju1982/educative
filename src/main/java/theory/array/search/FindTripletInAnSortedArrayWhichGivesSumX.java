package theory.array.search;

public class FindTripletInAnSortedArrayWhichGivesSumX {

    public static boolean sol(int[] input, int sum, int low, int high){
        if(input==null){
            throw new IllegalArgumentException();
        }

        if(sum<=input[0]){
            return false;
        }

        while(low<=high){
            int tmpSum = input[low]+input[high];
            if(sum==tmpSum){
                System.out.print(input[low] + "\t" + input[high]);
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

    public static boolean findNumbers(int[] input, int sum){
        for(int i=0; i<input.length; i++){
            if(sol(input, sum-input[i], i+1, input.length-1)){
                System.out.println(" " + input[i]);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[] input = {1,2,3,6,8,9,11};
        System.out.println(findNumbers(input, 13));
    }
}
