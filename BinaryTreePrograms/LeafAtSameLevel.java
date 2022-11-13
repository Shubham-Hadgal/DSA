/*
 * Given a Binary Tree, check if all leaves are at same level or not.

    Example 1:

    Input: 
                1
              /   \
             2     3

    Output: 1

    Explanation: 
    Leaves 2 and 3 are at same level.

    Example 2:

    Input:
                10
              /    \
            20      30
           /  \        
         10    15

    Output: 0

    Explanation:
    Leaves 10, 15 and 30 are not at same level.
 */

import java.util.*;
public class LeafAtSameLevel {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int arr[] = {10,20,30,10,15,-1,-1};

        tree.buildFromLevelOrder(arr);

        boolean ans = check(tree.getRoot());
        System.out.println(ans);
    }

    private static boolean check(BNode root) {
        Queue<BNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);

        while(!q.isEmpty()) {
            BNode temp = q.poll();

            if(temp == null) {
                q.offer(null);
            } else {
                if(temp.left == null  && temp.right == null) {
                    
                } else {
                    if(temp.left != null) {
                        q.offer(temp.left);
                    }
                    if(temp.right != null) {
                        q.offer((temp.right));
                    }
                }
            }
        }
        return false;
    }
}
