package codingPracticeDSA.tree.binaryTree.levelOrderTraversal;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    private TreeNode root;

    class TreeNode{
        private TreeNode left;
        private TreeNode right;
        private int data;

        public TreeNode(int data){
            this.data = data;
        }
    }

    public static void main(String... s){
        LevelOrderTraversal binaryTree = new LevelOrderTraversal();
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

    /**
     * Level Order Traversal via Queue
     */
    public void printBinaryTree(){
        TreeNode current = root;
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null) queue.offer(current);
        while(!queue.isEmpty()){
            current = queue.poll();
            System.out.print(current.data+" --> ");
            if(current.left != null){
                queue.offer(current.left);
            }
            if(current.right !=null){
                queue.offer(current.right);
            }
        }

    }
}
