/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private int difference = 0;
    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return (difference <= 1);
    }

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        else {
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            difference = Math.max(difference, Math.abs(rightDepth - leftDepth));
            return 1 + Math.max(leftDepth, rightDepth);
        }
    }
}
