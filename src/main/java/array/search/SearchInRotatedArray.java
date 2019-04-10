package array.search;

public class SearchInRotatedArray {

    public static int findIndex(int[] input, int searchElement){
        //null check -> throw new IllegalArgumentException();

        int index=0;
        for(int i=0; i<input.length; i++){
            if(input[i]>input[i+1]){
                index=i;
                break;
            }
        }

        if(searchElement>input[0]){
            return binarySearch(input, searchElement, 0, index);
        }
        else{
            return binarySearch(input, searchElement, index+1, input.length-1);
        }
    }


    public static int binarySearch(int[] input, int searchElement, int min, int max){
        if(min>max){
            return -1;
        }

        int mid = min + (max-min)/2;

        if(searchElement == input[mid]){
            return mid;
        }
        else if(searchElement < input[mid]){
            return binarySearch(input, searchElement, min, mid-1);
        }
        else{
            return binarySearch(input, searchElement, mid+1, max);
        }
    }

    public static void main(String[] args){
        int[] input = new int[] {12,15,18,2,4,6,8,10};
        System.out.println(findIndex(input, 6));
        System.out.println(findIndex(input, 16));
    }

}
