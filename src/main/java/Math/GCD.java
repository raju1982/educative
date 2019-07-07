package Math;

public class GCD {

    public static int solution(int a, int b) {
        if (a == 0) {
            return b;
        }

        if (b == 0) {
            return a;
        }

        if (a == b) {
            return a;
        }

        if (a > b) {
            return solution(a - b, b);
        } else {
            return solution(a, b - a);
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(98,56));
        System.out.println(solution(56,98));
    }
}
