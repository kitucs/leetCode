package offer;

public class T44 {
    public static void main(String[] args) {
        Solution44 solution44 =new Solution44();
        int re = solution44.findNthDigit(10);
        System.out.println(re);
    }
}
class Solution44 {
    public int findNthDigit(int n) {
        if(n==0) return 0;
        long nowCount = 0,pre=0;
        int weight=1;
        int base = 1;
        while(n>nowCount){
            pre=nowCount;
            nowCount += weight * 9*base;
            weight++;
            base*=10;
        }
        weight--;
        System.out.println(nowCount+","+pre+","+weight);
        int startNum = base==10?0:base/10;
        startNum--;
        int off1 =(int) (n-pre+weight-1)/weight;
        int off2 =(int) (n-pre+weight-1)%weight;
        //从startNum开始的off1所代表数的off2位数字
        System.out.println(startNum+","+off1+",余"+off2);
        //找到startNum+off1 第(weight-off2)位数
        int w = weight-off2;
        int nw = startNum+off1;
        int re = nw%10;
        //找到nw 第 w 位数
        System.out.println(nw+","+w+","+re);
        while (w>0){
            re =  nw % 10;
            nw /= 10;
            w--;
        }

        return re;

    }
}