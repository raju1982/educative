package theory.array;

public class SingleCycleCheck {

    public static boolean isCycle(int[] input){
        int startIndex = 0;
        int visitedIndexCount = 0;
        System.out.print(startIndex + "\t");
        while(visitedIndexCount<input.length){
            if(startIndex == 0 && visitedIndexCount!=0){
                return false;
            }
            startIndex = newIndex(input, startIndex);
            System.out.print(startIndex + "\t");
            visitedIndexCount++;
        }

        return startIndex == 0;
    }

    private static int newIndex(int[] input, int startIndex){
        int endIndex = (startIndex + input[startIndex]) % input.length;
        endIndex = endIndex>=0 ? endIndex : endIndex + input.length;
        return endIndex;
    }

    public static void main(String[] args){
        System.out.println(isCycle(new int[]{2,3,1,-4,-4,2}));
    }

}
