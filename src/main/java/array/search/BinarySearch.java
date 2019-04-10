package array.search;

//O(logn)
//O(logn)
public class BinarySearch {

    public static int search(int num, int[] data, int min, int max){
        int mid = min + (max-min)/2;
        if(min > max){
            return -1;
        }

        if(data[mid] == num){
            return mid;
        }

        if(data[mid] > num){
            return search(num, data, min,mid-1);
        }
        else{
            return search(num, data,mid+1, max);
        }
    }

    public static void main(String[] args){
        System.out.println(search(5, new int[] {1,3,5,8,9,10,15,20,22,25},0, 9));
        System.out.println(search(11, new int[] {1,3,5,8,9,10,15,20,22,25},0, 9));
    }

}
