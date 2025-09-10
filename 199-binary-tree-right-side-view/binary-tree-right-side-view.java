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
     List<Integer> result =new ArrayList<>();
     if (root==null) return result;

    Queue<TreeNode> queue= new LinkedList<>();
    queue.offer(root);
    while(!queue.isEmpty()){
        int LevelSize=queue.size();
        int LastValue=0;

        for(int i=0;i<LevelSize;i++){
            TreeNode node=queue.poll();
            LastValue=node.val;
            if(node.left!=null) queue.offer(node.left);
            if(node.right!=null) queue.offer(node.right);
        }
        result.add(LastValue);
    }
    return result;
    }
}