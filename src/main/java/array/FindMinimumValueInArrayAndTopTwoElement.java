package array;

public class FindMinimumValueInArrayAndTopTwoElement {

    public static void main(String[] args){
        System.out.println(solution(new int[] {9,2,3,6}));
        System.out.println(topTwoInArray(new int[] {9,2,3,6}));
    }

    public static int solution(int[] input){
        int answer = input[0];

        for(int i=1; i<input.length; i++)
            if(input[i] < answer){
                answer = input[i];
        }
        return answer;
    }

    public static int topTwoInArray(int[] input){
        int highest = input[0];
        int secondHighest = input[0];

        for(int i=1; i<input.length; i++){
            if(input[i] > highest){
                secondHighest = highest;
                highest = input[i];
            }
            else if(input[i] > secondHighest){
                secondHighest = input[i];
            }
        }
        return secondHighest;
    }


}