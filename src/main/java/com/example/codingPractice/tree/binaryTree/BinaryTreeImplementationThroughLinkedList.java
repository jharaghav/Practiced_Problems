package com.example.codingPractice.tree.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeImplementationThroughLinkedList {
    private TreeNode root;
    public class TreeNode{
        private TreeNode left;
        private  TreeNode right;
        private int data;

        public TreeNode(int data){
            this.data = data;
        }
    }

    public void createBinaryTree(){
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);
        root = first; //root ---> first, root is pointing to first node
        first.left = second; //   second<-------- first ------->third
        first.right = third;
        second.left = fourth;
        second.right = fifth;

    }

    private void printBinaryTree(){
        TreeNode currentNode = root;
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null)queue.offer(currentNode);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
            System.out.print(node.data+" -->");
        }
    }

    public static void main(String... s){
            BinaryTreeImplementationThroughLinkedList binaryTree = new BinaryTreeImplementationThroughLinkedList();
            binaryTree.createBinaryTree();
            binaryTree.printBinaryTree();
    }
}
