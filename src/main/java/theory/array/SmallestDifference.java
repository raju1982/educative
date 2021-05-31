package theory.array;

import java.util.Arrays;

public class SmallestDifference {

    public static int[] smallDiff(int[] firstArray, int[] secondArray){
        int[] result = new int[2];
        Arrays.sort(firstArray);
        Arrays.sort(secondArray);

        int diff = Integer.MAX_VALUE;
        int tmpDiff = Integer.MAX_VALUE;
        int i=0, j=0;
        while(i<firstArray.length && j<secondArray.length){
            int tmpOne = firstArray[i];
            int tmpTwo = secondArray[j];
            if(tmpOne == tmpTwo){
                result[0] = tmpOne;
                result[1] = tmpTwo;
                return result;
            }
            else if(tmpOne > tmpTwo){
                tmpDiff = tmpOne-tmpTwo;
                j++;
            }
            else{
                tmpDiff = tmpTwo-tmpOne;
                i++;
            }

            if(diff>tmpDiff){
                diff=tmpDiff;
                result[0] = tmpOne;
                result[1] = tmpTwo;
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[] output = smallDiff(new int[]{-1,5,10,20,28,3}, new int[]{26,134,135,15,17});
        System.out.println(Arrays.toString(output));
    }
}
