package Math;

public class PrimeNumber {

    /*
    we notice that you really only have to go up to the square root of n, because if you list out all of the factors of a Math,
    the square root will always be in the middle (if it happens to not be an integer, we're still ok, we just might over-approximate,
     but our code will still work).
    Finally, we know 2 is the "oddest" prime - it happens to be the only even prime Math. Because of this,
    we need only check 2 separately, then traverse odd numbers up to the square root of n. In the end, our code will resemble this:
     */

    //checks whether an int is prime or not.
    boolean isPrime(int n) {
        //check if n is a multiple of 2
        if (n%2==0) return false;
        //if not, then just check the odds
        for(int i=3;i*i<=n;i+=2) {
            if(n%i==0)
                return false;
        }
        return true;
    }





}
