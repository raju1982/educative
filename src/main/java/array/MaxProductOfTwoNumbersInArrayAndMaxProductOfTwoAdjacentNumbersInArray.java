package array;

public class MaxProductOfTwoNumbersInArrayAndMaxProductOfTwoAdjacentNumbersInArray {
    public static int MaxProductOfTwoAdjacentNumbersInArray(int[] input){
        //null ->
        //length < 2
        int max = input[0]*input[1];
        for(int i=0; i<input.length-1; i++){
            int tmp = input[i]*input[i+1];
            if(max<tmp){
                max=tmp;
            }
        }
       return max;
    }

    public static int MaxProductOfTwoNumbersInArray(int[] input){
        //null ->
        //length < 2

        int max1 = input[0];
        int max2 = input[1];

        for(int i=2; i<input.length; i++){
            if(input[i]>max1){
                max2=max1;
                max1=input[i];
            }
            else if(input[i]>max2){
                max2=input[i];
            }
        }

        return max1*max2;
    }

    public static void main(String[] args){
        System.out.println(MaxProductOfTwoAdjacentNumbersInArray(new int[] {8,1,4,7,10,1,15}));
        System.out.println(MaxProductOfTwoNumbersInArray(new int[] {8,1,4,7,10,1,15}));
    }
}
