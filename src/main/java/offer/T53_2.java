package offer;

public class T53_2 {
    public static void main(String[] args) {
        Solution53_2 solution53_2 = new Solution53_2();
        int[] nums = {0,1,2};
        int re = solution53_2.missingNumber(nums);
        System.out.println(re);
    }
}
class Solution53_2 {
    public int missingNumber(int[] nums) {
        int l=0,r=nums.length-1;
        while (l<=r){
            int m = (l+r)/2;
            System.out.println(l+","+m+","+r);
            if(nums[m]==m){
                l = m +1;
            }else{
                r = m - 1;
            }
        }
        return l;

    }
}