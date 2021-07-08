package theory.array.rotate;

import java.util.*;

public class LeftRotateGeneric {
    public static List<Integer> rotLeft(List<Integer> a, int d) {
        int size = a.size();
        d = d % size;
        List<Integer> result = new ArrayList<>();

        for(int i=0; i<size; i++){
            result.add(a.get((i + d) % size));
        }

        return result;
    }
}
