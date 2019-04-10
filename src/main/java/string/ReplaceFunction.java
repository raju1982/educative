package string;

public class ReplaceFunction {


    //replace(char oldChar, char newChar):
    //replaceAll(String regex, String replacement):

    public static String replace(String inputA, String inputB){
        int tmp = inputA.indexOf(inputB);
        if(tmp==-1){
            return inputA;
        }
        return inputA.substring(0, tmp) + inputA.substring(tmp+inputB.length(), inputA.length());
    }

    public static void main(String[] args){
        System.out.println(replace("rakesh", "tm"));
        System.out.println(replace("rakesh", "ke"));
    }
}
