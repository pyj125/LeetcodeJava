//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。 
//
// 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// s.length <= 40000 
// 
//
// 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-rep
//eating-characters/ 
// Related Topics 哈希表 双指针 Sliding Window 
// 👍 188 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：最长不含重复字符的子字符串
class Offer_48ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof {
    public static void main(String[] args) {
        Solution solution = new Offer_48ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof().new Solution();
        // TO TEST
        String s = "pwwkew";
        int res = solution.lengthOfLongestSubstring(s);
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {

            int left = 0, right = 0;
            int res = 0;
            char[] arr = s.toCharArray();
            int len = arr.length;
            //存储字符，以及这个字符最近一次出现的位置
            Map<Character,Integer> map = new HashMap<>();

            while (right < len) {
                //判断 右边字符是否存在，如果存在直接跳到这个字符上一次出现位置的的下一个位置
                Character ch = arr[right];
                if(map.containsKey(ch)){
                    left = Math.max(map.get(ch)+1,left);
                }
                //如果新增的字符不在map中，那么right就可以一直外扩
                map.put(ch,right);
                res = Math.max(res, right - left + 1);
                right++;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
