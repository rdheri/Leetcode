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
    public List<Integer> rightSideView(TreeNode root) {

        if(root == null) return new ArrayList<Integer>();

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        queue.add(root);

        while(!queue.isEmpty()) {
            int currentNumber = queue.size();
            int last = 0;
            for(int i = 0; i < currentNumber; i++) {
                TreeNode node = queue.remove();
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);

                last = node.val;
            }
            res.add(last);
        }
        return res;
    }
}
