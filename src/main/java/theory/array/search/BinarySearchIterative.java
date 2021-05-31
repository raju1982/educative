package theory.array.search;

public class BinarySearchIterative {

    public static int search(int[] input, int number){
        int low = 0;
        int high = input.length-1;

        while(low<=high){
            int mid = (low+high)/2;
            if(input[mid] == number){
                return mid;
            }
            if(input[mid]>number){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] input = new int[]{4,6,10,12,15,17,20,25,30,35,40};
        System.out.println(search(input, 17));
        System.out.println(search(input, 37));
    }
}
