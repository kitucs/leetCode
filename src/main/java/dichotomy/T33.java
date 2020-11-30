package dichotomy;

public class T33 {
    public static void main(String[] args) {
        Solution33 solution33 = new Solution33();
        System.out.println(solution33.search(new int[]{4,5,6,7,0,1,2},3));
    }
}
class Solution33 {
    public int search(int[] nums, int target) {
        int l=0,r=nums.length-1;
        while (l<=r){
            int m = (l+r)/2;
            if(target==nums[m]) {
                return m;
            }
            // 1、普通二分
            if(nums[l]<=nums[r]){
                if(nums[m]>target){
                    r = m - 1;
                }else{
                    l = m + 1;
                }
            }else{
                // 2 3 1
                if(nums[m]>=nums[l]){
                    if(nums[m]>= target && target>=nums[l]){
                        r = m - 1;
                    }else{
                        l = m + 1;
                    }
                // 3 1 2
                }else{
                    if(nums[r]>= target && target>=nums[m]){
                        l = m + 1;
                    }else{
                        r = m - 1;
                    }
                }
            }
        }
        return -1;

    }
}