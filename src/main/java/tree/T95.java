package tree;

import offer.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class T95 {
    public static void main(String[] args) {
        Solution95 solution95 = new Solution95();
        List<TreeNode> treeNodes = solution95.generateTrees(3);
        for(TreeNode node:treeNodes){
            System.out.println(node.val);
        }

    }
}
class Solution95 {
    public List<TreeNode> generateTrees(int n) {
        if(n==0){
            return new ArrayList<>();
        }
        return create(1,n+1);
    }
    // [left,right)
    public List<TreeNode> create(int left,int right){
        System.out.println(left+","+right);
        List<TreeNode> tempList = new ArrayList<>();
        if(right-left==1){
            tempList.add(new TreeNode(left));
            return tempList;
        }
        if(right<=left){
            return null;
        }
        for (int i = left; i < right; i++) {
            List<TreeNode> leftList = create(left,i);
            List<TreeNode> rightList  = create(i+1,right);

            if(leftList==null){
                for(TreeNode rightRoot:rightList){
                    TreeNode root = new TreeNode(i);
                    root.left=null;
                    root.right=rightRoot;
                    tempList.add(root);
                }
                continue;
            }
            if(rightList==null){
                for(TreeNode leftRoot:leftList){
                    TreeNode root = new TreeNode(i);
                    root.left=leftRoot;
                    root.right=null;
                    tempList.add(root);
                }
                continue;
            }
            for(TreeNode leftRoot:leftList){
                for(TreeNode rightRoot:rightList){
                    TreeNode root = new TreeNode(i);
                    root.left=leftRoot;
                    root.right=rightRoot;
                    tempList.add(root);

                }
            }
        }
        return tempList;
    }
}