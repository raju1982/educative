package theory.graph;

import java.util.*;

public class AlienDictionary {

    public static void printAlphabetOrder(String[] input) {
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        //build graph
        buildGraph(input, graph, inDegree);
        //topological sort
        System.out.println(topologicalSort(graph, inDegree));
    }

    private static void buildGraph(String[] input, Map<Character, List<Character>> graph, Map<Character, Integer> inDegree) {

        //add all character as vertices in the graph
        for (String word : input) {
            for (char character : word.toCharArray()) {
                if (!graph.containsKey(character)) {
                    graph.put(character, new ArrayList<>());
                    inDegree.put(character, 0);
                }
            }
        }

        for (int i = 0; i < input.length - 1; i++) {
            String first = input[i];
            String second = input[i + 1];
            int length = Math.min(first.length(), second.length());
            for (int j = 0; j < length; j++) {
                char firstChar = first.charAt(j);
                char secondChar = second.charAt(j);
                if (firstChar != secondChar) {
                    List<Character> tmp = graph.get(firstChar);
                    if (!tmp.contains(secondChar)) {
                        tmp.add(secondChar);
                        inDegree.put(secondChar, (inDegree.get(secondChar) + 1));
                    }
                    break;
                }
            }
        }

    }

    private static String topologicalSort(Map<Character, List<Character>> graph, Map<Character, Integer> inDegree) {
        Queue<Character> queue = new LinkedList<>();
        for (Map.Entry<Character, Integer> tmp : inDegree.entrySet()) {
            if (tmp.getValue() == 0) {
                queue.add(tmp.getKey());
            }
        }

        StringBuilder sortedOrder = new StringBuilder();

        while (!queue.isEmpty()) {
            char tmp = queue.poll();
            sortedOrder.append(tmp);
            for (char childChar : graph.get(tmp)) {
                inDegree.put(childChar, (inDegree.get(childChar) - 1));
                if (inDegree.get(childChar) == 0) {
                    queue.add(childChar);
                }
            }
        }

        // if sortedOrder doesn't contain all characters, there is a cyclic dependency between characters, therefore, we
        // will not be able to find the correct ordering of the characters
        if (sortedOrder.length() != inDegree.size()) {
            return "";
        } else {
            return sortedOrder.toString();
        }

    }

    public static void main(String[] args) {
        //Input: Words: ["ba", "bc", "ac", "cab"]
        /*
        1. From "ba" and "bc", we can conclude that 'a' comes before 'c'.
        2. From "bc" and "ac", we can conclude that 'b' comes before 'a'
         */
        //"bac"
        printAlphabetOrder(new String[]{"ba", "bc", "ac", "cab"});

        //"ywxz"
        printAlphabetOrder(new String[]{"ywx", "wz", "xww", "xz", "zyy", "zwz"});

    }

}
