package array;

public class smallestCommonNumberInThreeSortedArray {

    public static int searchCommandLowestPoint(int[] inputOne, int[] inputTwo, int[] inputThree){

        int i=0, j=0, k=0;
        while(i<inputOne.length  && j<inputTwo.length && k<inputThree.length){

            int min = Math.min(Math.min(inputOne[i], inputTwo[j]), inputThree[k]);

            if(min == inputOne[i] && min==inputTwo[j] && min == inputThree[k]){
                return min;
            }

            if(min == inputOne[i]){
                i++;
            }
            if(min == inputTwo[j]){
                j++;
            }
            if(min == inputThree[k]){
                k++;
            }


        }
        return -1;
    }


    public static void main(String[] args){
        System.out.println(searchCommandLowestPoint(new int[] {6,7,10,25,30,63,64}, new int[] {-1,4,5,6,7,8,50}, new int[] {1,6,10,14}));
    }
}
