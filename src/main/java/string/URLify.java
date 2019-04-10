package string;

import CtCILibrary.CtCILibrary.AssortedMethods;

public class URLify {

    public static String urlfy(String input){
        String[] data = input.trim().split(" ");
        StringBuilder strBuilder = new StringBuilder();
        for(int i=0; i<data.length; i++){
            strBuilder.append(data[i]);
            if(i!=data.length-1) {
                strBuilder.append("%20");
            }
        }
        return strBuilder.toString();
    }











    // Assume string has sufficient free space at the end
    public static void replaceSpaces(char[] str, int trueLength) {
        int spaceCount = 0, new_length, i = 0;
        //count empty spaces
        for (i = 0; i < trueLength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }

        new_length = trueLength + spaceCount * 2;

        // Fill string termination.
        if (trueLength < str.length) {
            str[trueLength] = '\0';
        }

        // Fill rest of the string from end
        for (i = trueLength - 1; i >= 0; i--) {
            // inserts %20 in place of space
            if (str[i] == ' ') {
                str[new_length - 1] = '0';
                str[new_length - 2] = '2';
                str[new_length - 3] = '%';
                new_length = new_length - 3;
            } else {
                str[new_length - 1] = str[i];
                new_length--;
            }
        }
    }

    public static int findLastCharacter(char[] str) {
        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i] != ' ') {
                return i;
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        String str = "Mr John Smith    ";
        char[] arr = str.toCharArray();
        int trueLength = findLastCharacter(arr) + 1;
        replaceSpaces(arr, trueLength);
        System.out.println("\"" + AssortedMethods.charArrayToString(arr) + "\"");
        System.out.println(urlfy(str));
    }
}
