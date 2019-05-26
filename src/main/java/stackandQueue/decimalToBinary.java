package stackandQueue;
import java.util.Stack;

public class decimalToBinary {

    public static void main(String[] args) {
        System.out.println(decimalToBinary(6));
    }

    public static String decimalToBinary(int number){
        StringBuilder str = new StringBuilder();
        Stack<Integer> data = new Stack<Integer>();
        int num = number;
        while(num>0){
            data.push(num%2);
            num = num/2;
        }
        while(!data.isEmpty()){
            str.append(data.pop());
        }
        return str.toString();
    }

}
