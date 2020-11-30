package hashTable;

import java.util.HashMap;

public class T3 {
    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.lengthOfLongestSubstring("pwwkew"));
    }
}
class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> hashMap = new HashMap<>();
        int pre = 0,maxLen=0;

        for (int i = 0; i < s.length(); i++) {
            if(hashMap.containsKey(s.charAt(i))){
                int preTemp = hashMap.get(s.charAt(i))+1;
                pre = Math.max(preTemp, pre);
                hashMap.put(s.charAt(i),i);
            }else{
                hashMap.put(s.charAt(i),i);
            }
            System.out.println(pre+","+i);
            if(i-pre+1>maxLen){
                maxLen = i-pre+1;
            }

        }
        return maxLen;

    }
}