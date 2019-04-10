package array.search;

public class SearchMissingNumberInArithmeticProgression {

    public static int search(int[] input, int min, int max, int diff){
        if(min>=max){
            return -1;
        }

        int mid = min + (max-min)/2;

        if(input[mid+1]-input[mid] != diff){
            return input[mid] + diff;
        }

        if(mid>0 && input[mid]-input[mid-1] != diff){
            return input[mid-1] + diff;
        }

        if(input[mid] == input[0] + mid*diff){
            return search(input, mid+1, max, diff);
        }
        else{
            return search(input, 0, mid-1, diff);
        }

    }


    public static void main(String[] args){
        int[] input = new int[]{2,4,6,10,12,14,16,18,20};
        int diff = (input[input.length-1]-input[0])/input.length;
        System.out.println(search(input, 0, input.length-1, diff));
    }



}
