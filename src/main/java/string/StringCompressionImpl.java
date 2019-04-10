package string;

public class StringCompressionImpl{

    public static String stringCompression (String inputA){

        //null || length==1 ->IllegalArgumentException

        inputA = inputA.trim().toLowerCase();
        StringBuilder result = new StringBuilder();

        int count = 1;
        int i=0;
        while(i<inputA.length()-1){
            if(inputA.charAt(i) == inputA.charAt(i+1)){
                count++;
            }
            else{
                result.append(inputA.charAt(i) + "" + count);
                count = 1;
            }
            i++;
        }
        result.append(inputA.charAt(inputA.length()-1) + "" + count);
        /*if(count == 1){
            result.append(inputA.charAt(inputA.length()-1) + "" + 1);
        }
        else{
            result.append(inputA.charAt(inputA.length()-1) + "" + count);
        }*/

        return result.toString();
    }


    public static String compression(String input){
        StringBuilder strBuilder = new StringBuilder();
        int count=1;
        for(int i=0; i<input.length()-1; i++){
            if(input.charAt(i) != input.charAt(i+1)){
                strBuilder.append(input.charAt(i)).append(count);
                count=1;
            }
            else{
                count++;
            }
        }
        strBuilder.append(input.charAt(input.length()-1)).append(count);
        return strBuilder.toString();
    }


    public static void main(String[] args){
        System.out.println(stringCompression("aabccccaaa"));

        System.out.println(compression("aabccccaaa"));
    }
}
