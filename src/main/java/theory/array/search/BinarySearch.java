package theory.array.search;

public class BinarySearch {

    public static int search(int[] input, int val, int min, int max){
        if(min>max){
            return -1;
        }

        int midIndex = min + (max - min)/2;

        if(input[midIndex] == val){
            return midIndex;
        }

        if(input[midIndex]>val){
            return search(input, val, min, midIndex-1);
        }
        else{
            return search(input, val, midIndex+1, max);
        }
    }


    public static void main(String[] args){
        int[] input = new int[]{4,6,10,12,15,17,20,25,30,35,40};
        System.out.println(search(input, 17, 0, input.length-1));
        System.out.println(search(input, 18, 0, input.length-1));
    }

}
