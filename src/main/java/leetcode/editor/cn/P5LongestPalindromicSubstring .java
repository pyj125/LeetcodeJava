//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3680 👎 0


package leetcode.editor.cn;

//Java：最长回文子串
class P5LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new P5LongestPalindromicSubstring().new Solution();
        // TO TEST
        String s = "accbbd";
        String res = solution.longestPalindrome(s);
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            if (s == null || s.length() == 0) {
                return null;
            }
            char[] arr = s.toCharArray();
            int len = arr.length;
            int[] dp = new int[len];
            int res = 0, index = -1;
            boolean[][] flag = new boolean[len][len];
            for (int i = len - 1; i >= 0; i--) {
                for (int j = i; j < len; j++) {
                    if (arr[i] == arr[j] && (j - i <= 1 || flag[i + 1][j - 1])) {
                        flag[i][j] = true;
                        dp[i] = Math.max(j - i + 1, dp[i]);
                    }
                }
                // dp[i] 表示 从i开头最长回文字符串
                if (res < dp[i]) {
                    res = dp[i];
                    index = i;
                }
            }
            return s.substring(index, index + res);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
