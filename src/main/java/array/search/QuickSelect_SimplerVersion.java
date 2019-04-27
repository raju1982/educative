package array.search;

public class QuickSelect_SimplerVersion {
    public static int pivot(int[] input, int min, int max){
        int pivot = input[min];
        int l= min;
        int h =max;

        while(l<h){
            while(input[l]<=pivot && l < h){
                l++;
            }

            while(input[h]>pivot){
                h--;
            }

            if(l<h){
                swap(input, l , h);
            }
        }

        swap(input, h,min);

        return h;
    }

    public static void swap(int[] input, int index1, int index2){
        int tmp = input[index1];
        input[index1] = input[index2];
        input[index2] = tmp;
    }

    public static int quicksort(int[] input, int min, int max, int index){

        int pivot = pivot(input, min, max);

        if(pivot == index){
            return input[pivot];
        }
        else if(pivot > index){
            //left
            return quicksort(input, min, pivot-1, index);
        }
        else{
            //right
            return quicksort(input, pivot+1, max, index);
        }
    }

    public static void main(String[] args){
        //int[] data = new int[]{2,4,12,7,3,9,10};
        int[] data = new int[] {5,1,7,12,9,3,23,11,13};
        //kith largest element is equivalent to find (n - k)th smallest element in array.
        System.out.println(quicksort(data, 0, data.length-1,data.length - 3));
    }
}
