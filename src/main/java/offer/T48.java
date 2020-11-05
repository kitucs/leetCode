package offer;

import java.util.HashMap;
import java.util.Map;

public class T48 {
    public static void main(String[] args) {
        Solution48 solution48 = new Solution48();
        int re = solution48.lengthOfLongestSubstring("aaa");
        System.out.println(re);
    }
}
class Solution48 {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        Map<Character,Integer> map = new HashMap<>();

        char[] chars = s.toCharArray();
        int maxLen = -1;
        int pre = 0;
        for (int i = 0; i < chars.length; i++) {
//            if(map.containsKey(chars[i]) && map.get(chars[i])+1>pre){
//                pre = map.get(chars[i])+1;
//            }
            //注意上面的效率很低
            if(map.containsKey(chars[i])){
                pre = Math.max(map.get(chars[i])+1,pre);
            }
            if(i-pre+1>maxLen){
                System.out.println(pre+","+i);
                maxLen = i-pre+1;
            }

            map.put(chars[i],i);
        }
        return maxLen;


    }
}
