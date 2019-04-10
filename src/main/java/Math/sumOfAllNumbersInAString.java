package Math;

public class sumOfAllNumbersInAString {

    public static void main(String[] args){
        String tmp = "a152b48c59";
        int sum =0;
        StringBuilder strBuilder = new StringBuilder();
        for(int i=0; i<tmp.length(); i++){
            char tmpVal = tmp.charAt(i);
            if(Character.isDigit(tmpVal)){
                strBuilder.append(tmpVal);
            }
            else{
                if(i>0 && Character.isDigit(tmp.charAt(i-1))){
                    sum = sum + Integer.valueOf(strBuilder.toString());
                    strBuilder.setLength(0);
                }
            }
        }
        if(strBuilder.length()!=0) {
            sum = sum + Integer.valueOf(strBuilder.toString());
        }

        System.out.println(sum);
    }
}
