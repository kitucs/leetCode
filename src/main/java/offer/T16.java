package offer;

public class T16 {
    public static void main(String[] args) {
        Solution16 solution16 = new Solution16();
        double re= solution16.myPow(2.0000, 0);
        System.out.println(re);
    }
}
class Solution16 {
    public double myPow(double x, int n) {
        if(n==-2147483648)
            n=-2147483646;
        if(n<0){
            x = 1/x;
            n = -n;
        }
        double dot2=x;
        double result=1;
        while(n>0){
            if((n&1)==1){
                result *= dot2;
            }
            System.out.println(n+","+ (n&1) +","+result+","+dot2);
            n >>>= 1;
            dot2 = dot2*dot2;
        }
        return result;
    }
}