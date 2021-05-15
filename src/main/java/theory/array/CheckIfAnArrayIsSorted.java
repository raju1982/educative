package theory.array;

public class CheckIfAnArrayIsSorted {
    public static boolean isSorted(int[] input){
        if(input.length<2){
            return true;
        }
        for(int i=1; i<input.length; i++){
            if(input[i-1]>input[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(isSorted(new int[]{8,12,15}));
        System.out.println(isSorted(new int[]{100,20,200}));
    }
}



//CheckIfAnArrayIsSorted