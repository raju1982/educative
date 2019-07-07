package string;

public class PermutationOfString {

    public static void permutation(char[] array, int length){
      if(length == 1){
        System.out.println(array);
        return;
      }

      for(int i=0; i<length; i++){
          swap(array, i , length-1);
          permutation(array, length-1);
          swap(array, i , length-1);
      }
    }

    public static void swap(char[] array, int i , int j){
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args){
        char[] input = {'a', 'b', 'c'};
        permutation(input, input.length);
    }
}