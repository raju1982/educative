package theory.array.search;

public class CountOccurrencesInArray {

    public static int solution(int[] input, int number){
        int first = IndexOfLastOccurrenceInSortedArray.solution(input, number);
        if(first == -1){
            return 0;
        }
        int second = IndexOfFirstOccurrenceInSortedArray.solution(input, number);
        System.out.println(first + "\t" + second);
        return first - second + 1;
    }

    public static void main(String[] args){
        int arr[] = {1, 2, 2, 3, 3, 3, 3};
        System.out.println(solution(arr, 3));
    }
}
