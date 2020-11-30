package tree;

import offer.TreeNode;

public class T104 {
    public static void main(String[] args) {
        Solution104 solution104 = new Solution104();
        System.out.println(solution104.maxDepth(new TreeNode(1)));
    }
}
class Solution104 {
    int maxDepth = 0;
    public int maxDepth(TreeNode root) {
        dfs(root,0);
        return maxDepth;
    }
    public void dfs(TreeNode root,int depth){
        if(root==null){
            if(depth>maxDepth)
                maxDepth=depth;
            return;
        }
            dfs(root.left,depth+1);
            dfs(root.right,depth+1);
    }
}