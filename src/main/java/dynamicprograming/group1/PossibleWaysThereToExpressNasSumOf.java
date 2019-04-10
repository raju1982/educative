package dynamicprograming.group1;

public class PossibleWaysThereToExpressNasSumOf {

    public static int noOfWays(int input){
        //0,1
        if(input<3){
            return 1;
        }
        if(input == 3){
            return 2;
        }
        if(input == 4){
            return 4;
        }

        int[] data = new int[input+1];
        data[1]=1;
        data[2]=1;
        data[3]=2;
        data[4]=4;
        int count = 5;
        int sum = 0;

        while(count <= input){
            data[count] = data[count-1]+data[count-3]+data[count-4];
            count++;
        }

        return data[count-1];
    }
    public static void main(String[] args) {
        System.out.println(noOfWays(4));
        System.out.println(noOfWays(5));
        System.out.println(noOfWays(6));
    }
}

//https://www.educative.io/collection/page/5668639101419520/5633779737559040/5724313353191424