package codingPracticeDSA.tree.binaryTree;

public class MaximumValue {
    private TreeNode root;

    public class TreeNode{
        private TreeNode left;
        private TreeNode right;
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

    public int findMaxValueInBinaryTree(){
        return maxValueThroughRecurssion(root);
    }

    public int maxValueThroughRecurssion(TreeNode root){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        int result = root.data;
        int left = maxValueThroughRecurssion(root.left);
        int right = maxValueThroughRecurssion(root.right);
        if(left > result) result = left;
        if(right > result) result = right;
        return result;
    }

    public static void main(String... s){
        MaximumValue binaryTree = new MaximumValue();
        binaryTree.createBinaryTree();

        System.out.println("Maximum value is "+binaryTree.findMaxValueInBinaryTree());
    }
}
