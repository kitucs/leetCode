package tree;

import offer.TreeNode;

public class T101 {
    public static void main(String[] args) {
        Solution101 solution101 = new Solution101();
        solution101.isSymmetric(new TreeNode(1));
    }
}
class Solution101 {
    public boolean isSymmetric(TreeNode root) {
       return dfs(root,root);

    }
    public boolean dfs(TreeNode p,TreeNode q){
        if(p==null&&q==null)
            return true;
        if(p==null||q==null)
            return false;
        if(p.val!=q.val)
            return false;
        return dfs(p.left,q.right)&&dfs(p.right,q.left);
    }
}