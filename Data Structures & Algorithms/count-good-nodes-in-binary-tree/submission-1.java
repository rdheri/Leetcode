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
    int max = Integer.MIN_VALUE;
    int count = 1;


    public int goodNodes(TreeNode root) {
        return dfs(root, max);
    }
    private int dfs(TreeNode root, int max) {
        if(root == null) return count;
        if(root.val > max) max = root.val;
        if(root.left != null && root.left.val >= max) {
            count++;
        }
        if(root.right != null && root.right.val >= max) {
            count++;
        }
        dfs(root.left, max);
        dfs(root.right, max);
        return count;
    }
}
