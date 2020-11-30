package tree;

import offer.TreeNode;

public class T110 {
    public static void main(String[] args) {
        Solution110 solution110 = new Solution110();
        solution110.isBalanced(new TreeNode(1));
    }
}
class Solution110 {
    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return flag;
    }
    public int dfs(TreeNode root){
        if(!flag){
            return -1;
        }
        if(root==null)
            return 0;
        int leftDepth = dfs(root.left)+1;
        int rightDepth = dfs(root.right)+1;
        if(leftDepth-rightDepth<-1 || leftDepth-rightDepth>1){
            flag=false;
        }
        return Math.max(leftDepth,rightDepth);
    }
}