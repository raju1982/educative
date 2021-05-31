package theory.array;

public class MajorityElementInAnArray {


    public static int solution(int[] input){

        int j=0, count =1;
        for(int i=1; i<input.length; i++){
            if(input[i] == input[j]){
                count++;
            }
            else{
                count--;
            }
            if(count == 0){
                j=i;
                count =1;
            }
        }

        count = 0;
        for(int i=0; i<input.length; i++){
            if(input[i] == input[j]){
                count ++;
            }

            if(count > input.length/2){
                return j;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        System.out.println(solution(new int[] {8,3,4,8,8}));
    }


}
