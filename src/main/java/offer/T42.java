package offer;

public class T42 {
    public static void main(String[] args) {
        Solution42 solution42 = new Solution42();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int re= solution42.maxSubArray(nums);
        System.out.println(re);
    }
}
class Solution42 {
    public int maxSubArray(int[] nums) {
        int[] f = new int[nums.length];
        f[0]=nums[0];
        int max=nums[0];
        for(int i=1;i<nums.length;i++){
            if(f[i-1]>0){
                f[i] = f[i-1] + nums[i];
            }else {
                f[i] = nums[i];
            }
            if(f[i]>max){
                max=f[i];
            }
        }
        return max;



    }
}