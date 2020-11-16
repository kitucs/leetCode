package dp;

public class T152 {
    public static void main(String[] args) {
        Solution152 solution152 = new Solution152();
        System.out.println(solution152.maxProduct(new int[] { -2,0,-1}));
    }
}
class Solution152 {
    public int maxProduct(int[] nums) {
        int [] dpMax = new int[nums.length];
        int [] dpMin = new int[nums.length];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        int maxP =  nums[0];
        for (int i = 1; i < dpMax.length; i++) {
            dpMax[i] = Math.max(nums[i],(Math.max(nums[i]*dpMax[i-1],nums[i]*dpMin[i-1])));
            dpMin[i] = Math.min(nums[i],(Math.min(nums[i]*dpMax[i-1],nums[i]*dpMin[i-1])));

            maxP = Math.max(maxP,dpMax[i]);
        }
        return maxP;

    }
}
