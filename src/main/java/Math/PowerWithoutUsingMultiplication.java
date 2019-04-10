package Math;

public class PowerWithoutUsingMultiplication {
    public static void main(String[] args){
        System.out.println(powerImpl(2,4));
    }

    public static int powerImpl(int number, int power){
        if (power == 0)
            return 1;

        int answer = number;
        int increment = number;

        for (int i = 1; i < power; i++) {
            for (int j = 1; j < number; j++) {
                answer += increment;
            }
            increment = answer;
        }
        return answer;
    }
}

