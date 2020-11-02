package offer;

public class T11 {
    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
        int[] nums = {3,3,3,3,3,3,3,3,1,3};
        int re = solution11.minArray(nums);
        System.out.println(re);
    }
}
class Solution11 {
    public int minArray(int[] numbers) {
        int l=0,r=numbers.length-1,m;
        if(numbers[l]<numbers[r])
            return numbers[l];
        while(l<r){
            m = (l+r)/2;
//            System.out.println(l+","+m+","+r);
            if(m==numbers.length-1) return numbers[m];
            if(numbers[m]>numbers[m+1])
                return numbers[m+1];
            if(numbers[l]<numbers[m]){
                l=m;
            }else if(numbers[l]>numbers[m]){
                r=m;
            }else{
                if(numbers[r]<numbers[m]){
                    l=m;
                }else if(numbers[r]>numbers[m]){
                    r=m;
                }else{
                    return  findMinEle(numbers,l,r);
                }
            }
        }
        return numbers[l];
    }
    public int findMinEle(int[] number,int l,int r){
//        System.out.println(l+","+r);
        for (int i = l; i < r; i++) {
            if(number[i]>number[i+1])
                return number[i+1];
        }
        return number[l];
    }
}