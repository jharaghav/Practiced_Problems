package com.example.codingPractice.tree.binaryTree.inOrderTraversal;

/**
 * Algorithm Inorder(tree)
 *    1. Traverse the left subtree, i.e., call Inorder(left-subtree)
 *    2. Visit the root.
 *    3. Traverse the right subtree, i.e., call Inorder(right-subtree)
 */
public class InOrderTraversalViaRecurssion {

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
        InOrderTraversalViaRecurssion binaryTree = new InOrderTraversalViaRecurssion();
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
        inOrderTraversal(root);
    }

    private void inOrderTraversal(TreeNode root){
        TreeNode temp = root;
        if(temp == null)return;
        inOrderTraversal(temp.left);
        System.out.print(temp.data+" --> ");
        inOrderTraversal(temp.right);
    }
}
