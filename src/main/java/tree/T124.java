package tree;

import offer.TreeNode;

public class T124 {
    public static void main(String[] args) {
        Solution124 solution124 = new Solution124();
        int[] nums = {};
        int re= solution124.maxPathSum(TreeNode.creteTree(nums));
        System.out.println(re);
    }
}
class Solution124 {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dsp(root);
        return maxSum;
    }
    public int dsp(TreeNode root) {
        if(root==null)
            return 0;
        int leftVal = dsp(root.left);
        int rightVal = dsp(root.right);
        int now = root.val+leftVal+rightVal;
        if(now>maxSum){
            maxSum=now;
        }

        return Math.max(0,root.val+Math.max(leftVal,rightVal));
    }
}