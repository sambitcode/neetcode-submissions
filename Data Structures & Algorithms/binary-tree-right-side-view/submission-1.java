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
    public List<Integer> rightSideViewBfs(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> newRow = new ArrayList<>();
            for(int i =0 ; i <size; i++){
                TreeNode node = queue.poll();
                newRow.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            list.add(newRow);
        }
        List<Integer> result = new ArrayList<>();
        for(List<Integer> row : list){
            result.add(row.get(row.size()-1));
        }
        return result;
    }


    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        rightSideViewDfsRec(root, list, 0);
        List<Integer> result = new ArrayList<>();
        for(List<Integer> row : list){
            result.add(row.get(row.size()-1));
        }
        return result;
    }

    private void rightSideViewDfsRec(TreeNode root, List<List<Integer>> list, int level) {
        if(root == null) return;
        if(level == list.size()){
            list.add(new ArrayList<>());
        }
        list.get(level).add(root.val);
        if(root.left != null) {
            rightSideViewDfsRec(root.left, list, level+1);
        }
        if(root.right != null) {
            rightSideViewDfsRec(root.right, list, level+1);
        }
    }

    public List<Integer> rightSideViewDfsBest(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightView(root, result, 0);
        return result;
    }

    private void rightView(TreeNode root, List<Integer> result, int level) {
        if (root == null) return;

        // first node at this level
        if (level == result.size()) {
            result.add(root.val);
        }

        // go RIGHT first
        rightView(root.right, result, level + 1);
        rightView(root.left, result, level + 1);
    }
}
