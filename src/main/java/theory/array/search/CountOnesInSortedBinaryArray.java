package theory.array.search;

public class CountOnesInSortedBinaryArray {

    public static int solution(int[] input, int number){
        int first = IndexOfFirstOccurrenceInSortedArray.solution(input, number);
        if(first == -1){
            return 0;
        }
        return input.length - first;
    }

    public static void main(String[] args){
        System.out.println(solution(new int[] {0,0,1,1,1}, 1));
        System.out.println(solution(new int[] {1,1,1,1,1}, 1));
    }
}
