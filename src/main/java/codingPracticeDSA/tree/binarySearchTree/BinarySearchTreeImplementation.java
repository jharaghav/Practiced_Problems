package codingPracticeDSA.tree.binarySearchTree;

import codingPracticeDSA.tree.binaryTree.BinaryTreeImplementationThroughLinkedList;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTreeImplementation {
    private TreeNode root;
    private class TreeNode{
        private TreeNode left;
        private TreeNode right;
        private int data;

        public TreeNode(int data){
            this.data = data;
        }
    }
    public void createBinaryTree(){
        TreeNode first = new TreeNode(10);
        TreeNode second = new TreeNode(5);
        TreeNode third = new TreeNode(15);
        TreeNode fourth = new TreeNode(2);
        TreeNode fifth = new TreeNode(9);
        TreeNode sixth = new TreeNode(13);
        TreeNode seventh = new TreeNode(11);

        root = first;

        first.left = second;
        first.right = third;
        second.left = fourth;
        second.right = fifth;
        third.left = sixth;
        third.right = seventh;

    }

    private void printBinarySearchTree(){
        BinarySearchTreeImplementation.TreeNode currentNode = root;
        Queue<BinarySearchTreeImplementation.TreeNode> queue = new LinkedList<>();
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

    /**
     * Insertion in BST via Iterative way
     * @param data
     */
    private void insertInBST(int data){
        TreeNode newNode = new TreeNode(data);
        TreeNode currentNode = root;
        if(root == null){
            root = newNode;
        }
        while(currentNode.left != null || currentNode.right != null){
            if(data < currentNode.data){
                if(currentNode.left == null){
                    break;
                }
                currentNode = currentNode.left;
            }
            if(data > currentNode.data){
                if(currentNode.right == null){
                    break;
                }
                currentNode = currentNode.right;
            }
        }
        if(data > currentNode.data) currentNode.right = newNode;
        if(data < currentNode.data) currentNode.left = newNode;
    }

    /**
     * Insertion in BST via Recurssive way
     * @param root
     * @param value
     * @return
     */
    private TreeNode insertionViaRecurssion(TreeNode root,int value){
        if(root == null){
            root = new TreeNode(value);
            return root;
        }
        if(value < root.data){
            root.left = insertionViaRecurssion(root.left,value);
        }else{
            root.right = insertionViaRecurssion(root.right,value);
        }
        return root;
    }

    private boolean searchParticularKey(TreeNode root,int value){
        if(root == null) return false;
        if(root.data == value) return true;
        if(value < root.data){
            return searchParticularKey(root.left,value);
        }else{
            return searchParticularKey(root.right,value);
        }
    }

    /**
     * Here traversing the Binary Search Tree One by one node through the Queue(Level Order Traversal)
     * After that checking it Lowest Part (It should be smaller than the current value)
     * And checking the Highest Part(It should be larger than the current value)
     * @return
     */
    private boolean checkValidBST(){
        TreeNode currentNode = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(currentNode);
        boolean checkLowestValid = true;
        boolean checkHighestValid = true;
        while(!queue.isEmpty()){
            currentNode = queue.poll();
            checkLowestValid = checkLowestBST(currentNode.left,currentNode.data);
            checkHighestValid = checkHighestBST(currentNode.right,currentNode.data);
            if(!checkLowestValid) return false;
            if(!checkHighestValid) return false;
            if(currentNode.right != null){
                queue.offer(currentNode.right);
            }
            if(currentNode.left != null){
                queue.offer(currentNode.left);
            }
        }
        return (checkLowestValid && checkHighestValid);
    }

    /**
     * checking the lowest part in recurssive way to find if all the node elements should be smaller or not
     * if not then return false
     * @param root
     * @param value
     * @return
     */
    private boolean checkLowestBST(TreeNode root,int value){
        if(root == null) return true;
        if(value < root.data) return false;
        if(root.left != null)
            return checkLowestBST(root.left,value);
        if(root.right != null)
            return checkLowestBST(root.right,value);
        return true;
    }

    /**
     *  checking the highest part in recurssive way to find if all the node elements should be higher or not
     *  if not then return false
     * @param root
     * @param value
     * @return
     */
    private boolean checkHighestBST(TreeNode root,int value){
        if(root == null) return true;
        if(value > root.data) return false;
        if( root.left != null)
            return checkHighestBST(root.left,value);
        if(root.right != null)
            return checkHighestBST(root.right,value);
        return true;
    }

    /**
     * https://www.youtube.com/watch?v=ACoLBU0nPAw&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=114
     * @param root
     * @param min
     * @param max
     * @return
     */
    private boolean isValid(TreeNode root,long min,long max){
        if(root == null) return true;
        if(min >= root.data || max <= root.data) return false;
        boolean left = isValid(root.left,min,root.data);
        if(left){
            boolean right = isValid(root.right,root.data,max);
            return right;
        }
        return false;
    }

    public static void main(String... s){
        BinarySearchTreeImplementation binaryTree = new BinarySearchTreeImplementation();
        binaryTree.createBinaryTree();
        binaryTree.insertInBST(4);
        binaryTree.insertionViaRecurssion(binaryTree.root,14);
        System.out.println("Key Exists : "+binaryTree.searchParticularKey(binaryTree.root,14));

        //System.out.println("IsValid BST : "+binaryTree.checkValidBST());
        System.out.println("IsValid BST : "+binaryTree.isValid(binaryTree.root,Integer.MIN_VALUE,Integer.MAX_VALUE));
        //binaryTree.printBinarySearchTree();
    }
}
