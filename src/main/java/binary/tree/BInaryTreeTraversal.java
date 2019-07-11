package binary.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BInaryTreeTraversal {

    //level-order search
    public static void BFS(Node root){
        if(root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node tmp = queue.poll();
            System.out.print(tmp.data + " -> ");
            if(tmp.left!=null){
                queue.add(tmp.left);
            }
            if(tmp.right!=null){
                queue.add(tmp.right);
            }
        }

    }

    //recursive solution
    public static void preOrderTraversal(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data + "->");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static void inorderItr(Node root){
        Stack<Node> stack = new Stack<Node>();
        Node node = root;
        while(true){
            if(node != null){
                stack.add(node);
                node = node.left;
            }
            else{
                if(stack.isEmpty()){
                    break;
                }
                node = stack.pop();
                System.out.print(node.data + " ");
                node = node.right;
            }
        }
    }

    public static void preOrderItr(Node root){
        Stack<Node> stack = new Stack<Node>();
        stack.add(root);
        while(!stack.isEmpty()){
            root = stack.pop();
            System.out.print(root.data + " ");
            if(root.right != null){
                stack.add(root.right);
            }
            if(root.left!= null){
                stack.add(root.left);
            }
        }
    }

    public static void postOrderItr(Node root){
        Stack<Node> stack1 = new Stack<Node>();
        Stack<Node> stack2 = new Stack<Node>();
        stack1.add(root);
        while(!stack1.isEmpty()){
            root = stack1.pop();
            if(root.left != null){
                stack1.add(root.left);
            }
            if(root.right != null){
                stack1.add(root.right);
            }
            stack2.add(root);
        }
        while(!stack2.isEmpty()){
            System.out.print(stack2.pop().data + " ");
        }
    }


    public static void spiralTraverse(Node root){
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.add(root);
        Node current;

        while(!s1.empty() || !s2.isEmpty()){

            while(!s1.empty()) {
                current = s1.pop();
                if(current.left!=null) {
                    s2.add(current.left);
                }
                if(current.right!=null) {
                    s2.add(current.right);
                }
                System.out.print(current.data + "->");
            }

            while(!s2.empty()) {
                current = s2.pop();
                if(current.right!=null) {
                    s1.add(current.right);
                }
                if(current.left!=null) {
                    s1.add(current.left);
                }
                System.out.print(current.data + "->");
            }
        }
    }



    public static void main(String[] args) {
        Node a = new Node(5);
        Node b = new Node(3);
        Node c = new Node(8);
        Node d = new Node(4);
        Node e = new Node(1);
        Node f = new Node(6);
        Node g = new Node(9);
        Node h = new Node(2);
        Node i = new Node(7);

        a.right = c;
        a.left = b;
        c.right = g;
        c.left = f;
        f.right = i;
        b.right = d;
        b.left = e;
        e.right = h;

        BFS(a);
        System.out.println();
        preOrderTraversal(a);
        System.out.println();
        preOrderItr(a);
        System.out.println();
        inorderItr(a);
        System.out.println();
        postOrderItr(a);
    }

    static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data=data;
        }
    }

}

