package offer;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1,2,3,5,5,5};
        int re = BinarySearch.searchNumMin(nums,4);
        System.out.println(re);

    }
    public static int  searchNum(int[] nums,int target){
        //二分查找nums中的一个数target，存在则返回其索引，不存在则返回-1
        int l=0,r=nums.length-1; // 注意是[l,r]
        while (l<=r){ //注意等于号
            int m =(l+r)/2;
            if(nums[m]==target){
                return m;
            }else if(nums[m]>target){
                r = m - 1;
            }else if(nums[m]<target){
                l = m + 1;
            }
        }
        return -1;
    }
    public static int  searchNumMin(int[] nums,int target){
        //二分查找nums中的一个数target的左侧索引
        // 不存在则返回大于target的第一个数字
        int l=0,r=nums.length-1; // 注意是[l,r]
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
    public static int  searchNumMax(int[] nums,int target){
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
        return l-1;
    }
}
