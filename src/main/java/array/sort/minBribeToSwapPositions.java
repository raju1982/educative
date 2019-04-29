package array.sort;

public class minBribeToSwapPositions {

    /*
Any person in the queue can bribe the person directly in front of them to swap positions.
If two people swap positions, they still wear the same sticker denoting their original places in line.
One person can bribe at most two others. For example, if n=8 and  person 5 bribes person 4,
the queue will look like this: 1,2,3,5,4,6,7,8
 */
    static void minimumBribes(int[] input)
    {
        int count = 0;
        for(int index = input.length - 1; index >= 0; index--)
        {
            if(input[index] != (index + 1))
            {
                if(((index - 1) >= 0) && input[index - 1] == (index + 1))
                {
                    count++;
                    int tmp = input[index];
                    input[index] = input[index-1];
                    input[index-1] = tmp;
                }
                else if(((index - 2) >= 0) && input[index - 2] == (index + 1))
                {
                    count += 2;
                    input[index - 2] = input[index - 1];
                    input[index - 1] = input[index];
                    input[index] = index + 1;
                }
                else
                {
                    System.out.printf("Too chaotic\n");
                    return;
                }
            }
        }
        System.out.printf("%d\n",count);
    }

    public static void main(String[] args){
        int[] a = {2,1,5,3,4};
        minimumBribes(a);

        a = new int[] {2,5,1,3,4};
        minimumBribes(a);

        a = new int[] {1, 2, 5, 3, 7, 8, 6, 4};
        minimumBribes(a);
    }
}
