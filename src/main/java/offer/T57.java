package offer;

public class T57 {
    public static void main(String[] args) {
        Solution57 solution57 = new Solution57();
        int [] nums ={10,26,30,31,47,60};
        int target = 40;
        int[] re =  solution57.twoSum(nums,target);
        System.out.println(re[0]+","+re[1]);
    }

}
class Solution57 {
    public int[] twoSum(int[] nums, int target) {
        int i=0,j=nums.length-1;
        while (i<j){
            if(nums[i]+nums[j]==target){
                return new int[] {nums[i],nums[j]};
            }
        }

    }
}