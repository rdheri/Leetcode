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
        height(root);
        if(difference > 1) return false;
        else return true;
    }
    public int height(TreeNode root) {
        if(root == null) return 0;
        else {
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);

            difference = Math.max(difference, Math.abs(rightHeight-leftHeight));

            return 1 + Math.max(leftHeight, rightHeight);
        }
    }
}
