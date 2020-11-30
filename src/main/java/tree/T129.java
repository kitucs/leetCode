package tree;

import offer.TreeNode;

public class T129 {
    public static void main(String[] args) {
        Solution129 solution129 = new Solution129();
        int re = solution129.sumNumbers(TreeNode.creteTree(new int[]{1,2,3}));
        System.out.println(re);
    }
}
class Solution129 {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root==null)
            return 0;
        dfs(root,root.val);
        return sum;
    }
    public void dfs(TreeNode root,int num){
        if(root.left==null&&root.right==null){
            sum+=num;
        }
        if(root.left!=null)
            dfs(root.left,num*10+root.left.val);
        if(root.right!=null)
            dfs(root.right,num*10+root.right.val);


    }
}