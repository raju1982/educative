package array;

public class RecursiveDigitSum {

    public static int calculate(String number, int k){
        StringBuilder tmp = new StringBuilder();
        while(k>0){
            tmp.append(number);
            k--;
        }

        int num = Integer.valueOf(tmp.toString());

        int sum=0;
        while(num>0){
            sum = sum + num%10;
            num = num/10;
        }

        return sum;
    }
}
