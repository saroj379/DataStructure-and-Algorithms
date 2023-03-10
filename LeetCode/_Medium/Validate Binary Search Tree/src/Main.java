/**
 * Definition for a binary tree node.
 */

 class TreeNode {
    int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
         this.right = right;
     }
 }

class Solution {
    int maxValue(TreeNode root){
        if(root == null) return Integer.MIN_VALUE;

        int value = root.val;
        int l_max = maxValue(root.left);
        int r_max = maxValue(root.right);

        return Math.max(value, Math.max(l_max, r_max));
    }

    int minValue(TreeNode root){
        if(root == null) return Integer.MAX_VALUE;

        int value = root.val;
        int l_max = minValue(root.left);
        int r_max = minValue(root.right);

        return Math.min(value, Math.min(l_max, r_max));
    }

    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        // if left sub tree has greater value of node
        if(root.left != null && maxValue(root.left) >= root.val) return false;

        // if right sub tree has less value of node
        if(root.right != null && minValue(root.right) <= root.val) return false;

        // check for less value on left
        boolean isLBST = isValidBST(root.left);
        // check for big value on right
        boolean isRBST = isValidBST(root.right);

        return (isLBST && isRBST);
    }
}