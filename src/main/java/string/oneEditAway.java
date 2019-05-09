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

        System.out.println(oneEditDistance2("pale", "pkle"));
        //System.out.println(oneEditDistance2("pkle", "pable"));
        System.out.println(oneEditDistance2("pkle", "pckle"));
    }

}
