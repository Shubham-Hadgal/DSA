public class HeightOfBinaryTree {
    public static void main(String[] args) {

        // building binary tree
        BinaryTree tree = new BinaryTree();
        int arr[] = {20,10,30,-1,78,-1,89,-1,-1,-1,4,-1,78,56,32};
        tree.buildFromLevelOrder(arr);

        // getting height of binary tree
        int height = heightOfBinaryTree(tree.getRoot());

        System.out.println(height);
    }

    // method to get height of binary tree
    private static int heightOfBinaryTree(BNode root) {
        // base case
        if(root == null) {
            return 0;
        }


        // get height of left subtree
        int ls = heightOfBinaryTree(root.left);

        // get height of right subtree
        int rs = heightOfBinaryTree(root.right);


        //return root node + max of left subtree and right subtree
        return 1 + Math.max(ls, rs);
    }
}
