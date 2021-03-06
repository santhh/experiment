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
       
    public int minDepth(TreeNode root) {
     if(root ==null) return 0;
     int minDepth =1;   
     Queue<TreeNode> q = new ArrayDeque<>();
     q.add(root);
       while (!q.isEmpty()){
         int len = q.size();
          for (int i=0; i< len; i++){
             TreeNode current = q.poll();
               if (current.left ==null && current.right==null){
                   return minDepth;
               } 
               if(current.left!=null){
                   q.add(current.left);
               } 
               if(current.right!=null){
                   q.add(current.right);
               }
           } 
          
           minDepth +=1;
       }
        
       return 0; 
        
        
        
        
    }
}