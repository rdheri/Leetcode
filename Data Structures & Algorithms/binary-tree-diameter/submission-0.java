class Solution {
    private int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxHeight(root);
        return diameter;
        }

    public int maxHeight(TreeNode root) {
        if(root == null) return 0;
        else {
            int leftHeight = maxHeight(root.left);
            int rightHeight = maxHeight(root.right);

            diameter = Math.max(diameter, leftHeight+rightHeight);

            return 1 + Math.max(leftHeight, rightHeight);
        }
    }
}
