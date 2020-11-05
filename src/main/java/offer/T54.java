package offer;

public class T54 {
    public static void main(String[] args) {
        Solution54 solution54 = new Solution54();
        int[] nums = {5,3,6,2,4,-1000,-1000,1};
        TreeNode head =  TreeNode.creteTree(nums);
        int re = solution54.kthLargest(head,3);
        System.out.println(re);
    }
}
class Solution54 {
    int n,result;
    public int kthLargest(TreeNode root, int k) {
        n = k;
        dfs(root);
        return result;

    }
    public void dfs(TreeNode root){
        if(root==null) return;
        dfs(root.right);
        System.out.println(n+","+root.val);
        n--;
        if(n==0){
            result=root.val;
            n--;
        }
        if(n<0) return;
        dfs(root.left);
    }
}
