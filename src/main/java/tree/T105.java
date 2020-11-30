package tree;

import offer.TreeNode;

/**
 * Todo:寻找浪费的时间，可以通过建立哈希map来解决
 */
public class T105 {
    public static void main(String[] args) {
        Solution105 solution105 = new Solution105();
        solution105.buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
    }
}
class Solution105 {
    int[] preNums,inNums;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preNums=preorder;
        inNums=inorder;
        return createTree(0,preorder.length,0,inorder.length);

    }
    public TreeNode createTree(int preLeft,int preRight,int inLeft,int inRight){
        if(preRight-preLeft<=0)
            return null;

        TreeNode root = new TreeNode(preNums[preLeft]);
        int len=0;
        for (int i = inLeft; i < inRight; i++) {
            if(inNums[i]==root.val){
                len = i-inLeft;
                break;
            }
        }
        root.left = createTree(preLeft+1,preLeft+len+1,inLeft,inLeft+len);
        root.right = createTree(preLeft+len+1,preRight,inLeft+len+1,inRight);
        return root;
    }
}
