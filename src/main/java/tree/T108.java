package tree;

import offer.TreeNode;

public class T108 {
    public static void main(String[] args) {
        Solution108 solution108 = new Solution108();
        solution108.sortedArrayToBST(new int[]{-10,-3,0,5,9});
    }
}
class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return createTree(nums,0,nums.length);
    }
    public TreeNode createTree(int[] nums,int l,int r){
        if(l>=r)
            return null;
        int m = l + (r-l)/2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = createTree(nums,l,m);
        root.right = createTree(nums,m+1,r);
        return root;
    }
}