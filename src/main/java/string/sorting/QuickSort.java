package string.sorting;

//sort string based on length

public class QuickSort {

    public static void quickSort(String[] input, int low, int high){
        if(low>=high){
            return;
        }
        int pivot = findPivot(input, low, high);
        //left hand side
        quickSort(input,  low, pivot-1);
        //right hand size
        quickSort(input, pivot+1,  high);
    }

    public static int findPivot(String[] input, int low, int high){
        int l=low;
        int h=high;
        String pivot = input[low];

        while(l<h){
            while(input[l].compareTo(pivot) <= 0  && l<h){
                l++;
            }

            while(input[h].compareTo(pivot) > 0){
                h--;
            }

            if(l<h) {
                swap(h, l, input);
            }
        }
        swap(h, low, input);

        return h;
    }

    public static void swap(int i, int j, String[] input){
        String tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }






    private static void printArray( String[] stringArray )
    {
        for (String s:stringArray) {
            System.out.print( s + " " );
        }
    }
    public static void main( String[] args )
    {
        //String[] mySampleStringArray = { "Z", "D", "A", "W", "B", "Y", "C", "X" };
        String[] mySampleStringArray = { "Zing", "Dear", "Dog", "Alice", "Alone", "Water", "Boy", "Yarn", "Chair", "Xray" };
        quickSort( mySampleStringArray,0, mySampleStringArray.length-1);
        printArray(mySampleStringArray);
    }
}
