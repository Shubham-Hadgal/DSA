/*
    ! InOrder -> LNR
    ! PreOrder -> NLR
    ! PostOrder -> LRN
*/

// ! (-1 == null)

public class BinaryTreeOps {
    public static void main(String[] args) {

        // building tree from level order array.
        int arr[] = {10,20,30,-1,40,50,-1,-1,-1,-1,60,-1,80}; // elements inserted according to levels of tree i.e null == -1

        BinaryTree bTree = new BinaryTree();

        bTree.buildFromLevelOrder(arr);

        // bTree.root = new BNode(10);
        // bTree.root.left = new BNode(20);
        // bTree.root.right = new BNode(30);
        // bTree.root.left.left = new BNode(60);
        // bTree.root.left.left.right = new BNode(90);

        bTree.levelOrderTraversal(bTree.getRoot());

        // reverseLevelOrderTraversal(root);

        // inOrder(root);
        // System.out.println();
        // iterativeInOrder(root);
        // System.out.println();
        // preOrder(root);
        // System.out.println();
        // iterativePreOrder(root);
        // System.out.println();
    }

}