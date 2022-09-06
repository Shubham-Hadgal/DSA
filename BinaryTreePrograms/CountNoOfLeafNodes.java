public class CountNoOfLeafNodes {
    public static void main(String[] args) {

        // creating tree by level order traversal
        BinaryTree tree = new BinaryTree();
        int arr[] = {12,10,20,5,8,6,-1,-1,-19,-1,-1,-1};
        tree.buildFromLevelOrder(arr);

        // getting no.of leaf nodes
        int count = countNumberOfLeafNodes(tree.getRoot());

        System.out.println(count);
        
    }

    // method to get no of leaf nodes
    private static int countNumberOfLeafNodes(BNode root) {

        // if root node has no child return 1
        if(root.left == null && root.right == null) {
            return 1;
        }

        // count left sub tree
        int leftSubTree = 0;

        // count right sub tree
        int rightSubTree = 0;

        // faith this will return left subtree count
        if(root.left != null) {
            leftSubTree = countNumberOfLeafNodes(root.left);
        }

        // faith this will return right subtree count
        if(root.right != null) {
            rightSubTree = countNumberOfLeafNodes(root.right);
        }

        // return left + right count
        return leftSubTree+rightSubTree;
    }
}
