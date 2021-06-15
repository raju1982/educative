package theory.string;

import java.util.Stack;

public class ReduceTheStringByRemovingKConsecutiveIdenticalCharacters {

    static class Pair{
        char ch;
        int count;

        Pair(char ch, int count){
            this.ch = ch;
            this.count = count;
        }
    }

    public static String Sol(String str, int k){

        if(str == null || str.trim().length() == 0 || k<=1){
            throw new IllegalArgumentException("invalid input");
        }

        str = str.trim();
        Stack<Pair> stack = new Stack<>();
        for(int i=0; i<str.length(); i++){
            char chr = str.charAt(i);
            if(stack.isEmpty()){
                stack.add(new Pair(chr, 1));
                continue;
            }

            if(stack.peek().ch == chr){
                Pair pair = stack.pop();
                pair.count++;

                if(pair.count == k){
                    continue;
                }

                stack.add(pair);
            }
            else{
                stack.add(new Pair(chr, 1));
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){
            Pair pair = stack.pop();

            while(pair.count != 0){
                sb.insert(0, pair.ch);
                pair.count--;
            }
        }

        return sb.toString();
    }

    // Driver code
    public static void main(String[] args)
    {
        int k = 2;
        String st = "geeksforweetp";
        String ans = Sol(st, k);
        System.out.println(ans);
    }
}
