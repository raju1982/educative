package string;

public class FunctionThatRemovesSubstrings {

    public static void main(String[] args){
        String oldStr = "Hello, this is the substring string from which a substring will be deleted";
        String delStr = "substring";
        String newStr;

        newStr = oldStr.replace(delStr, "");

        System.out.println(oldStr);
        System.out.println(newStr);

        //System.out.println(removeChar(oldStr, 'i'));
        System.out.println(removeSubString(oldStr, delStr));
    }

    //best solition
    public static String removeSubstring(String input, String remove){
        while(input.indexOf(remove) != -1){
            int tmp = input.indexOf(remove);
            input = input.substring(0,tmp) + input.substring(tmp + remove.length());
        }
        return input;
    }


    private static String removeSubString(String input, String subStr) {
        StringBuffer buf = new StringBuffer();
        int i = input.indexOf(subStr);
        if(i==-1){
            return input;
        }
        buf.append(input.substring(0,i));
        buf.append(input.substring(i+subStr.length()));
        return removeSubString(buf.toString(), subStr);
    }


    private static String removeChar(String s, char c) {
        StringBuffer buf = new StringBuffer();
        for (int i=0; i<s.length(); i++){
            char cur = s.charAt(i);
            if(cur != c) {
                buf.append(cur);
            }
        }
        return buf.toString();
    }
}
