package theory.string;

public class Palindrome {
    public static boolean solution(String input){
        char[] arr = input.toCharArray();
        int i=0,j=arr.length-1;
        while(i<j){
            if(arr[i]!=arr[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    //better solution
    public static boolean solution2(String input){
        int i=0,j=input.length()-1;
        while(i<j){
            if(input.charAt(i)!=input.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    public static void main(String[] args){
        String input = "ABCDCBA";
        System.out.println(solution(input));
        System.out.println(solution2(input));
    }
}
