package Math;

public class swapTwoNumbersWithoutUsingTemporaryVariable {

    public static void main(String[] args){
        int x = 9;
        int y = 3;

        x=x+y;
        y=x-y;
        x=x-y;

        System.out.println("x=" + x + ", y=" + y);
    }
}
