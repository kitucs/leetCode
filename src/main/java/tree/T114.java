package tree;

import offer.TreeNode;

public class T114 {
    public static void main(String[] args) {
        Solution114 solution114 = new Solution114();
        TreeNode root = TreeNode.creteTree(new int[]{1,2,5,3,4,-1,6});
        solution114.flatten(root);
        TreeNode.printTree(root);
    }
}
// 相当于先序遍历的节点用右节点连接起来
// 倒过来的先序遍历，然后记录后一个节点
class Solution114 {
    TreeNode nextNode=null;
    public void flatten(TreeNode root) {
        if(root==null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.left=null;
        root.right=nextNode;
        nextNode=root;
    }
}