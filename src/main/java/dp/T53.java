package dp;

public class T53 {
    public static void main(String[] args) {
        Solution53 solution53 = new Solution53();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int re = solution53.maxSubArray(nums);
        System.out.println(re);
    }
}
class Solution53 {
    public int maxSubArray(int[] nums) {
        if(nums.length==1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i-1]>0 ? dp[i-1] + nums[i] : nums[i];
            max = Math.max(dp[i],max);
        }
        return max;

    }
}