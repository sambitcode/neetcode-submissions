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
    /*public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int maxSoFar) {
        if (node == null) return 0;
        int count = 0;
        if (node.val >= maxSoFar) {
            count = 1;
            maxSoFar = node.val;
        }
        count += dfs(node.left, maxSoFar);
        count += dfs(node.right, maxSoFar);
        return count;
    }*/

    public int goodNodes(TreeNode root){
        return goodNodesRec(root, Integer.MIN_VALUE);
    }

    private int goodNodesRec(TreeNode root, int pathMax) {
        if(root == null) return 0;
        int result;
        if(root.val >= pathMax){
            result = 1 + goodNodesRec(root.left, root.val) + goodNodesRec(root.right, root.val);
        }  else {
            result = goodNodesRec(root.left, pathMax) + goodNodesRec(root.right, pathMax);
        }
        return result;
    }
}
