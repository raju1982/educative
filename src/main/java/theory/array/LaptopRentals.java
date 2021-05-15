package theory.array;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

//time complexity 0(nlog(n)) due to sorting
//space complexity 0(n) -> Array stores the times
public class LaptopRentals {

    static int solution(List<List<Integer>> data){
        int size = data.size();
        int[] startTimes = new int[size];
        int[] endTimes = new int[size];
        for(int i=0; i<data.size();i++){
            startTimes[i] = data.get(i).get(0);
            endTimes[i] = data.get(i).get(1);
        }
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int laptopCount = 0;
        for(int i=0,j=0; i<size && j<size ;){
            if(startTimes[i]>=endTimes[j]){
                laptopCount--;
                j++;
            }
            laptopCount++;
            i++;
        }
        return laptopCount;
    }

    public static void main(String[] args){
        List<List<Integer>> data = new ArrayList<>();
        data.add(Arrays.asList(0, 2));
        data.add(Arrays.asList(1, 4));
        data.add(Arrays.asList(4, 6));
        data.add(Arrays.asList(0, 4));
        data.add(Arrays.asList(7, 8));
        data.add(Arrays.asList(9, 11));
        data.add(Arrays.asList(3, 10));

        System.out.println(solution(data));
    }
}
