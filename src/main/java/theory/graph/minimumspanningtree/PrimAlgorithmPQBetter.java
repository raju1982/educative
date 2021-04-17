package theory.graph.minimumspanningtree;

import java.io.Serializable;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;


public class PrimAlgorithmPQBetter {

    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class ResultSet {
        int parent;
        int weight;
    }

    static class Pair {
        private int weight;
        private int vertex;
        public Pair(int weight,  int vertex) {
            this.weight = weight;
            this.vertex = vertex;
        }
    }

    static class Graph {
        int vertices;
        LinkedList<Edge>[] adjacencyList;

        Graph(int vertices) {
            this.vertices = vertices;
            adjacencyList = new LinkedList[vertices];
            //initialize adjacency lists for all the vertices
            for (int i = 0; i <vertices ; i++) {
                adjacencyList[i] = new LinkedList<>();
            }
        }

        //for undirected graph
        public void addEgde(int source, int destination, int weight) {
            Edge edge = new Edge(source, destination, weight);
            adjacencyList[source].addFirst(edge);

            edge = new Edge(destination, source, weight);
            adjacencyList[destination].addFirst(edge);
        }

        public void primMST(){

            boolean[] mst = new boolean[vertices];
            ResultSet[] resultSet = new ResultSet[vertices];
            int [] key = new int[vertices];  //keys used to store the key to know whether priority queue update is required

            //Initialize all the keys to infinity and
            //initialize resultSet for all the vertices
            for (int i = 0; i <vertices ; i++) {
                key[i] = Integer.MAX_VALUE;
                resultSet[i] = new ResultSet();
            }

            //Initialize priority queue
            //override the comparator to do the sorting based keys
            PriorityQueue<Pair> pq = new PriorityQueue<>(vertices, (p1, p2) -> {
                //sort using key values
                int key1 = p1.weight;
                int key2 = p2.weight;
                return key1-key2;
            });

            //create the pair for for the first index, 0 key 0 index
            key[0] = 0;
            Pair p0 = new Pair(key[0],0);
            //add it to pq
            pq.offer(p0);

            resultSet[0] = new ResultSet();
            resultSet[0].parent = -1;

            //while priority queue is not empty
            while(!pq.isEmpty()){
                //extract the min
                Pair extractedPair = pq.poll();

                //extracted vertex
                int extractedVertex = extractedPair.vertex;
                mst[extractedVertex] = true;

                //iterate through all the adjacent vertices and update the keys
                LinkedList<Edge> list = adjacencyList[extractedVertex];
                for (int i = 0; i <list.size() ; i++) {
                    Edge edge = list.get(i);
                    //only if edge destination is not present in mst
                    if(!mst[edge.destination]) {
                        int destination = edge.destination;
                        int newKey = edge.weight;
                        //check if updated key < existing key, if yes, update if
                        if(key[destination]>newKey) {
                            //add it to the priority queue
                            Pair p = new Pair(newKey, destination);
                            pq.offer(p);
                            //update the resultSet for destination vertex
                            resultSet[destination].parent = extractedVertex;
                            resultSet[destination].weight = newKey;
                            //update the key[]
                            key[destination] = newKey;
                        }
                    }
                }
            }
            //print mst
            printMST(resultSet);
        }

        public void printMST(ResultSet[] resultSet){
            int total_min_weight = 0;
            System.out.println("Minimum Spanning Tree: ");
            for (int i = 1; i <vertices ; i++) {
                System.out.println("Edge: " + i + " - " + resultSet[i].parent + " key: " + resultSet[i].weight);
                total_min_weight += resultSet[i].weight;
            }
            System.out.println("Total minimum key: " + total_min_weight);
        }

        public static void main(String[] args) {
            int vertices = 6;
            Graph graph = new Graph(vertices);
            graph.addEgde(0, 1, 4);
            graph.addEgde(0, 2, 3);
            graph.addEgde(1, 2, 1);
            graph.addEgde(1, 3, 2);
            graph.addEgde(2, 3, 4);
            graph.addEgde(3, 4, 2);
            graph.addEgde(4, 5, 6);
            graph.primMST();
        }
    }
}



