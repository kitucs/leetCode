package dichotomy;

public class T34 {
    public static void main(String[] args) {
        Solution34 solution34 = new Solution34();
        int[] re = solution34.searchRange(new int[]{1},0);
        System.out.println(re[0]+","+re[1]);
    }
}
class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = searchNumMin(nums,target);
        result[1] = searchNumMax(nums,target);
        return result;

    }
    public static int  searchNumMin(int[] nums,int target){
        //二分查找nums中的一个数target的左侧索引
        int l=0,r=nums.length-1; // 注意是[l,r]
        if(nums.length==0) return -1;
        while (l<=r){ //注意等于号
            int m =(l+r)/2;
            if(nums[m]==target){
                r = m - 1;
            }else if(nums[m]>target){
                r = m - 1;
            }else if(nums[m]<target){
                l = m + 1;
            }
        }
        return (l<nums.length && nums[l]==target)?l:-1;
    }
    public static int  searchNumMax(int[] nums,int target){
        if(nums.length==0) return -1;
        //二分查找nums中的一个数target的右侧索引
        int l=0,r=nums.length-1; // 注意是[l,r]
        while (l<=r){ //注意等于号
            int m =(l+r)/2;
            if(nums[m]==target){
                l = m + 1;
            }else if(nums[m]>target){
                r = m - 1;
            }else if(nums[m]<target){
                l = m + 1;
            }
        }
        return (l>0 && nums[l-1]==target)?l-1:-1;
    }
}