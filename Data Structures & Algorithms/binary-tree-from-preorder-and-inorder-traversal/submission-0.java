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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> inorderMap=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inorderMap.put(inorder[i],i);
        }
        return splitTree(preorder,inorderMap,0,0,inorder.length-1);
    }
    public TreeNode splitTree(int[] preorder,Map<Integer,Integer> inorderMap,int rootIndex,int left,int right){
        TreeNode root=new TreeNode(preorder[rootIndex]);
        int rootPre=inorderMap.get(preorder[rootIndex]);

        if(rootPre>left){
            root.left=splitTree(preorder,inorderMap,rootIndex+1,left,rootPre-1);
        }
        if(rootPre<right){
            root.right=splitTree(preorder,inorderMap,rootIndex+rootPre-left+1,rootPre+1,right);
        }
        return root;
    }
}
