package codingPracticeDSA.tree.binaryTree.postOrderTraversal;

import java.util.Stack;

public class PostOrderTraversalViaIteration {

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
        PostOrderTraversalViaIteration binaryTree = new PostOrderTraversalViaIteration();
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
    //Using stack we can traverse the binary tree in iterative way
    private void printBinaryTree(){
       if(root == null)return;
       Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while(current!=null || !stack.isEmpty()){
            if(current != null){
                stack.push(current);
                current = current.left;
            }else{
                TreeNode temp = stack.peek().right;
                if(temp == null){
                    temp = stack.pop();
                    System.out.print(temp.data+" --> ");
                    while(!stack.isEmpty() && temp == stack.peek().right){
                        temp = stack.pop();
                        System.out.print(temp.data+" ---> ");
                    }
                }else{
                    current = temp;
                }
            }
        }
    }
}
