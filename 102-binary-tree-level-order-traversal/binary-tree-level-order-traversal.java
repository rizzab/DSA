class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> treenodequeue = new LinkedList<>();
        treenodequeue.add(root);

        while (!treenodequeue.isEmpty()) {
            int size = treenodequeue.size();  // number of nodes in this level
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode treenode = treenodequeue.poll();
                level.add(treenode.val);   // add node’s value to current level
                System.out.print(treenode.val + "-> ");  // optional print

                if (treenode.left != null) {
                    treenodequeue.add(treenode.left);
                }
                if (treenode.right != null) {
                    treenodequeue.add(treenode.right);
                }
            }

            result.add(level); // add the completed level
        }

        return result;
    }
}
