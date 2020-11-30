package dichotomy;

public class T35 {
    public static void main(String[] args) {
        Solution35 solution35 = new Solution35();
        int re = solution35.searchInsert(new int[]{1,3,5,6},0);
        System.out.println(re);
    }
}
class Solution35 {
    public int searchInsert(int[] nums, int target) {
        int l=0,r=nums.length-1;
        while (l<=r){
            int m=(l+r)/2;
            if(nums[m]==target){
                return m;
            }else if(target>nums[m]){
                l=m+1;
            }else{
                r=m-1;
            }
        }
        System.out.println(l+","+r);
        return l;

    }
}