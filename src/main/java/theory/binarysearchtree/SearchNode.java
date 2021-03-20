package theory.binarysearchtree;

import theory.binarytree.Node;

public class SearchNode {

    public static void main(String[] args){
        Node node = InsertNode.iterativeInsert(null, 10);
        InsertNode.iterativeInsert(node, 5);
        InsertNode.iterativeInsert(node, 15);
        InsertNode.iterativeInsert(node, 12);
        InsertNode.iterativeInsert(node, 18);
        InsertNode.preOrderTraversal(node);

        System.out.println();
        System.out.println(recursiveSearch(node, 12));
        System.out.println(recursiveSearch(node, 20));

        System.out.println(iterativeSearch(node, 12));
        System.out.println(iterativeSearch(node, 20));
    }

    //time complexity -> O(h), where h is the height of binary search tree.
    //auxiliary space -> recursive implementation needs O(h)
    public static boolean recursiveSearch(Node node, int searchValue){
        if(node == null){
            return false;
        }
        if(node.getData() == searchValue){
            return true;
        }
        else if(node.getData()>searchValue){
            return recursiveSearch(node.getLeftNode(), searchValue);
        }
        else{
            return recursiveSearch(node.getRightNode(), searchValue);
        }
    }

    //time complexity -> O(h), where h is the height of binary search tree.
    //auxiliary space -> Iterative implementation is 0(1) it does not require auxiliary space.
    public static boolean iterativeSearch(Node node, int searchValue){
            while(node!=null){
                if(node.getData()==searchValue){
                    return true;
                }
                else if (node.getData()>searchValue){
                    node = node.getLeftNode();
                }
                else{
                    node = node.getRightNode();
                }
            }
        return false;
    }

}
