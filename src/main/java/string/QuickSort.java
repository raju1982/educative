package string;

//sort string based on length

public class QuickSort {

    public static int partition(String[] stringArray, int idx1, int idx2) {
        String pivotValue = stringArray[idx1];
        while (idx1 < idx2) {
            String value1;
            String value2;
            while ((value1 = stringArray[idx1]).compareTo( pivotValue ) < 0) {
                idx1 = idx1 + 1;
            }
            while ((value2 = stringArray[idx2]).compareTo( pivotValue ) > 0) {
                idx2 = idx2 - 1;
            }
            stringArray[idx1] = value2;
            stringArray[idx2] = value1;
        }
        return idx1;
    }

/*
    public static int partition(String[] stringArray, int idx1, int idx2) {
        String pivotValue = stringArray[idx1];
        int l = idx1;
        int h = idx2;

        while (l < h) {
            String value1;
            String value2;
            while ((value1 = stringArray[l]).compareTo( pivotValue ) < 0) {
                l = l + 1;
            }
            while ((value2 = stringArray[h]).compareTo( pivotValue ) > 0) {
                h = h - 1;
            }
            stringArray[l] = value2;
            stringArray[h] = value1;
        }
        swap(stringArray, h, l);
        return h;
    }
*/
    public static void swap(String[] input, int l, int h) {
        String tmp = input[l];
        input[l] = input[h];
        input[h] = tmp;
    }


    //Alice Alone Boy Chair Dear Dog Water Xray Yarn Zing
    //Alice Alone Boy Chair Dear Dog Water Xray Yarn Zing

    public static void QuicksortString(String[] stringArray, int idx1, int idx2) {
        if (idx1 >= idx2) {
            // we are done
            return;
        }
        int pivotIndex = partition(stringArray, idx1, idx2);
        QuicksortString(stringArray, idx1, pivotIndex);
        QuicksortString(stringArray, pivotIndex+1, idx2);
    }
    public static void QuicksortString(String[] stringArray) {
        QuicksortString(stringArray, 0, stringArray.length - 1);
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
        QuicksortString( mySampleStringArray );
        printArray(mySampleStringArray);
    }
}
