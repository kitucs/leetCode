package dp;

import java.util.HashMap;

public class T87 {
    public static void main(String[] args) {
        Solution87 solution87 = new Solution87();
        boolean re =solution87.isScramble("abc","cba");
        System.out.println(re);
    }
}

/**
 * 关于区间dp
 * 背景：给定一个序列或字符串要进行一些操作，从最后一步出发，要将序列或字符串去头、去尾，如果做过最长回文子串，你就就可以想一下这样子的操作。区间型 dpdp 一般用 dp[i][j]dp[i][j] ，ii 代表左端点，jj 代表右端点，若有其他维度可再添加，若两个端点之间存在联系，则可再压缩空间。力扣上还有一些题也属于区间 dpdp，我推荐大家做一下，下面列出了一些
 *
 * 5. 最长回文子串
 * 516. 最长回文子序列
 * 312. 戳气球
 * 1246. 删除回文子数组（这个题微软面试问的很多）

 */
class Solution87 {
    String str1,str2;
    public boolean isScramble(String s1, String s2) {
        str1 = s1;
        str2 = s2;
        return isMath(0,s1.length()-1,0,s2.length()-1);
    }
    boolean isMath(int l1,int r1,int l2,int r2){
        System.out.println(l1+","+r1+","+l2+","+r2);
        System.out.println(str1.substring(l1,r1+1)+":::"+str2.substring(l2,r2+1));

        // 两个字符串的长度比较
        if(r1-l1 !=r2-l2){
            return false;
        }
        // 两个字符串是否相同
        if(str1.substring(l1,r1+1).equals(str2.substring(l2,r2+1))){
            System.out.println(str1.substring(l1,r1+1)+":::"+str2.substring(l2,r2+1));
            return true;
        }

        //当两个字符串中的字符都不相同时，直接返回false
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < r1-l1+1; i++) {
            char c1 = str1.charAt(l1+i);
            char c2 = str2.charAt(l2+i);
            map.put(c1, map.getOrDefault(c1, 0) + 1);
            map.put(c2, map.getOrDefault(c2, 0) - 1);
        }
        for (Character key : map.keySet()) {
            if (map.get(key) != 0) {
                return false;
            }
        }
        //递归遍历
        boolean flag;
        for (int m = 1; m < r1-l1+1; m++) {
            // m 代表前面一部分的数量
            // 需要注意各个边界，字符串 str1[l1,r1] 的长度为 r1-l1+1
            flag = (isMath(l1,l1+m-1,l2,l2+m-1)&&isMath(l1+m,r1,l2+m,r2))
                    || (isMath(l1,l1+m-1,r2-m+1,r2)&&isMath(l1+m,r1,l2,r2-m));
            if(flag) return true;

        }
        return false;
    }
}