package theory.recursion;

public class Knapsack {


    public static int sol(int[] weights, int[] values, int currentWeight, int currentIndex){

        if(currentIndex==0 || currentWeight==0){
            return 0;
        }

        if(currentWeight<weights[currentIndex-1]){
            return sol(weights, values, currentWeight, currentIndex-1);
        }
        else{
            return Math.max(sol(weights, values, currentWeight, currentIndex-1),
                    values[currentIndex-1] + sol(weights, values, currentWeight-weights[currentIndex-1], currentIndex-1));
        }

    }

    public static void main(String[] args){
        int values[] = new int[] { 60, 100, 120 };
        int weights[] = new int[] { 10, 20, 30 };
        System.out.println(sol(weights, values, 50, weights.length));
    }

}
