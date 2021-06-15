package theory.string;

public class ReverseWordsInString {
    public static String solve(String input) {
        input=input.trim().replaceAll("\\s{2,}", " ");
        input = reverse(input,0, input.length()-1);

        int startIndex = 0;
        for(int i=0; i<input.length(); i++){
            if(input.charAt(i) ==  ' '){
                input = reverse(input,startIndex, i-1);
                startIndex = i+1;
            }
        }

        input = reverse(input,startIndex, input.length()-1);

        return input;
    }
    //rakesh kandpal

    public static String reverse(String input, int min, int max){
        char[] arr = input.toCharArray();
        while(min<max){
            char tmp = arr[min];
            arr[min] = arr[max];
            arr[max] = tmp;
            min++;
            max--;
        }
        return new String(arr);
    }

    public static void main(String[] args){
        String input = "the sky is blue";
        System.out.println(solve(input));
    }
}
