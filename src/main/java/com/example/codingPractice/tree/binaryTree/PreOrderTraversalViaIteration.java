package com.example.codingPractice.tree.binaryTree;

import java.util.Stack;

public class PreOrderTraversalViaIteration {

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
        PreOrderTraversalViaIteration binaryTree = new PreOrderTraversalViaIteration();
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
    //Using stack we can traverse the binary tree
    private void printBinaryTree(){
       if(root == null)return;
       Stack<TreeNode> stack = new Stack<>();

       stack.push(root);
       while(!stack.isEmpty()){
           TreeNode temp = stack.pop();
           System.out.print(temp.data+" --> ");
           if(temp.right != null){
               stack.push(temp.right);
           }
           if(temp.left != null){
               stack.push(temp.left);
           }
       }
    }
}
