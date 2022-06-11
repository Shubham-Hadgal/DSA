/*
    ! InOrder -> LNR
    ! PreOrder -> NLR
    ! PostOrder -> LRN
*/

// ! (-1 == null)

import java.util.*;

// ip: 1 2 4 -1 -1 5 6 75 -1 -1 -1 78 -1 25-1 -1 3 -1 -1

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

        // building tree from level order array.
        int arr[] = {10,20,30,-1,40,50,-1,-1,-1,-1,60,-1,80}; // elements inserted according to levels of tree i.e null == -1

        BNode root = buildFromLevelOrder(arr);

        levelOrderTraversal(root);

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

    // InOrder Traversal
    public static void inOrder(BNode root) {

        // base case
        if(root == null) return;

        // left subtree
        inOrder(root.left);
        // access node
        System.out.print(root.data+" ");
        // right subtree
        inOrder(root.right);
    }

    // PreOrder Traversal
    public static void preOrder(BNode root) {

        // base case
        if(root == null) return;

        // access node
        System.out.print(root.data+" ");
        //left subtree
        preOrder(root.left);
        // right subtree
        preOrder(root.right);
    }

    // PostOrder Traversal
    public static void postOrder(BNode root) {

        // base case
        if(root == null) return;

        // left subtree 
        postOrder(root.left);
        // right subtree
        postOrder(root.right);
        // access node
        System.out.print(root.data+" ");
    }

    // reverse level order tarversal
    public static void reverseLevelOrderTraversal(BNode root) {

        // base case or edge case
        if(root == null) return;

        Queue<BNode> q = new LinkedList<>();
        Stack<BNode> st = new Stack<>();

        // Initial element
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

        // traverse stack
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

        // edge or base case
        if(root == null) return;

        // queue for level order traversal
        // pop element and push its children into queue do this until the queue is empty
        Queue<BNode> q = new LinkedList<>();

        // initial element
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

    // ! method to build the tree
    public static BNode buildTree(BNode root) {

        // Root element
        System.out.println("Enter data");
        int x = sc.nextInt();

        root = new BNode(x);

        // -1 == null, base case
        if(x == -1) {
            return null;
        }

        // get the left of curr root
        System.out.println("Enter the left data for "+x);
        BNode leftTree = buildTree(root.left); // faith = will build left subtree
        System.out.println("Enter the right data for "+x);
        // get the right of curr root
        BNode rightTree = buildTree(root.right); // faith = will build the right subtree

        // link left and right subtrees to root node
        root.left = leftTree;
        root.right = rightTree;

        return root;
    }

    // method to traverse in order iteratively in BTree
    public static void iterativeInOrder(BNode root) {

        // base case or edge case
        if(root == null) return ;

        Stack<BNode> st = new Stack<>();
        BNode curr = root;
        
        while(curr != null || st.size() > 0) {

            while(curr != null) {
                st.push(curr);
                curr = curr.left;
            }

            curr = st.pop();

            System.out.print(curr.data+" ");

            curr = curr.right;
        }
    }

    // method to traverse Pre order iteratively in BTree
    public static void iterativePreOrder(BNode root) {
        if(root == null) return;
        
        BNode curr = root;
        Stack<BNode> st = new Stack<>();

        while(curr != null || st.size() > 0) {

            while(curr != null) {
                System.out.print(curr.data+" ");
                if(curr.right != null) {
                    st.push(curr.right);
                }
                curr = curr.left;
            }

            if (!st.isEmpty())
            {
                curr = st.pop();
            }
        }
    }

    // ! method to build tree from Level order array
    public static BNode buildFromLevelOrder(int arr[]) {

        // edge cases
        if(arr.length == 0) {
            return null;
        } else if(arr.length == 1) {
            return new BNode(arr[0]);
        }

        Queue<BNode> q = new LinkedList<>();
        BNode root = new BNode(arr[0]);
        
        // initial element arr[0]
        q.offer(root);
        
        // array ptr from arr[1] beacuse we already accessed arr[0]
        int i = 1;

        while(!q.isEmpty() && i < arr.length) {
            BNode node = q.poll();

            // if it has node
            if(arr[i] != -1) {
                node.left = new BNode(arr[i]);
                q.offer(node.left);
            } else { // if its null
                node.left = null;
            }

            // inc array ptr
            i++;

            // if it has node
            if(i < arr.length && arr[i] != -1) {
                node.right = new BNode(arr[i]);
                q.offer(node.right);
            } else { // if its null
                node.right = null;
            }

            // inc array ptr
            i++;
        }
        return root;
    }

}