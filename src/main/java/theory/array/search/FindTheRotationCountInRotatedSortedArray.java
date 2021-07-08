package theory.array.search;

public class FindTheRotationCountInRotatedSortedArray {
    public static int solution(int[] input){
        int min = 0;
        int max = input.length-1;

        if(input[min]<input[max]){
            return 0;
        }

        while(min<=max){
            int mid = min + (max-min)/2;
            int next = (mid+1)%input.length;
            int prev = (mid+input.length-1)%input.length;
            if(input[mid]<input[prev] && input[mid]<input[next]){
                return mid;
            }

            if(input[mid]<input[max]){
                max = prev;
            }
            else{
                min = next;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        int output = solution(new int[]{15, 18, 2, 3, 6, 12});
        System.out.println(output);
    }
}
