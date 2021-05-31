package theory.array.sort;

public class IntersectionOfTwoSortedArrays {

    public static void solution(int[] inputA, int[] inputB){

        if(inputA==null || inputB==null){
            throw new IllegalArgumentException("invalid input");
        }

        int i=0, j=0;

        while((i<inputA.length) && (j<inputB.length)){
            //this is just to clean up the duplicates
            if(i>0 && inputA[i] == inputA[i-1]){
                i++;
                continue;
            }
            if(inputA[i] == inputB[j]){
                System.out.print(inputA[i] + "\t");
                i++;
                j++;
            }
            else if(inputA[i]<inputB[j]){
                i++;
            }
            else{
                j++;
            }
        }
    }

    public static void main(String[] args){
        solution(new int[] {3,5,10,10,10,15,15,20}, new int[] {5,10,10,15,30});
    }
}
