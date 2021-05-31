package theory.array;

public class IsMonotonic {

    public static boolean isMonotonic(int[] input) {

        if (input.length < 3) {
            return true;
        }

        int order = input[0] - input[1];

        for (int i = 1; i < input.length - 1; i++) {

            if (order == 0) {
                order = input[i] - input[i + 1];
                continue;
            }

            int tmpOrder = input[i] - input[i + 1];

            if (order > 0 && tmpOrder < 0) {
                return false;
            }

            if (order < 0 && tmpOrder > 0) {
                return false;
            }

        }

        return true;
    }


    public static void main(String[] args) {
        int[] input = new int[]{-1, -5, -10, -1100};
        System.out.println(isMonotonic(input));

        input = new int[]{-1, -15, -10, -1100};
        System.out.println(isMonotonic(input));

        input = new int[]{1, 5, 10, 1100};
        System.out.println(isMonotonic(input));

        input = new int[]{1, 15, 10, 1100};
        System.out.println(isMonotonic(input));
    }

}
