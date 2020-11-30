package dichotomy;

public class T153 {
    public static void main(String[] args) {
        Solution153 solution153 = new Solution153();
        System.out.println(solution153.findMin(new int[]{3,1,2}));
    }
}
class Solution153 {
    public int findMin(int[] nums) {
        int l=0,r=nums.length-1;
        while (l<=r){
            if(nums[l]<=nums[r]){
                return nums[l];
            }else{
                int m = l + (r-l)/2;
                if(nums[l]<nums[m]){
                    l = m + 1;
                }else if (nums[l]>nums[m]){
                    r = m ;
                }else{
                    return Math.min(nums[l],nums[r]);
                }
            }
        }

        return -1;
    }
}