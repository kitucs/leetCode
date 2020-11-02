package offer;

public class T33 {
    public static void main(String[] args) {
        Solution33 solution33 = new Solution33();
//        int[] nums = {4, 6, 12, 8, 16, 14, 10};
        int[] nums = {1,2,3,4,5};
        boolean flag = solution33.verifyPostorder(nums);
        System.out.println(flag);
    }
}
class Solution33 {
    public boolean verifyPostorder(int[] postorder) {
        if(postorder.length<2) return true;
        return checkTree(postorder,0,postorder.length-1);

    }
    public static boolean checkTree(int[] postorder,int l,int r){
        if(r-l<2) return true;
        //后序遍历的根节点
        int root = postorder[r];
        int len=0;
        //计算在l - r-1范围中有多少个小于root的数
        for(int i=l;i<r&&postorder[i]<root;i++){
            len++;
        }
        for(int i=l+len;i<r;i++){
            if(postorder[i]<root)
                return false;
        }
        System.out.println("root:"+root+",len="+len);
        if(len==0){
            if(postorder[r-1]<root)
                return false;
        }else if(len==r-l ){
            if(postorder[r-1]>root)
                return false;
        }else if(postorder[l+len-1]>root || postorder[r-1]<root){
            return false;
        }
        return checkTree(postorder,l,l+len-1) && checkTree(postorder,l+len,r-1);
    }
    public static boolean checkTree2(int[] postorder,int l,int r){
        return false;
    }
}
//class Solution {
//    public boolean verifyPostorder(int[] postorder) {
//        return recur(postorder, 0, postorder.length - 1);
//    }
//    boolean recur(int[] postorder, int i, int j) {
//        if(i >= j) return true;
//        int p = i;
//        while(postorder[p] < postorder[j]) p++;
//        int m = p;
//        while(postorder[p] > postorder[j]) p++;
//        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
//    }
//}
