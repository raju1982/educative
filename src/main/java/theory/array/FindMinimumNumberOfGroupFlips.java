package theory.array;

public class FindMinimumNumberOfGroupFlips {

    public static void solution(int[] input){
        for(int i=1; i<input.length; i++){
            if(input[i]!=input[i-1]){
                if(input[i] != input[0]){
                    System.out.print("start - " + i + " , ");
                }
                else{
                    System.out.println("end - " + (i-1));
                }
            }
        }

        if(input[input.length-1]!=input[0]) {
            System.out.println("end - " + (input.length-1));
        }
    }

    public static void main(String[] args){
        solution(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 0});
        solution(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1});
    }
}
