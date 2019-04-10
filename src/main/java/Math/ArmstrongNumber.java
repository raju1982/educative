package Math;

public class ArmstrongNumber {

    public static int power(int num, int power){
        int result=num;

        while(power>1){
            result = result*num;
            power--;
        }
        return result;
    }

    public static boolean isArmstrong(int num){
        int sum = 0 ;
        int tmp=num;
        while(tmp>0){
            sum=sum+power(tmp%10,3);
            tmp = tmp/10;
        }
        if(sum == num){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        System.out.println(isArmstrong(153));
    }
}
