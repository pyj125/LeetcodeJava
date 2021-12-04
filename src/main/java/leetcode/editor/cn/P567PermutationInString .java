//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。 
//
// 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
// 
//
// 
//
// 提示： 
//
// 
// 输入的字符串只包含小写字母 
// 两个字符串的长度都在 [1, 10,000] 之间 
// 
// Related Topics 双指针 Sliding Window 
// 👍 339 👎 0


package leetcode.editor.cn;

//Java：字符串的排列
 class P567PermutationInString {
    public static void main(String[] args) {
        Solution solution = new P567PermutationInString().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int m = s1.length();
            int n = s2.length();
            if (m > n) {
                return false;
            }
            // 欠债表  从窗口移除需要++ 从窗口进入需要--，来还债，如果<0说明多还了 invalidtimes
            int[] map = new int[128];
            int inValidTimes = 0;
            for (int i = 0; i < m; i++) {
                int ch = s1.charAt(i);
                map[ch]++;
            }
            int right = 0;
            for (right = 0; right < m; right++) {
                int ch = s2.charAt(right);
                if (map[ch]-- <= 0) {
                    inValidTimes++;
                }
            }

            for (; right < n; right++) {
                if (inValidTimes == 0) {
                    return true;
                }
                //新进的字符right原本是<=0的，那么本次就是多余还款
                if (map[s2.charAt(right)]--<=0) {
                    inValidTimes++;
                }
                //从左边移除出去的字符，统计字符数目就需要加1  需要判断这个字符之前是不是多还了，是的话，就要把无效点数-1
                if(map[s2.charAt(right-m)]++ < 0){
                    inValidTimes--;
                }
            }
            if(inValidTimes == 0){
                return true;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
