package string;

public class LexicographicallySmallestAndLargestSubStringOfSpecificSize {

    public static void lexicoGraph(String inputA, int num){
        //null check || if inputA.length < num
        String max = inputA.substring(0, num);
        String min = inputA.substring(0, num);

        for(int i=1; i<inputA.length()-num; i++){
            String tmp = inputA.substring(i, num+i);
            if(max.compareTo(tmp) < 0 ){
                max = tmp;
            }

            if(min.compareTo(tmp) > 0 ){
                min = tmp;
            }
        }

        System.out.println(max);
        System.out.println(min);
    }

    public static void main(String[] args){
       lexicoGraph("rakeshkandpal",4);
    }
}
