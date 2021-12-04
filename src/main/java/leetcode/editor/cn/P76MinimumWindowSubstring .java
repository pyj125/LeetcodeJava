//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 105 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 1111 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：最小覆盖子串
class P76MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new P76MinimumWindowSubstring().new Solution();
        // TO TEST
        String s = "ADOBECODEBANC", t = "ABC";
        String res = solution.minWindow(s, t);
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow1(String s, String t) {

            if (s.length() < t.length()) {
                return "";
            }

            int left = 0, right = 0, begin = 0;
            int res = s.length() + 1;
            int len = s.length();

            //表示当前窗口内，还需要多少个字符
            int num = t.length();
            int[] freq = new int[128];
            for (int i = 0; i < t.length(); i++) {
                int index = t.charAt(i);
                freq[index]++;
            }

            while (right < len) {
                int ch = s.charAt(right);
                //t中出现的字符  num 只有t中出现的字符才会影响 变为0
                if (freq[ch] > 0) {
                    num--;
                }
                freq[ch]--;
                //右边界是开区间
                right++;
                //移动左边界
                while (num == 0) {
                    //得到一个可行解，做统计
                    if (res > right - left) {
                        res = right - left;
                        begin = left;
                    }
                    //左指针开始移动，
                    int left_char = s.charAt(left);
                    //在这里只可能是t中出现的字符才会==0
                    if (freq[left_char] == 0) {
                        num++;
                    }
                    freq[left_char]++;
                    left++;
                }
            }
            if (res == s.length() + 1) {
                return "";
            }
            return s.substring(begin, begin + res);
        }

        public String minWindow(String s, String t) {

            if (s.length() < t.length()) {
                return "";
            }

            int left = 0, right = 0, begin = 0;
            int res = s.length() + 1;
            int len = s.length();

            //表示当前窗口内，加法模式，已经有多少个字符了
            int num = 0;
            int[] tFreq = new int[128];
            int[] sFreq = new int[128];

            for (int i = 0; i < t.length(); i++) {
                int index = t.charAt(i);
                tFreq[index]++;
            }

            while (right < len) {
                int ch = s.charAt(right);
                if (sFreq[ch] < tFreq[ch]) {
                    num++;
                }
                sFreq[ch]++;
                //右边界是开区间
                right++;
                //移动左边界
                while (num == t.length()) {
                    //得到一个可行解，做统计
                    if (res > right - left) {
                        res = right - left;
                        begin = left;
                    }
                    //左指针开始移动，
                    int left_char = s.charAt(left);
                    //在这里只可能是t中出现的字符才会==0
                    if (sFreq[left_char] == tFreq[left_char]) {
                        num--;
                    }
                    sFreq[left_char]--;
                    left++;
                }
            }
            if (res == s.length() + 1) {
                return "";
            }
            return s.substring(begin, begin + res);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
