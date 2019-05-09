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
    public static int[] listOfSumOfAllElementsExceptItself2(int[] input){
        int[] leftArray = new int[input.length];

        int sum=1;
        for(int i=0; i<leftArray.length; i++){
            leftArray[i] = sum;
            sum = input[i] * sum;
        }

        sum=1;
        for(int i=leftArray.length-1; i>=0; i--){
            leftArray[i] = leftArray[i]*sum;
            sum = input[i] * sum;
        }
        return leftArray;
    }

    @Test
    public void test(){
        int[] input = new int[]{4,7,2,9,12,10,3};
        //findProduct(input);
        System.out.println(Arrays.toString(listOfSumOfAllElementsExceptItself2(input)));
        //assertEquals(productImpl(input), {});
    }

}

//45360 25920 90720 20160 15120 18144 60480
//[45360, 25920, 90720, 20160, 15120, 18144, 60480]
//[45360, 25920, 90720, 20160, 15120, 18144, 60480]
//[45360, 25920, 90720, 20160, 15120, 18144, 60480]