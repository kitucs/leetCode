package dichotomy;

public class T154 {
    public static void main(String[] args) {
        Solution154 solution154 = new Solution154();
        System.out.println(solution154.findMin(new int[]{2,2,2,0,1}));
    }
}

class Solution154 {
    public int findMin(int[] nums) {
        int l=0,r=nums.length-1;
        while (l<=r){
            if(nums[l]<nums[r]){
                return nums[l];
            }else{
                int m = l + (r-l)/2;
                if(nums[l]<nums[m]){
                    l = m + 1;
                }else if (nums[l]>nums[m]){
                    r = m ;
                }else{
                    // 注意这里两种情况
                    // 1、l==r
                    if(l==r)
                        return nums[l];
                    // 2、复杂情况，令l++，摆脱局部困境
                    l++;
                }
            }
        }

        return nums[l];
    }
}