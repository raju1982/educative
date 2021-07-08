package theory.array.search;

public class BinarySearchIterative {

    public static int solution(int[] input, int num){
        if(input.length==1){
            if(input[0]==num){
                return 0;
            }
            else{
                return -1;
            }
        }

        int min = 0;
        int max = input.length-1;
        int result=-1;
        while(min<=max){
            int mid = min + (max-min)/2;
            int next = (mid + 1)%input.length;
            int prev = (mid+input.length-1)%input.length;

            if(input[mid]<input[prev]){
                result=mid;
                break;
            }

            if(input[mid]<input[max]){
                max=prev;
            }
            else{
                min=next;
            }
        }

        int sol1 =  binarySearch(input, num, result, input.length-1);
        System.out.println("result " + result + " sol1 " +  sol1);
        if(sol1!=-1){
            return sol1;
        }
        else{
            return binarySearch(input, num, 0, result-1);
        }

    }



    public static int binarySearch(int[] input, int num, int min, int max){
        while(min<=max){
            int mid = min + (max-min)/2;
            if(input[mid] == num){
                return mid;
            }

            if(input[mid] > num){
                max = mid-1;
            }
            else{
                min = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int output = solution(new int[]{4,5,6,7,0,1,2}, 0);
        System.out.println(output);

        output = solution(new int[]{4,5,6,7,0,1,2}, 3);
        System.out.println(output);

        output = solution(new int[]{1}, 0);
        System.out.println(output);

        output = solution(new int[]{1,3}, 3);
        System.out.println(output);
    }



    /*
    public static int search(int[] input, int number){
        int low = 0;
        int high = input.length-1;

        while(low<=high){
            int mid = (low+high)/2;
            if(input[mid] == number){
                return mid;
            }
            if(input[mid]>number){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] input = new int[]{4,6,10,12,15,17,20,25,30,35,40};
        System.out.println(search(input, 17));
        System.out.println(search(input, 37));
    }
    */

}
