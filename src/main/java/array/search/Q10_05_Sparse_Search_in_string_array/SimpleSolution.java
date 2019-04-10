package array.search.Q10_05_Sparse_Search_in_string_array;

public class SimpleSolution {


    public static int binarySearch(String[] input, int min, int max, String num) {
        if (input == null) {
            throw new IllegalArgumentException();
        }

        if (min > max) {
            return -1;
        }

        int mid = min + (max - min) / 2;

        int i = 0;
        while (mid > min) {
            if (input[mid].trim().length() == 0) {
                mid--;
            } else {
                break;
            }
        }

        if (input[mid].compareTo(num) == 0) {
            return mid;
        }

        if (input[mid].compareTo(num) > 0) {
            return binarySearch(input, min, mid - 1, num);
        } else {
            return binarySearch(input, mid + 1, max, num);
        }
    }

    public static final String[] data = new String[]{"at", "", "", "ball", "", "", "car", "", "", "dad", "", ""};

    /*
        @Test
        public void validTest(){
            assertEquals(binarySearch(data, 0, data.length-1, 9),3);
        }

        @Test
        public void inValidTest(){
            assertEquals(binarySearch(data, 0, data.length-1, 19),-1);
        }
    */
    public static void main(String[] args) {
        System.out.println(binarySearch(data, 0, data.length - 1, "car"));
        System.out.println(binarySearch(data, 0, data.length - 1, "duck"));
        System.out.println(binarySearch(data, 0, data.length - 1, "ab"));
    }


}





