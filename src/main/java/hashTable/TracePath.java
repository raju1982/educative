package hashTable;

import java.util.Map;
import java.util.HashMap;

public class TracePath {

    static void path(Map<String, String> input){ // source=key, destination=value

        Map<String, String> data = new HashMap<>();

        for(Map.Entry<String, String> tmp: input.entrySet()){
            data.put(tmp.getValue(), tmp.getKey());
        }

        String source="";

        for(Map.Entry<String, String> tmp: input.entrySet()){
            if(!data.containsKey(tmp.getKey())){
                source=tmp.getKey();
            }
        }

        String to = input.get(source);
        System.out.print(source + "->" + to + "->");
        int i= input.size();
        i--;


        while(i>0){
            source = data.get(to);
            to = input.get(source);
            System.out.print(source + "->" + to + "->");
            i--;
        }

    }


    public static void main(String[] args){
        Map<String, String> data = new HashMap<>();

        data.put("a","b");
        data.put("b","c");
        data.put("c","d");
        data.put("d","e");

        path(data);
    }


}
