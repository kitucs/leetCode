package T1_10;

import java.util.HashMap;
import java.util.Map;

public class T3 {
    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        String s = "abba";
        int re =solution.lengthOfLongestSubstring(s);
        System.out.println(re);
    }
}
class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        char[] array = s.toCharArray();
        Map<Character,Integer> map = new HashMap();
        int l = 0;
        int r =0;
        int maxLen = 0;
        for(int i=0;i<array.length;i++){
            if(map.containsKey(array[i]) && (map.get(array[i])+1)>l ){
                l = map.get(array[i])+1;
            }
            r++;
            System.out.println(l+","+r+","+maxLen);
            if(r-l>maxLen){
                maxLen = r-l;
            }

            map.put(array[i],i);
        }

        return  maxLen;
    }
}