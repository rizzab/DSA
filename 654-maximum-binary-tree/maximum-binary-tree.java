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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null) {
            return null;
        } else {
            return build(nums, 0, nums.length - 1);
        }
    }

    private TreeNode build(int[] nums, int start, int end) {
        if (start > end) return null;

        int idmax = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > nums[idmax]) {
                idmax = i;
            }
        }

        TreeNode root = new TreeNode(nums[idmax]);
        root.left = build(nums, start, idmax - 1);
        root.right = build(nums, idmax + 1, end);

        return root;
    }
}
