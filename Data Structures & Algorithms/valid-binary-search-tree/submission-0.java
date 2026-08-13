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
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }     
        else if (root.left == null && root.right == null) return true;
        else if (root.left == null || root.right == null) return true;
        else {
            int left = root.left.val;
            int right = root.right.val;
            if(left < root.val && right > root.val) {
                return isValidBST(root.left) && isValidBST(root.right);
            }
            else return false;
        }
    }
}
