package binary.tree;

/*
An Efficient Solution can construct balanced BST in O(n) time with minimum possible height. Below are steps.

Traverse given BST in inorder and store result in an array. This step takes O(n) time. Note that this array would be sorted as inorder traversal of BST always produces sorted sequence.
Build a balanced BST from the above created sorted array using the recursive approach discussed here. This step also takes O(n) time as we traverse every element exactly once and processing an element takes O(1) time.
 */
public class ConvertNormalBSTtoBalancedBST {
}
