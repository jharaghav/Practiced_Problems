package com.example.codingPractice.tree.binaryTree;

/**
 * Algorithm Preorder(tree)
 *    1. Visit the root.
 *    2. Traverse the left subtree, i.e., call Preorder(left-subtree)
 *    3. Traverse the right subtree, i.e., call Preorder(right-subtree)
 */
public class PreOrederTraversalViaRecurssion {

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
        PreOrederTraversalViaRecurssion binaryTree = new PreOrederTraversalViaRecurssion();
        binaryTree.createBinaryTree();
        binaryTree.printBinaryTree();
    }
    public void createBinaryTree(){
        TreeNode first = new TreeNode(10);
        TreeNode second = new TreeNode(23);
        TreeNode third = new TreeNode (11);
        TreeNode fourth = new TreeNode(16);
        TreeNode fifth = new TreeNode(20);

        root= first;
        first.left= second;
        first.right = third;
        second.left = fourth;
        third.left = fifth;
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
