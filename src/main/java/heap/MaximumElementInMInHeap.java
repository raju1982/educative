package heap;

public class MaximumElementInMInHeap {

    public static int findMaxElement(int[] data){

        int parentIdex = findParentIndex(data.length-1);

        int max = data[parentIdex+1];
        for(int i=parentIdex+2; i<data.length; i++){
            int tmp = data[i];
            if(max < tmp){
                max = tmp;
            }
        }
        return max;
    }

    public static int findParentIndex(int index){
        return (index-1)/2;
    }

    public static void main(String[] args){
        System.out.println(findMaxElement(new int[]{5,8,6,9,12,11,7,15,10}));
    }

}
