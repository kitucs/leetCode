package offer;

import java.util.Arrays;

public class T21 {
    public static void main(String[] args) {
        Solution21 solution21 = new Solution21();
        int[] nums={1,2,3,4};
        int [] re= solution21.exchange(nums);
        for(int  n:nums) {
            System.out.println(n);
        }
    }
}
class Solution21 {
    public int[] exchange(int[] nums) {
        int l=0,r=nums.length-1;
        while(l<r){
            while((nums[l]&1)==1){
                l++;
                if(l>=r){

                    return nums;
                }
            }
            while((nums[r]&1)==0){
                r--;
                if(l>=r){

                    return nums;
                }
            }
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }

        return nums;
    }

}