package dichotomy;

public class T162 {
    public static void main(String[] args) {
        Solution162 solution162 = new Solution162();
        int re = solution162.findPeakElement(new int[]{1,2,3,1});
        System.out.println(re);
    }
}
class Solution162 {
    public int findPeakElement(int[] nums) {
        int l=0,r=nums.length-1;
        while (l<=r){
            int m = l+ (r-l)/2;
            System.out.println(l+","+m+","+r);
            if(r-l<=1){
                return nums[l]>nums[r]?l:r;
            }else if(nums[m]<nums[m-1]){
                r = m - 1;
            }else{
                l = m + 1;
                if(nums[m]>nums[m+1])
                    return m;
            }
        }
        return -1;

    }
}