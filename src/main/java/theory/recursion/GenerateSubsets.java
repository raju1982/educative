package theory.recursion;

public class GenerateSubsets {
    public static void solution(String subString, String current, int depth){
        if(depth == subString.length()){
            System.out.println(current);
            return;
        }
        solution(subString, current, depth+1);
        solution(subString, current + subString.charAt(depth), depth+1);
    }

    public static void main(String[] args){
        solution("ABC","",0);
    }
}
