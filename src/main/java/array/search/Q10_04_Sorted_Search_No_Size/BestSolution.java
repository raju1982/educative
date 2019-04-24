package array.search.Q10_04_Sorted_Search_No_Size;

public class BestSolution {

    public static int search(int[] input, int searchParam, int start, int end){
        int mid, middleNum;
        while (start <= end) {
            mid = start + (end-start)/2;
            if(mid >= input.length) {
                middleNum = -1;
            }
            else{
                middleNum = input[mid];
            }

            if(middleNum>searchParam || middleNum==-1){
                end = mid-1;
            }
            else if(middleNum<searchParam) {
                start = mid+1;
            }
            else{
                return mid;
            }
        }

        return -1;
    }


    public static int search(int[] input, int searchParam){
        int index=1;
        while(index < input.length && input[index] < searchParam){
            index = index*2;
        }
        return search(input, searchParam, index/2, index);
    }

    public static void main(String[] args){
        int[] array = {1, 2, 4, 5, 6, 7, 9, 10, 11, 12, 13, 14, 16, 18};
        for(int i : array){
            System.out.println(search(array, i));
        }
    }
}
