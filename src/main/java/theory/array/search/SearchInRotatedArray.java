package theory.array.search;

public class SearchInRotatedArray {

    //O(log n) good solution
    public static int modifiedBinarySearch(int[] input, int number){
        int low = 0;
        int high = input.length-1;

        while(low<=high){
            int mid = (low+high)/2;
            if(input[mid] == number){
                return mid;
            }

            if(input[low] < input[mid]){
                if(number>=input[low] && number<input[mid]){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
            else{
                if(number>input[mid] && number<=input[high]){
                    low = mid + 1;
                }
                else{
                    high = mid -1;
                }
            }
        }

        return -1;
    }









    //O(n) - bad solution
    public static int binarySearch(int[] input, int number, int low, int high){
        while(low<=high){
            int mid = (low+high)/2;

            if(input[mid] == number){
                return mid;
            }

            if(input[mid] > number){
                high = mid - 1 ;
            }
            else{
                low = mid + 1;
            }
        }
        return -1;
    }


    public static int sol(int[] input, int number){
        int lastElementIndex = -1;
        for(int i=0; i<input.length; i++){
            if(input[i]> input[i+1]){
                lastElementIndex = i;
                break;
            }
        }

        int index = binarySearch(input, number, 0, lastElementIndex);
        if(index != -1){
            return index;
        }
        else{
            return binarySearch(input, number, lastElementIndex+1, input.length);
        }
    }


    public static void main(String[] args){
        int[] input = {10,20,30,40,50,8,9};
        System.out.println(sol(input, 10));
        System.out.println(sol(input, 40));
        System.out.println(sol(input, 9));

        System.out.println(modifiedBinarySearch(input, 10));
        System.out.println(modifiedBinarySearch(input, 40));
        System.out.println(modifiedBinarySearch(input, 9));
    }
}
