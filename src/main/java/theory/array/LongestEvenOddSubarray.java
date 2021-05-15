package theory.array;

public class LongestEvenOddSubarray {

    public static int solution(int[] input){
        int overallCount = 1;
        int runningCount = 1;
        boolean evenflag = input[0]%2==0?true:false;
        boolean oddflag = input[0]%2!=0?true:false;

        for(int i=1; i<input.length; i++){
            boolean tmpEvenflag = input[i]%2==0?true:false;
            boolean tmpOddflag = input[i]%2!=0?true:false;

            if(tmpEvenflag && evenflag){
                continue;
            }

            if(tmpOddflag && oddflag){
                continue;
            }

            runningCount++;
            overallCount = Math.max(overallCount, runningCount);

            evenflag = input[i]%2==0?true:false;
            oddflag = input[i]%2!=0?true:false;
        }
        return overallCount;
    }

    //better solution
    static int maxEvenOdd(int arr[]){
        int res = 1;
        int curr = 1;

        for(int i = 1; i < arr.length; i++){
            if((arr[i] % 2 == 0 && arr[i - 1] % 2 != 0)
                    ||(arr[i] % 2 != 0 && arr[i - 1] % 2 == 0)){
                curr++;
                res = Math.max(res, curr);
            }
            else {
                curr = 1;
            }
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(solution(new int[]{10,12,8,4}));
        System.out.println(solution(new int[]{9,7,13,5}));
        System.out.println(solution(new int[]{7,10,13,14}));
        System.out.println(solution(new int[]{10,12,14,7,8}));


        System.out.println(maxEvenOdd(new int[]{10,12,8,4}));
        System.out.println(maxEvenOdd(new int[]{9,7,13,5}));
        System.out.println(maxEvenOdd(new int[]{7,10,13,14}));
        System.out.println(maxEvenOdd(new int[]{10,12,14,7,8}));
    }
}
