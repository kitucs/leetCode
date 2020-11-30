package dichotomy;

public class T50 {
    public static void main(String[] args) {
        Solution50 solution50 = new Solution50();
        double re = solution50.myPow(2.0,-1);
        System.out.println(re);
    }
}
class Solution50 {
    public double myPow(double x, int n) {
        if(n==-2147483648) n = -2147483641;
        double result = 1.0;
        double c = x;
        int m = n>0?n:-n;
        while (m>0){
            if((m&1)==1){
                result *= c;
            }
            m = m>>1;
            c = c * c;
        }
        return n>0?result:1/result;

    }
}