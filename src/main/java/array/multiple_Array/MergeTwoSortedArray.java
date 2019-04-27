package array.multiple_Array;

class MergeTwoSortedArray {
    public static void main(String args[]) {
        int[] inputA = new int[]{1, 3, 4, 5};
        int[] inputB = new int[]{2, 6, 7, 8};
        int[] sol = mergeSortedArray(inputA, inputB);
        for (int i = 0; i < sol.length; i++) {
            System.out.println(sol[i]);
        }
    }

    //merge two sorted array
    public static int[] mergeSortedArray(int[] inputA, int[] inputB) {
        int sol[] = new int[inputA.length + inputB.length];
        int aIndex = 0;
        int bIndex = 0;
        int solIndex = 0;

        while (aIndex < inputA.length && bIndex < inputB.length) {
            if (inputA[aIndex] < inputB[bIndex]) {
                sol[solIndex++] = inputA[aIndex++];
            } else {
                sol[solIndex++] = inputB[bIndex++];
            }
        }

        while (aIndex < inputA.length) {
            sol[solIndex++] = inputA[aIndex++];
        }

        while (bIndex < inputB.length) {
            sol[solIndex++] = inputB[bIndex++];
        }
        return sol;
    }

}
