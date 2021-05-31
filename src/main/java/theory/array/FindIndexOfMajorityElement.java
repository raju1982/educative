package theory.array;

public class FindIndexOfMajorityElement {

    public static int solution(int[] input){
        int index = 0;
        int count = 1;

        for(int i=1; i<input.length; i++){
            if(input[i] == input[index]){
                count ++;
            }
            else{
                count --;
            }
            if(count == 0){
                index = i;
                count = 1;
            }
        }
        count = 0;
        for(int i=0; i<input.length; i++){
            if(input[i] == input[index]){
                count++;
            }
        }

        if(count <= input.length/2){
            index = -1;
        }

        return index ;
    }

    public static void main(String[] args){
        System.out.println(solution(new int[]  {8, 8, 6, 6, 6, 4, 6}));
    }

}
