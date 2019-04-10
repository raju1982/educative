package array;

public interface FindMaximumSingleSellProfit {

    public static void stockPrice(int[] input){

        int buy=input[0];
        int sell=input[1];
        int profit=sell-buy;

        for(int i=1; i<input.length; i++){
            int tempProfit = input[i] - buy;
            if(tempProfit > profit){
                profit = tempProfit;
                sell = input[i];
            }
            if(input[i] < buy){
                buy = input[i];
            }
        }

        System.out.println("sell=" + sell + " ,profit=" + profit);
    }


    public static void main(String[] args){
        stockPrice(new int[] {8,5,12,9,19,1});
    }

}
