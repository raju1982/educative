package string;

public class reverse {

    public static String reverse(String input){

        if (input == null) {
            throw new IllegalArgumentException("invalid data");
        }

       StringBuilder reverseString = new StringBuilder();

        for(int i=input.length()-1; i>=0; i--){
            reverseString.append(input.charAt(i));
        }

        return reverseString.toString();
    }

    public static void main(String[] args){
        System.out.println(reverse("rakesh"));
        System.out.println(reverse("medaf"));
    }

}
