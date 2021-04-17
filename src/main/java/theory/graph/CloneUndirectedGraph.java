package theory.graph;

import java.util.*;

public class CloneUndirectedGraph {

    public static Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        Map<Integer, Node> map = new HashMap<>();

        queue.add(node);
        Node nodeToReturn = new Node(node.label);
        map.put(nodeToReturn.label, nodeToReturn);
        Node neighborNodeCopy;

        while (!queue.isEmpty()) {
            Node tmp = queue.poll();
            for (Node neighbor : tmp.neighbors) {
                if (map.containsKey(neighbor.label)) {
                    //Add this to the neighbor list
                    map.get(tmp.label).neighbors.add(map.get(neighbor.label));
                } else {
                    queue.add(neighbor);
                    neighborNodeCopy = new Node(neighbor.label);
                    map.put(neighbor.label, neighborNodeCopy);
                    //Add this to the neighbor list
                    map.get(tmp.label).neighbors.add(neighborNodeCopy);
                }
            }
        }
        return nodeToReturn;
    }


    public static void bfs(Node startNode) {
        Set<Node> visited = new HashSet<>();
        visited.add(startNode);

        Queue<Node> queue = new LinkedList<>();
        queue.add(startNode);

        while (!queue.isEmpty()) {
            Node tmp = queue.poll();
            System.out.print(tmp.label + "\t");
            for (Node i : tmp.neighbors) {
                if (!visited.contains(i)) {
                    queue.add(i);
                    visited.add(i);
                }
            }
        }
    }


    /*
                Note : All the edges are Undirected
                Given Graph:
                1--2
                |  |
                4--3
            */
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        //node 1 has edge to 2 and 4
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        //node 2 has edge to 1 and 3
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        //node 3 has edge to 4 and 2
        node3.neighbors.add(node4);
        node3.neighbors.add(node2);
        //node 4 has edge to 4 and 2
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        bfs(node1);
        System.out.println();
        Node newNode = cloneGraph(node1);
        bfs(newNode);
    }
}




//DFS solution

/*
    private static Node clone_rec(Node root, HashMap<Node, Node> nodes_completed) {
        if (root == null) {
            return null;
        }

        Node pNew = new Node(root.data);
        nodes_completed.put(root, pNew);

        for (Node p : root.neighbors) {
            Node x = nodes_completed.get(p);
            if (x == null){
                pNew.neighbors.add(clone_rec(p, nodes_completed));
            } else {
                pNew.neighbors.add(x);
            }
        }
        return pNew;
    }

    public static Node clone(Node root) {
        HashMap<Node, Node> nodes_completed = new HashMap<Node, Node>();
        return clone_rec(root, nodes_completed);
    }
*/
    /*
    public static void main(String[] args) {
        ArrayList<Node> vertices = CloneGraph.createTestGraphDirected(7, 18);

        CloneGraph.printGraph(vertices.get(0));

        Node cp = clone(vertices.get(0));
        System.out.println();
        System.out.println("After copy.");
        CloneGraph.printGraph(cp);

        HashSet<Node> set = new HashSet<Node>();
        System.out.println(CloneGraph.are_graphs_equal_rec(vertices.get(0), cp, set));
    }
*/
