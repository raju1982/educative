package theory.array.search;

public class SearchInInfiniteSizedArray {

    public static int binarySearch(int[] input, int number, int low, int high) {

        while (low <= high) {
            int mid = (low + high) / 2;

            if (input[mid] == number) {
                return mid;
            }

            if (input[mid] > number) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static int solution(int[] input, int number) {
        if (input[0] == number) {
            return 0;
        }

        int i = 1;

        while (input[i] < number) {
            i = i * 2;
        }

        return binarySearch(input, number, i / 2 + 1, i);
    }

    public static void main(String[] args) {
        int[] input = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
        System.out.println(solution(input, 10));
    }


}
