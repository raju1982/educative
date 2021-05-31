package theory.array.sort;

public class UnionOfTwoSortedArray {

    public static void union(int[] inputA, int[] inputB){
        int i = 0, j = 0;
        int lastNumber = Integer.MIN_VALUE;
        while(i<inputA.length && j<inputB.length){
            if(i>0 && inputA[i-1] == inputA[i]){
                i++;
                continue;
            }
            if(inputA[i]<inputB[j]){
                lastNumber = inputA[i];
                System.out.print(inputA[i] + " ");
                i++;
            }
            else if(inputA[i]>inputB[j]){
                lastNumber = inputB[j];
                System.out.print(inputB[j] + " ");
                j++;
            }
            else{
                lastNumber = inputB[j];
                System.out.print(inputA[i] + " ");
                i++;
                j++;
            }
        }

        while(i<inputA.length){
            if(lastNumber == inputA[i]){
                i++;
                continue;
            }
            System.out.print(inputA[i] + " ");
            i++;
        }

        while(j<inputB.length){
            if(lastNumber == inputB[j]){
                j++;
                continue;
            }
            System.out.print(inputB[j] + " ");
            j++;
        }

    }

    public static void main(String[] args){
        union(new int[]{3,5,8}, new int[]{2,8,9,10,15});
        System.out.println("\n");
        union(new int[]{2,3,3,3,4,4}, new int[]{4,4});
    }


    /*
    static void printUnion(int a[], int b[], int m, int n){

        int i=0,j=0;
        while(i<m && j<n){
            if(i>0 && a[i-1]==a[i]){i++;continue;}
            if(j>0 && b[j-1]==b[j]){j++;continue;}
            if(a[i]<b[j]){System.out.print(a[i]+" ");i++;}
            else if(a[i]>b[j]){System.out.print(b[j]+" ");j++;}
            else{System.out.print(a[i]+" ");i++;j++;}
        }
            while(i<m){if(i==0||a[i]!=a[i-1])System.out.print(a[i]+" ");i++;}
            while(j<n){if(j==0||b[j]!=b[j-1])System.out.print(b[j]+" ");j++;}
    }
     */

}
