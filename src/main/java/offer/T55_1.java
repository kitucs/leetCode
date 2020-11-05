package offer;

public class T55_1 {
    public static void main(String[] args) {
        Solution55_1 solution55_1 = new Solution55_1();
        int[] nums = {3,9,20,-1000,1000,15,7};
        TreeNode head = TreeNode.creteTree(nums);
        int re = solution55_1.maxDepth(head);
        System.out.println(re);

    }
}

class Solution55_1 {
    int maxDepth=0;
    public int maxDepth(TreeNode root) {
        dfs(root,1);
        return maxDepth;

    }
    public void dfs(TreeNode root,int depth){
        if(root==null) return;

        if(depth>maxDepth) maxDepth=depth;
        dfs(root.right,depth+1);
        dfs(root.left,depth+1);

    }
}