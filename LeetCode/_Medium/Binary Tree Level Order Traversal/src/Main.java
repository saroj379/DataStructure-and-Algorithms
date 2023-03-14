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

import java.util.*;
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
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();
        // base case
        if(root == null) return list;

        Queue<TreeNode> qu = new ArrayDeque<>();
        qu.add(root);

        while(qu.size() > 0){

            int size = qu.size();
            List<Integer> li = new ArrayList<>();

            while(size-- > 0){

                TreeNode rnode = qu.remove();
                li.add(rnode.val);
                // if left child is present
                if(rnode.left != null){
                    qu.add(rnode.left);
                }
                // if right child is present
                if(rnode.right != null){
                    qu.add(rnode.right);
                }
            }
//            After adding on every level
            list.add(li);
        }

        return list;
    }
}