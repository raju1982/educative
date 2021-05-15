package theory.array;

public class FrequenciesInSortedArray {

    public static void sol(int[] input){
        int i=1;
        int count = 1;
        while(i<input.length){
            while(i<input.length && input[i]==input[i-1]){
                count++;
                i++;
            }
            System.out.println(input[i-1] + " : " + count);
            count = 1;
            i++;
        }
        if(i==1 || (input[i-1]!=input[i-2])){
            System.out.println(input[i-1] + " : " + count);
        }
    }

    public static void main(String[] args){
        sol(new int[]{10,10,10,30,30,40});
    }

}
