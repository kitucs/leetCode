package offer;

public class T43 {
    public static void main(String[] args) {
        Solution43 solution43 =new Solution43();
        int re = solution43.countDigitOne(1410065408);
        System.out.println(re);
        System.out.println(10065408+4*1000000000/10);
    }
}
class Solution43 {
    public int countDigitOne(int n) {
        int pre=n,tail=-1,now=0,count = 0;
        long base=1;
        int result =0;

        while(pre>0){
            tail = (tail==-1)?now: tail+now*(int)(base/10);
            now = pre%10;
            pre /= 10;

            if(now>1){
                count = (pre+1)*(int)base;
            }else if(now ==1){
                count = pre*(int)base + tail+1;
            }else{
                count = pre*(int)base;
            }
            base = base*10;
            System.out.println(pre+","+now+","+tail+","+count);
            result+= count;

        }
        return result;
    }
}