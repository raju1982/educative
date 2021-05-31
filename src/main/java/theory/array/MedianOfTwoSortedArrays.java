package theory.array;

public class MedianOfTwoSortedArrays {

    public static void sol(int[] input, int[] arr){
        int i=(input.length+arr.length)/2, j=-1;
        if((input.length+arr.length)%2 == 0){
            j= i-1;
        }
        System.out.println(i + " " + j);
        int p=0, q=0, r=0;
        int[] tmpArray = new int[input.length+arr.length];

        while(p<input.length || q<arr.length){

            if(r>i && r>j){
                break;
            }

            if(input[p] <= arr[q]){
                tmpArray[r++] = input[p];
                p++;
            }
            else{
                tmpArray[r++] = arr[q];
                q++;
            }

            if(r-1==i){
                System.out.println(tmpArray[r-1]);
            }

            if(j!=-1 && r-1==j){
                System.out.println(tmpArray[r-1]);
            }
        }
    }

    public static void main(String[] args){
        int[] input = {10,20,30,40,50};
        int[] arr = {5,15,25,35,45};
        sol(input, arr);
    }

}
