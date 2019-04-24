package array.play;

import array.search.Q10_04_Sorted_Search_No_Size.Listy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Test {

    /*
    public static int matchIndex(String input, String pattern){
        int count;
        int index = -1;
        int jump;
        for(int i=0; i<input.length(); i++){
            count = 0;
            index = i;
            jump=0;
            for(int j=0; j<pattern.length(); j++){
                if(input.charAt(i+jump) == pattern.charAt(j)){
                    count++;
                    jump++;
                }
                else{
                    break;
                }
            }
            if(count == pattern.length()){
                break;
            }
            else{
                index=-1;
            }
        }
        return index;
    }

    public static boolean hasSubstring(char[] text, char[] pattern){
        int i=0;
        int j=0;
        int k = 0;
        while(i < text.length && j < pattern.length){
            if(text[i] == pattern[j]){
                i++;
                j++;
            }else{
                j=0;
                k++;
                i = k;
            }
        }
        if(j == pattern.length){
            return true;
        }
        return false;
    }*/

    /*
    public static int binarySearch(int[] input, int start, int end, int searchParam){
        if(start > end){
            return -1;
        }

        int index = start + (end-start)/2;

        if(input[index] == searchParam){
            return index;
        }

        if(input[index]>searchParam){
            return  binarySearch(input, start, index-1, searchParam);
        }
        else{
            return  binarySearch(input, index+1, end, searchParam);
        }
    }
    */

    public static int binarySearch(int[] input, int value, int low, int high) {
        int mid;
        int middle;
        while (low <= high) {
            mid = (low + high) / 2;
            if(mid<input.length) {
                middle = input[mid];
            }
            else{
                middle = -1;
            }
            if (middle > value || middle == -1) {
                high = mid - 1;
            } else if (middle < value) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }



    public static int search(int[] input, int value) {
        int index = 1;
        while (index < input.length && input[index] < value) {
            index *= 2;
        }
        //System.out.println("index : " + index + "list.elementAt(index): " + list.elementAt(index));
        //System.out.println("index-1 : " + (index-1) + "list.elementAt(index): " + list.elementAt(index-1));
        return binarySearch(input, value, index / 2, index);
    }


    public static int searchWithNosize(int[] input, int searchParam){
        int JUMP_CONSTANT = 10000;
        int start = 0;
        int end = JUMP_CONSTANT;
        while(true){
            //if end is equal to length of array , break the loop.
            if(input[end] > searchParam){
                return binarySearch(input, start, end-1, searchParam);
            }
            start = end;
            end = end + JUMP_CONSTANT;
        }
    }

    public static void solution(int[] input, int size){
        //input == null || size ==0 illegalArgumentException

        PriorityQueue<Integer> data = new PriorityQueue<>(size);
        for(int i=0; i<input.length; i++){
            data.offer(input[i]);
        }

        int i=0;
        while(i<size){
            System.out.println(data.poll());
            i++;
        }
    }


    public static void maxsolution(int[] input, int size){
        //input == null || size ==0 illegalArgumentException

        PriorityQueue<Integer> data = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return b-a;
            }
        });

        for(int i=0; i<input.length; i++){
            data.offer(input[i]);
        }

        int i=1;
        while(i<=size){
            System.out.println(data.poll());
            i++;
        }
    }


    public static void main(String[] args){
        solution(new int[] {20,15,7,9,12,14,18,21}, 3);
        maxsolution(new int[] {20,15,7,9,12,14,18,21}, 3);

        /*int[] input = new int[] {2,5,7,9,12,14,18,21};
        System.out.println(binarySearch(input, 0, input.length-1, 18));
        System.out.println(binarySearch(input, 0, input.length-1, 11));

        for(int num : input) {
            System.out.println(search(input, num));
        }
        */

        //System.out.println(search(input,11));

        /*System.out.println(matchIndex("abcbcglx", "bcgll"));
        System.out.println(matchIndex("abcbcgll", "bcgll"));

        System.out.println(hasSubstring("abcbcglx".toCharArray(), "bcgll".toCharArray()));
        System.out.println(hasSubstring("abcbcgll".toCharArray(), "bcgll".toCharArray()));*/
    }
}
