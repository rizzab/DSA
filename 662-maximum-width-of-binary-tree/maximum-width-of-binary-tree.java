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
    public int widthOfBinaryTree(TreeNode root) {
        int ans=0;
        Queue<Pair> q=new LinkedList<>();
        if(root==null){
            return 0;
        }
//default add root to queue
        q.offer(new Pair(root,0));

        while(!q.isEmpty()){
            int size=q.size();
//left and right to track the width
              int left=0;
              int right=0;
//take val from queue 
              int numm=q.peek().val;
//iterate elemts currently in queue
            for(int i=0;i<size;i++){
//store value in p obj
                Pair p=q.poll();
//currid is for creatig value in map in correct order each row should start from 1 so get value in current pair and first value in queue
                int curid=p.val-numm;
                TreeNode nod=p.node;
//everytime when looop start and end store curid to left and right
                    if(i==0){
                    left=curid;
                    }
                    
                    if(i==size-1){
                        right=curid;
                    }

//if childs are not null addkey and value in queue using formula 
                if(nod.left!=null){
                    q.offer(new Pair(nod.left,2*curid+1));
                }
                if(nod.right!=null){
                    q.offer(new Pair(nod.right,2*curid+2));
                }

            } 
             ans=Math.max(ans,right-left+1);
        }
        return ans;
        
    }
}
class Pair{

    TreeNode node;
    int val;

    Pair(TreeNode node,int val){
        this.node=node;
        this.val=val;
    }

}