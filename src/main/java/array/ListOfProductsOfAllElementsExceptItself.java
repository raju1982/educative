package array;

import org.testng.annotations.Test;

import java.util.Arrays;

public class ListOfProductsOfAllElementsExceptItself {

    public static int[] findProduct(int arr[]) {
        int n = arr.length;
        int i, temp = 1;

    /* Allocate memory for the product array */
        int product[] = new int[n];

    /* Initialize the product array as 1 */
        for (int j = 0; j < n; j++)
            product[j] = 1;

    /* In this loop, temp variable contains product of
           elements on left side excluding arr[i] */
        for (i = 0; i < n; i++) {
            product[i] = temp;
            temp = temp * arr[i];
        }

    /* Initialize temp to 1 for product on right side */
        temp = 1;

    /* In this loop, temp variable contains product of
           elements on right side excluding arr[i] */
        for (i = n - 1; i >= 0; i--) {
            product[i] = product[i]*temp;
            temp = temp * arr[i];
        }

    /* print the constructed prod array */
        for (i = 0; i < n; i++)
            System.out.print(product[i] + " ");

        return product;
    }

    //another solution
    public static int[] ListOfSumOfAllElementsExceptItself(int[] input){
        int[] leftArray = new int[input.length];
        int[] rightArray = new int[input.length];
        int[] result = new int[input.length];

        int sum=1;
        leftArray[0] = sum;
        for(int i=1; i<leftArray.length; i++){
            sum = input[i-1] * sum;
            leftArray[i] = sum;
        }

        sum=1;
        rightArray[rightArray.length-1] = sum;
        for(int i=rightArray.length-2; i>=0; i--){
            sum = input[i+1] * sum;
            rightArray[i] = sum;
        }

        for(int i=0; i<rightArray.length; i++){
            result[i] = leftArray[i] * rightArray[i];
        }

        return result;
    }

    @Test
    public void test(){
        int[] input = new int[]{4,7,2,9,12,10,3};
        findProduct(input);
        //System.out.println(Arrays.toString(input));
        //assertEquals(productImpl(input), {});
    }

}
