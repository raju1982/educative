package array;

/*
https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting
 */

import java.util.Arrays;

public class FraudulentActivityNotifications {

    public static int solution(int[] input, int days){
        int count=0;
        double meadian;
        int[] medianArray = new int[days];
        for(int i=0;i<input.length; i++){
            if(i>days-1){
                Arrays.sort(medianArray);
                if(days%2==0) {
                    meadian = (medianArray[days/2] + medianArray[(days-2)/2])/2.0;
                }
                else{
                    meadian = medianArray[(days-1) / 2];
                }
                if(input[i]>=2*meadian) {
                    count++;
                }
            }
            //System.out.println(i%days);
            medianArray[i%days] = input[i];
        }
        return count;
    }
}
