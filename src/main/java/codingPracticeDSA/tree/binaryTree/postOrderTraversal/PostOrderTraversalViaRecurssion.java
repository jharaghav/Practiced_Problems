package codingPracticeDSA.tree.binaryTree.postOrderTraversal;

/**
 * Algorithm Postorder(tree)
 *    1. Traverse the left subtree, i.e., call Postorder(left-subtree)
 *    3. Traverse the right subtree, i.e., call Postorder(right-subtree)
 *    1. Visit the root.
 */
public class PostOrderTraversalViaRecurssion {

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
        PostOrderTraversalViaRecurssion binaryTree = new PostOrderTraversalViaRecurssion();
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
        postOrderTraversal(root);
    }

    private void postOrderTraversal(TreeNode root){
        TreeNode temp = root;
        if(root == null)return;
        postOrderTraversal(temp.left);
        postOrderTraversal(temp.right);
        System.out.print(temp.data+" --> ");
    }
}
