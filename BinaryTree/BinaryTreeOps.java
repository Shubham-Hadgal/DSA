/*
    ! InOrder -> LNR
    ! PreOrder -> NLR
    ! PostOrder -> LRN
 */

import java.util.*;

// ip: 10 20 6 -1 -1 2 -1 -1 5 11 -1 -1 -1

// Binary Tree Node BluePrint
class BNode {
    int data;
    BNode left;
    BNode right;

    BNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class BinaryTreeOps {
    
    private static  Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        BNode root = buildTree(null);

        // levelOrderTraversal(root);

        // reverseLevelOrderTraversal(root);

        inOrder(root);
        System.out.println();
        preOrder(root);
        System.out.println();
        postOrder(root);
    }

    // InOrder Traversal
    public static void inOrder(BNode root) {

        if(root == null) return;

        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    // PreOrder Traversal
    public static void preOrder(BNode root) {
        if(root == null) return;

        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // PostOrder Traversal
    public static void postOrder(BNode root) {
        if(root == null) return;

        postOrder(root.right);
        postOrder(root.left);
        System.out.print(root.data+" ");
    }

    // reverse level order tarversal
    public static void reverseLevelOrderTraversal(BNode root) {

        if(root == null) return;

        Queue<BNode> q = new LinkedList<>();
        Stack<BNode> st = new Stack<>();

        q.offer(root);
        q.offer(null);

        st.push(root);
        st.push(null);

        while(!q.isEmpty()) {
            BNode temp = q.poll();

            if(temp == null) {
                if(!q.isEmpty()) {
                    q.offer(null);
                    st.push(null);
                }
            } else {
                // first put right node as we pop from stack we will get left most node first
                if(temp.right != null) {
                    q.offer(temp.right);
                    st.push(temp.right);
                }
                if(temp.left != null) {
                    q.offer(temp.left);
                    st.push(temp.left);
                }
            }
        }

        while(!st.isEmpty()) {
            BNode nd = st.pop();
            if(nd == null) {
                System.out.println();
            } else {
                System.out.print(nd.data+" ");
            }
        }

    }

    // level order traversal for binary tree also known as BFS
    public static void levelOrderTraversal(BNode root) {
        if(root == null) return;

        Queue<BNode> q = new LinkedList<>();

        q.offer(root);
        q.offer(null);

        while(!q.isEmpty()) {
            BNode temp = q.poll();

            if(temp == null) {
                System.out.println();
                if(!q.isEmpty()) {
                    q.offer(null);
                }
                
            } else {
                System.out.print(temp.data+" ");
                if(temp.left != null) {
                    q.offer(temp.left);
                }
                if(temp.right != null) {
                    q.offer(temp.right);
                }
            }
        }
    }

    public static BNode buildTree(BNode root) {

        System.out.println("Enter data");
        int x = sc.nextInt();

        root = new BNode(x);

        if(x == -1) {
            return null;
        }

        System.out.println("Enter the left data for "+x);
        BNode leftTree = buildTree(root.left);
        System.out.println("Enter the right data for "+x);
        BNode rightTree = buildTree(root.right);

        root.left = leftTree;
        root.right = rightTree;

        return root;
    }
}