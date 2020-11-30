package dichotomy;

public class T209 {
    public static void main(String[] args) {
        Solution209 solution209 = new Solution209();
        int re =solution209.minSubArrayLen(11,new int[]{1,2,3,4,5});
        System.out.println(re);
    }
}
class Solution209 {
    // 用双指针复杂度n，这里用二分法，时间复杂度 nlogn
    public int minSubArrayLen(int s, int[] nums) {
        int[] sumBefore = new int[nums.length+1];
        int size = sumBefore.length+1;
        sumBefore[0] = 0;
        for (int i = 1; i < sumBefore.length; i++) {
            sumBefore[i] = sumBefore[i-1]+nums[i-1];
        }
        for (int i = 0; i < sumBefore.length-1; i++) {
            int r = searchNumMin(sumBefore,s+sumBefore[i],i,sumBefore.length-1);
            if(r>sumBefore.length-1) continue;
            System.out.println(i+","+r);
            if(r-i<size){
                size = r-i;
            }
        }
        return size==sumBefore.length+1?0:size;

    }
    public static int  searchNumMin(int[] nums,int target,int l,int r){
        //二分查找nums中的一个数target的左侧索引
        // 不存在则返回大于target的第一个数字
//        int l=0,r=nums.length-1; // 注意是[l,r]
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
        return l;
    }
}