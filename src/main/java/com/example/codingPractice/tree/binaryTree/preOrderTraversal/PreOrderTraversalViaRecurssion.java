package com.example.codingPractice.tree.binaryTree.preOrderTraversal;

/**
 * Algorithm Preorder(tree)
 *    1. Visit the root.
 *    2. Traverse the left subtree, i.e., call Preorder(left-subtree)
 *    3. Traverse the right subtree, i.e., call Preorder(right-subtree)
 */
public class PreOrderTraversalViaRecurssion {

    private TreeNode root;

    private class TreeNode{
        private TreeNode left;
        private TreeNode right;
        private int data;

        public TreeNode(int data){
            this.data = data;
        }
    }

    public static void main(String... s){
        PreOrderTraversalViaRecurssion binaryTree = new PreOrderTraversalViaRecurssion();
        binaryTree.createBinaryTree();
        binaryTree.printBinaryTree();
    }
    public void createBinaryTree(){
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode (3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);

        root= first;
        first.left= second;
        first.right = third;
        second.left = fourth;
        second.right = fifth;
    }
    private void printBinaryTree(){
        preOrderTraversal(root);
    }

    private void preOrderTraversal(TreeNode root){
        TreeNode temp = root;
        if(root == null)return;
        System.out.print(temp.data+" --> ");
        preOrderTraversal(temp.left);
        preOrderTraversal(temp.right);
    }
}
