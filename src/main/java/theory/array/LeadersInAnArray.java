package theory.array;

public class LeadersInAnArray {

    public static void solution(int[] input){
        int max = input[input.length-1];
        System.out.print(max + "\t");

        for(int i=input.length-2; i>0; i--){
            if(input[i]>max){
                System.out.print(input[i] + "\t");
                max = input[i];
            }
        }
    }

    public static void main(String[] args){
        solution(new int[]{7,10,4,10,6,5,2});
    }

}
