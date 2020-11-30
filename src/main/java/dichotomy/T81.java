package dichotomy;

public class T81 {
    public static void main(String[] args) {
        Solution81 solution81 = new Solution81();
        boolean re = solution81.search(new int[]{2,5,6,0,0,1,2},-1);
        System.out.println(re);
    }
}
class Solution81 {
    public boolean search(int[] nums, int target) {

        int l=0,r=nums.length-1;
        while (l<=r){
            int m = (l+r)/2;
            if(target==nums[m]) {
                return true;
            }
            // 1、普通二分
            if(nums[l]<nums[r]){
                if(nums[m]>target){
                    r = m - 1;
                }else{
                    l = m + 1;
                }
            }else{
                // 2 3 1
                if(nums[m]>nums[l]){
                    if(nums[m]>= target && target>=nums[l]){
                        r = m - 1;
                    }else{
                        l = m + 1;
                    }
                    // 3 1 2
                }else if(nums[m]<nums[l]){
                    if(nums[r]>= target && target>=nums[m]){
                        l = m + 1;
                    }else{
                        r = m - 1;
                    }
                }else{
                    //区别：在这里只能遍历
                    for (int k = l; k < r+1; k++) {
                        if(nums[k]==target)return true;
                    }
                    return false;

                }
            }
        }
        return false;


    }
}