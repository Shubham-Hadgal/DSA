import java.util.*;
// Implemented only for Integer

public class BinaryTree {

    // root of the binary tree
    private BNode root;

    BinaryTree() {
        root = null;
    }

    // return root of the tree;
    public BNode getRoot() {
        return root;
    }

    // InOrder Traversal
    void inOrder(BNode root) {

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
    void preOrder(BNode root) {

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
    void postOrder(BNode root) {

        // base case
        if(root == null) return;

        // left subtree 
        postOrder(root.left);
        // right subtree
        postOrder(root.right);
        // access node
        System.out.print(root.data+" ");
    }

    // ! reverse level order tarversal

    /*           
                    !INPUT
    *                  12
    *                /    \
    *              10      20
    *             /  \    /
    *            5    8  6
    *                /
    *              9 
    * 
                    !OUTPUT

    *                9
    *                5 8 6
    *                10 20
    *                12
    * 
    */

    void reverseLevelOrderTraversal() {

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
    void levelOrderTraversal() {

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

    // method to traverse in order iteratively in BTree
    void iterativeInOrder(BNode root) {

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
    void iterativePreOrder(BNode root) {
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
    void buildFromLevelOrder(int arr[]) {

        // arr = ip: 1 2 4 -1 -1 5 6 75 -1 -1 -1 78 -1 25-1 -1 3 -1 -1

        // edge cases
        if(arr.length == 0) {
            return;
        } else if(arr.length == 1) {
            this.root = new BNode(arr[0]);
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
        this.root = root;
    }
}
