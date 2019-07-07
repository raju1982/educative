package hashTable;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;

/*
Function Prototype:
String tracePath(HashMap<String,String> map);
Here, map is a HashMap containing strings as keys and values corresponding to the cities, where the key is the departure city and the value is the arrival city

Output:
It returns the String containing the complete path from the start until the end of the journey.

Sample Input
map =
{
    "NewYork" -> "Chicago"
    "Boston" -> "Texas"
    "Missouri" -> "NewYork"
    "Texas" -> "Missouri"
}
    key -> value
Sample Output
"Boston->Texas , Texas->Missouri , Missouri->NewYork , NewYork->Chicago, "
 */

public class TracePath {

    static String path(Map<String, String> input){ // source=key, destination=value


        //check for discontinued graph
        //To fill reverse map, iterate through the given map
        HashMap < String,String > reverseMap = new HashMap < >();
        for (Map.Entry < String, String > entry : input.entrySet())
            reverseMap.put(entry.getValue(), entry.getKey());

        //Check if graph is disconnected
        int count = 0;
        Set<String> reverseMapKey = reverseMap.keySet();
        for(String tmp: reverseMapKey){
            if(!reverseMap.containsValue(tmp)){
                count++;
            }
        }

        if(count > 1){
            return "null"; // Disconnected graph
        }


        //solution
        Set<String> key = input.keySet();
        String source = null;
        for(String tmp: key){
            if(!input.containsValue(tmp)){
                source = tmp;
                break;
            }
        }

        StringBuilder result = new StringBuilder();
        String to = input.get(source);
        result.append(source + "->" + to + "->");

        while(to !=null){
            source = input.get(to);
            to = input.get(source);
            result.append(source + "->" + to + "->");
        }
        return result.toString();
    }

    //a->b->a->b->a->b->a->b->
    public static void main(String[] args){
        Map<String, String> data = new HashMap<>();

        data.put("a","b");
        data.put("b","c");
        data.put("c","d");
        data.put("d","e");

        //path(data);

        System.out.println(path(data));
    }


}
