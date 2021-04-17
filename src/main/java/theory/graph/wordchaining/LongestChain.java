package theory.graph.wordchaining;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestChain {

    static class Vertex {
         char value;
         boolean visited;
         List<Vertex> adj_vertices;
         List<Vertex> in_vertices;

        public Vertex(char value, boolean visited) {
            this.value = value;
            this.visited = visited;
            this.adj_vertices = new ArrayList<>();
            this.in_vertices = new ArrayList<>();
        }
    }

    //directed graph
    static class Graph {
        List<Vertex> vertices;

        public Graph() {
            this.vertices = new ArrayList<>();
        }

        // This method returns the vertex with a given value if it
        // already exists in the graph, returns NULL otherwise
        Vertex vertexExists(char value) {
            for (Vertex vertex : vertices) {
                if (vertex.value == value) {
                    return vertex;
                }
            }
            return null;
        }

        // This method adds an edge from start vertex to end vertex by
        // adding the end vertex in the adjacency list of start vertex
        // It also adds the start vertex to the in_vertices of end vertex
        void addEdge(Vertex start, Vertex end) {
            start.adj_vertices.add(end);
            end.in_vertices.add(start);
        }


       // This method creates a graph from a list of words. A node of
        // the graph contains a character representing the start or end
        // character of a word.
        void createGraph(List<String> words_list) {
            for (String word : words_list) {
                char start_char = word.charAt(0);
                char end_char = word.charAt(word.length() - 1);

                Vertex start = vertexExists(start_char);
                if (start == null) {
                    start = new Vertex(start_char, false);
                    vertices.add(start);
                }

                Vertex end = vertexExists(end_char);
                if (end == null) {
                    end = new Vertex(end_char, false);
                    vertices.add(end);
                }

                // Add an edge from start vertex to end vertex
                addEdge(start, end);
            }
        }

        // This method returns TRUE if all nodes of the graph have
        // been visited
        boolean allVisited() {
            for (Vertex vertex : vertices) {
                if (!vertex.visited) {
                    return false;
                }
            }
            return true;
        }

        // This method returns TRUE if out degree of each vertex is equal
        // to its in degree, returns FALSE otherwise
        boolean outEqualsIn() {
            for (Vertex vertex : vertices) {
                int out = vertex.adj_vertices.size();
                int in = vertex.in_vertices.size();
                if (out != in) {
                    return false;
                }
            }
            return true;
        }

        // This method returns TRUE if the graph has a cycle containing
        // all the nodes, returns FALSE otherwise
        boolean canChainWordsRec(Vertex node, Vertex starting_node) {
            node.visited = true;
            // Base case
            // return TRUE if all nodes have been visited and there
            // exists an edge from the last node being visited to
            // the starting node
            List<Vertex> adj = node.adj_vertices;
            if (allVisited()) {
                for (Vertex vertex : adj) {
                    if (vertex == starting_node) {
                        return true;
                    }
                }
            }

            // Recursive case
            for (Vertex vertex : adj) {
                if (!vertex.visited) {
                    if (canChainWordsRec(vertex, starting_node)) {
                        return true;
                    }
                }
            }
            return false;
        }

        boolean canChainWords(int list_size) {
            // Empty list and single word cannot form a chain
            if (list_size < 2) {
                return false;
            }

            if (vertices.size() > 0) {
                if (outEqualsIn()) {
                    return canChainWordsRec(vertices.get(0), vertices.get(0));
                }
            }
            return false;
        }
    }


    // Test Program.
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("eve", "eat", "ripe", "tear"));
        Graph g = new Graph();
        g.createGraph(list);
        System.out.println(g.canChainWords(list.size()));
    }
}

