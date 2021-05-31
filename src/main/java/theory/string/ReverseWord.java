package theory.string;

public class ReverseWord {

    public static char[] sol(String input){
        if(input == null || input.trim().length() == 0){
            throw new IllegalArgumentException();
        }

        input = input.trim();

        char[] arr = input.toCharArray();

        if(input.length() == 1){
            return arr;
        }

        reverse (arr, 0, arr.length-1);

        //dlrow olleh -> //world hello
        int start = 0;
        for(int i=0; i<arr.length-1; i++){
            if(arr[i] == ' '){
                reverse (arr, start, i-1);
                start = i+1;
            }
        }

        reverse (arr, start, arr.length-1);

        return arr;
    }


    private static void reverse (char[] arr, int i, int j){
        while(i<j){
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }

    public static void main(String[] args){
        String test = "hello world";
        System.out.println(sol(test));
    }


}
