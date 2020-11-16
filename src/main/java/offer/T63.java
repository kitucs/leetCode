package offer;

public class T63 {
    public static void main(String[] args) {
        Solution63 solution63 = new Solution63();
        int re =solution63.maxProfit(new int[]{7,6,5,4,3,2,1});
        System.out.println(re);

    }
}
class Solution63 {
    public int maxProfit(int[] prices) {
        int leftMin = 1000;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i]-leftMin>maxProfit){
                maxProfit = prices[i]-leftMin;
            }
            if(prices[i]<leftMin) leftMin=prices[i];
        }
        return maxProfit;

    }
}
