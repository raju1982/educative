package theory.array;

public class StockBuyAndSellProblem {

    static int maxProfit(int price[]){
        int profit = 0;

        for(int i = 1; i < price.length; i++){
            if(price[i] > price[i - 1])
                profit = profit + (price[i] - price[i -1]);
        }
        return profit;
    }

    public static int solution(int[] input){
        int min = input[0];
        int profit = 0;
        for(int i=1; i<input.length; i++){
            if(min > input[i]){
                min = input[i];
                continue;
            }
            if(input[i]>min){
                profit = profit + (input[i]-min);
                min = input[i];
            }
        }
        return profit;
    }

    public static void main(String args[]){
        System.out.println(maxProfit(new int[] {1, 5, 3, 8, 12}));
        System.out.println(solution(new int[] {1, 5, 3, 8, 12}));
    }

}

