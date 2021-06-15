package theory.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectNodesAtSameLevel {
    static class Node{
        int val;
        Node rightNode;
        Node leftNode;
        Node next;

        Node(int val){
            this.val = val;
        }
    }

    //time complexity -> O(n)
    //space complexity -> O(n)
    public static void loadNextNode(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty() && queue.peek()!=null){
            int size = queue.size();
            for(int i=0; i<size; i++){
                Node tmp = queue.poll();
                if(queue.peek() == null){
                    tmp.next = null;
                    queue.poll();
                    i++;
                }
                else{
                    tmp.next = queue.peek();
                }
                System.out.print(tmp.val + " , ");
                if(tmp.leftNode!=null){
                    queue.add(tmp.leftNode);
                }
                if(tmp.rightNode!=null){
                    queue.add(tmp.rightNode);
                }
            }
            queue.add(null);
        }
    }


    //optimized solution , only requires O(1) space
    public static void addNextNode(Node root){
        Node leftMost = root;
        while(leftMost!=null && leftMost.leftNode!=null){
            loadNode(leftMost);
            leftMost = leftMost.leftNode;
        }
    }

    private static void loadNode(Node node){
        Node tmp = node;
        while(tmp!=null){
            tmp.leftNode.next = tmp.rightNode;
            if(tmp.next!=null){
                tmp.rightNode.next = tmp.next.leftNode;
            }
            tmp = tmp.next;
        }
    }

    public static void main(String[] args){
        Node root = new Node(10);
        root.rightNode = new Node(8);
        root.leftNode = new Node(7);
        root.rightNode.rightNode = new Node(6);
        root.rightNode.leftNode = new Node(5);
        root.leftNode.rightNode = new Node(4);
        root.leftNode.leftNode = new Node(3);
        //loadNextNode(root);
        addNextNode(root);

        System.out.println(root);
    }
}
