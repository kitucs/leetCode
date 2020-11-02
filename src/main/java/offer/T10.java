package offer;

public class T10 {
    public static void main(String[] args) {
        Solution10 solution10 = new Solution10();
        int re=solution10.fib(2);
        System.out.println(re);
    }

}
class Solution10 {
    public int fib(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        int r0 = 1,r1=2,r2=0;
        int i = 3;

        while(i<=n){
            r2 = r0+r1;
            r0 = r1;
            r1 = r2;
            i++;
//            System.out.println(r2);
        }
        return r2;

    }
}
