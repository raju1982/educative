package string;

public class oneEditAway {

    //better solution
    public static boolean oneEditDistance2(String inputA, String inputB) {

        int lengthA = inputA.length();
        int lengthB = inputB.length();

        if (Math.abs(lengthA - lengthB) > 1) {
            return false;
        }

        int count = 0;

        for(int i=0; i<Math.min(lengthA, lengthB); i++){
            if(inputA.charAt(i) != inputB.charAt(i)){
                count++;
            }
        }

        if (count == 1 && (lengthA - lengthB) == 0) {
            return true;
        }

        if (count == 0 && Math.abs(lengthA - lengthB) == 1) {
            return true;
        }

        return false;

    }


    public static boolean oneEditDistance(String inputA, String inputB) {

        int lengthA = inputA.length();
        int lengthB = inputB.length();

        if (Math.abs(lengthA - lengthB) > 1) {
            return false;
        }

        int[] data = new int[26];
        int i = 0, j = 0;

        for (; i < lengthA && j < lengthB; i++, j++) {
            data[inputA.charAt(i) - 97]++;
            data[inputB.charAt(j) - 97]--;
        }

        if (i < lengthA - 1) {
            data[inputA.charAt(i) - 97]++;
        }

        if (j < lengthB - 1) {
            data[inputB.charAt(j) - 97]--;
        }

        int count = 0;
        for (int k = 0; k < data.length; k++) {
            if (data[k] != 0) {
                count++;
            }
        }

        if (count == 2 && (lengthA - lengthB) == 0) {
            return true;
        }

        if (count == 1 && Math.abs(lengthA - lengthB) == 1) {
            return true;
        }

        return false;

    }

    public static void main(String[] args) {
        String[][] tests = {
                {"a", "b"},
                {"", "d"},
                {"d", "de"},
                {"pale", "pse"},
                {"acdsfdsfadsf", "acdsgdsfadsf"},
                {"acdsfdsfadsf", "acdsfdfadsf"},
                {"acdsfdsfadsf", "acdsfdsfads"},
                {"acdsfdsfadsf", "cdsfdsfadsf"},
                {"adfdsfadsf", "acdfdsfdsf"},
                {"adfdsfadsf", "bdfdsfadsg"},
                {"adfdsfadsf", "affdsfads"},
                {"pale", "pkle"},
                {"pkle", "pable"}};

        System.out.println(oneEditDistance("pale", "pkle"));
        System.out.println(oneEditDistance("pkle", "pable"));
    }

}
