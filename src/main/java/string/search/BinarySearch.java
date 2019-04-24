package string.search;

public class BinarySearch {
    public static int binarySearch(String[] input, int start, int end, String searchParam){
        if(start>end){
            return -1;
        }

        int mid = start + (end-start)/2;

        int tmp = input[mid].compareTo(searchParam);

        if(tmp == 0){
            return mid;
        }
        else if(tmp>0){
            return binarySearch(input, start, mid-1, searchParam);
        }
        else{
            return binarySearch(input, mid+1, end, searchParam);
        }
    }


    public static void main(String[] args){
        String[] input = new String[]{"at", "ball", "car", "dad", "eight" , "high"};
        System.out.println(binarySearch(input, 0, input.length-1, "eight"));
        System.out.println(binarySearch(input, 0, input.length-1, "dime"));
    }
}
