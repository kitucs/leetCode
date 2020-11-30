package tree;

import offer.TreeNode;
import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.List;

public class T199 {
    public static void main(String[] args) {
        Solution199 solution199 = new Solution199();
        List<Integer> result =  solution199.rightSideView(TreeNode.creteTree(new int[]{1,2,3,4}));
        System.out.println(result);
    }
}
class Solution199 {
    List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root,0);
        return result;
    }
    public void dfs(TreeNode root,int depth){
        if(root==null){
            return;
        }
        if(depth>=result.size())
            result.add(depth,root.val);
        dfs(root.right,depth+1);
        dfs(root.left,depth+1);
    }
}