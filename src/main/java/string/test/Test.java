package string.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

import java.util.Stack;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class Test {

    public static int solution(String[] stringList, int min, int max, String input){
        //null check

        int mid = min + (max-min)/2;
        int i=mid+1;
        int j=mid-1;
        boolean flag = true;
        while((i<stringList.length || j>=0) && stringList[mid].trim().length() == 0){
            while(flag && i<stringList.length){
                mid = i;
                i++;
                flag = false;
            }

            while(!flag && j>=0){
                mid = j;
                j--;
                flag = true;
            }
        }

        String tmp = stringList[mid].trim();
        if(tmp.equalsIgnoreCase(input)){
            return mid;
        }
        else if(tmp.compareTo(input) > 0){
            return solution(stringList, min, mid-1, input);
        }
        else {
            return solution(stringList, mid + 1, max, input);
        }
    }

    public static void main(String[] str){
        String[] stringList = {"apple", "", "", "banana", "", "", "", "carrot", "duck", "", "", "eel", "", "flower"};
        System.out.println(solution(stringList, 0,stringList.length,"banana"));
    }
}

//Alice Alone Boy Chair Dear Dog Water Xray Yarn Zing