package theory.array.move;

import java.util.Arrays;

public class moveZeroToLeft {

    public static void rearrange(int[] input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }

        int readIndex = input.length - 1;
        int writeIndex = input.length - 1;

        while (readIndex >= 0) {
            if (input[readIndex] != 0) {
                swap(readIndex, writeIndex, input);
                writeIndex--;
            }
            readIndex--;
        }
    }

    public static void swap(int i, int j, int[] input) {
        int tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }

    public static void main(String[] args) {
        int[] input = new int[]{5, 0, 2, 0, 0, 3, 7, 9, 12};
        rearrange(input);
        System.out.println(Arrays.toString(input));

        int[] v = new int[]{1, 10, -1, 11, 5, 0, -7, 0, 25, -35};
        rearrange(v);
        System.out.println(Arrays.toString(v));
    }
}
