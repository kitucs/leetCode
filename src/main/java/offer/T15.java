package offer;

public class T15 {
    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        int re = solution15.hammingWeight(11101);
        System.out.println(re);
    }
}
class Solution15 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count=0;
        while(n!=0){
            count += n&1;
            n = n >>> 1;
        }
        return count;

    }
}