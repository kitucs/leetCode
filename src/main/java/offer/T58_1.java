package offer;

public class T58_1 {
    public static void main(String[] args) {
        Solution58_1 solution58_1 = new Solution58_1();
        String re = solution58_1.reverseWords("  the   sky  is blue");
        System.out.println(re);
    }

}
class Solution58_1 {
    public String reverseWords(String s) {
        s = s.trim().replaceAll("\\s+"," ");
        String[] nums = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=nums.length-1;i>=0;i--){
            stringBuilder.append(nums[i]).append(" ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();


    }
}