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
    ArrayList<Integer> arr=new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        p(root,arr);
        return arr;
    }
    public void p(TreeNode root,ArrayList<Integer> arr){
        if(root ==null) return;
        arr.add(root.val);
        p(root.left,arr);
        p(root.right,arr);
    }
}