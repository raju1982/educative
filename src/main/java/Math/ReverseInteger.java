package Math;

public class ReverseInteger {
    public int reverse(int n) {

        int reversed = 0;
        int remainder = 0;

        while(n>0) {
            //get the last digit of the integer n
            remainder = n%10;
            //get rid of the last digit
            n = n/10;
            //append that digit to the solution
            reversed = reversed*10+remainder;
        }

        return reversed;
    }
}
