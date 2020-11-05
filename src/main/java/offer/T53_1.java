package offer;

public class T53_1 {
    public static void main(String[] args) {
        Solution53_1 solution53_1 = new Solution53_1();
        int[] nums = {5,7,7,8,8,10};
        int target = 7;
        int re = solution53_1.search2(nums,target);
        System.out.println(re);
    }
}
class Solution53_1 {
    public int search(int[] nums, int target) {
        //1、二分法找到元素 [a,b)
        int l=0,r=nums.length,m=-1;
        while (l<r){
            m = (l+r)/2;
            System.out.println(l+","+m+","+r);
            if(nums[m]==target)
                break;
            else if(nums[m]>target){
                r = m;
            }else{
                l = m+1;
            }
        }
        if(nums[m]!=target) return 0;

        //2、左右查询相同元素个数
        int rc=m,lc=m;
        while(rc<nums.length && nums[rc]==target){
            rc++;
        }
        while(lc>=0 &&nums[lc]==target){
            lc--;
        }
        return rc-lc-1;

    }
    public int search2(int[] nums, int target) {
        //采用二分查找左右边界，然后计算长度 [a,b]
        int left = BinarySearch.searchNumMin(nums,target);
        int right = BinarySearch.searchNumMax(nums,target);

        System.out.println(left+","+right);
        return right-left+1;
    }
}
