package dynamicprograming.group1;

class HouseThief {

    public int findMaxSteal(int[] wealth) {
        if(wealth.length == 0) return 0;
        int n1=0, n2=wealth[0], temp;
        for(int i=1; i < wealth.length; i++) {
            temp = Math.max(n1 + wealth[i], n2);
            n1 = n2;
            n2 = temp;
        }
        return n2;
    }

    public static void main(String[] args) {
        HouseThief ht = new HouseThief();
        int[] wealth = {2, 5, 1, 3, 6, 2, 4};
        System.out.println(ht.findMaxSteal(wealth));
        wealth = new int[]{2, 10, 14, 8, 1};
        System.out.println(ht.findMaxSteal(wealth));
    }
}

//https://www.educative.io/collection/page/5668639101419520/5633779737559040/5676982813589504

/*
dp[i] = max (hval[i] + dp[i-2], dp[i-1])

hval[i] + dp[i-2] is the case when thief
decided to rob house i. In that situation
maximum value will be the current value of
house + maximum value stolen till last
robbery at house not adjacent to house
i which will be house i-2.

dp[i-1] is the case when thief decided not
to rob house i. So he will check adjacent
house for maximum value stolen till now.
 */


/*
class HouseThief {

  public int findMaxSteal(int[] wealth) {
    return findMaxStealRecursive(wealth, 0);
  }

  private int findMaxStealRecursive(int[] wealth, int currentIndex) {
    if( currentIndex >= wealth.length)
      return 0;

    // steal from current house and skip one to steal from the next house
    int stealCurrent = wealth[currentIndex] + findMaxStealRecursive(wealth, currentIndex + 2);
    // skip current house to steel from the adjacent house
    int skipCurrent = findMaxStealRecursive(wealth, currentIndex + 1);

    return Math.max(stealCurrent, skipCurrent);
  }

  public static void main(String[] args) {
    HouseThief ht = new HouseThief();
    int[] wealth = {2, 5, 1, 3, 6, 2, 4};
    System.out.println(ht.findMaxSteal(wealth));
    wealth = new int[]{2, 10, 14, 8, 1};
    System.out.println(ht.findMaxSteal(wealth));
  }
}

 */