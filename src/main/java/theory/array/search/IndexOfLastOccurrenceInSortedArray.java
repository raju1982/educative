package theory.array.search;

public class IndexOfLastOccurrenceInSortedArray {

    public static int solution(int[] input, int number){
        int low = 0;
        int high = input.length -1;

        while(low<=high){
            int mid = (low + high)/2;

            if(input[mid]>number){
                high = mid-1;
            }
            else if(input[mid]<number){
                low = mid+1;
            }
            else{
                if(mid == input.length-1 || (input[mid]!=input[mid+1])){
                    return mid;
                }
                else{
                    low = mid+1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] input = {5, 10, 10, 10, 20};
        int x = 10;
        System.out.println(solution(input, x));
    }

}
