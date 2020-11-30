package dichotomy;

public class T4 {
    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        double d = solution4.findMedianSortedArrays(new int[]{1,2},new int[]{3,4});
        System.out.println(d);
    }
}
class Solution4 {
    int[] n1,n2;
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        n1 = nums1;
        n2 = nums2;
        return (double) (findRe(0,0,(nums1.length+nums2.length+1)/2)+findRe(0,0,(nums1.length+nums2.length+2)/2))/2;

    }
    public int findRe(int l1,int l2,int k){
        System.out.println(l1+","+l2+','+k);

        //找到两个数组中的第k大数字，k从1开始计算

        if(l1==n1.length){
            return n2[l2+k-1];
        }
        if(l2==n2.length){
            return n1[l1+k-1];
        }
        if(k==0){
            return Math.min(n2[n2.length-1],n1[n1.length-1]);
        }
        if(k==1)
            return Math.min(n1[l1],n2[l2]);
        if(n1[k/2+l1-1]<n2[k/2+l2-1]){
            int newL1 = Math.min( k/2+l1,n1.length);
            return findRe(newL1,l2,k-(newL1-l1+1));
        }else{
            int newL2 = Math.min((k+1)/2+l2,n2.length);
            return findRe(l1,newL2,k-(newL2-l2+1));
        }
    }
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }

    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
        if (len1 == 0) return nums2[start2 + k - 1];

        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }
        else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }
}