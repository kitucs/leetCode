package offer;

public class T55_2 {
    public static void main(String[] args) {
        Solution55_2 solution55_2 = new Solution55_2();
        int[] nums = {1,2,2,3,3,-1000,1000,4,4};
        TreeNode root = TreeNode.creteTree(nums);
        boolean re = solution55_2.isBalanced(root);
        System.out.println(re);
    }
}
class Solution55_2 {
    boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return isBalanced;
    }
    public int  dfs(TreeNode root){
        if(root==null) return 0;
        if(!isBalanced) return 0;

        int l = dfs(root.left)+1;
        int r = dfs(root.right)+1;
        System.out.println(l+","+r);
        if(l-r>1 || r-l>1){
            isBalanced = false;
        }
        return Math.max(l,r);
    }
}
