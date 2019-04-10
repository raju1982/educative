public class PowerOfANumber {

    public static float calculatePower(float number, float power){
        float tmp =1;
        for(int i=1; i<=power; i++){
            tmp = tmp*number;
        }
        return tmp;
    }

    static double power_rec(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;

        double temp = power_rec(x, n/2);
        if (n % 2 == 0)  {
            return temp * temp;
        } else {
            return x * temp * temp;
        }
    }


    public static void main(String[] args){
        System.out.println(calculatePower(3,3));
        //System.out.println(calculatePower(1.5f, 3));
        //System.out.println(calculatePower2(3,3));

        //System.out.println(power_rec(3,3));
        //System.out.println(power_rec(1.5f, 3));
    }

}
