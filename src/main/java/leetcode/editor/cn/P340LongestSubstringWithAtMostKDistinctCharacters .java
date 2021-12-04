//给定一个字符串 s ，找出 至多 包含 k 个不同字符的最长子串 T。 
//
// 示例 1: 
//
// 输入: s = "eceba", k = 2
//输出: 3
//解释: 则 T 为 "ece"，所以长度为 3。 
//
// 示例 2: 
//
// 输入: s = "aa", k = 1
//输出: 2
//解释: 则 T 为 "aa"，所以长度为 2。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 122 👎 0


package leetcode.editor.cn;
//Java：至多包含 K 个不同字符的最长子串
 class P340LongestSubstringWithAtMostKDistinctCharacters{
    public static void main(String[] args) {
        Solution solution = new P340LongestSubstringWithAtMostKDistinctCharacters().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {


        int left = 0, right = 0;
        int res = 0;
        int len = s.length();
        int num = 0;
        //存储字符，及该字符出现的次数 index = ch-'0'
        // 当这个字符没有出现过，或者说这个字符出现过，但是在当前的这个窗口又被去掉了，都是0；
        int[] map = new int[128];

        while (right < len) {
            Character ch = s.charAt(right);
            int index = ch ;
            //新加入的字符，在以往都没有出现过的话，就加1,总的字符个数加1
            if (map[index] == 0) {
                num++;
            }
            map[index]++;
            //如果当前所有不相同字符的种类
            //移动左指针，直到满足条件为止
            while (num > k) {
                int j = s.charAt(left);
                map[j]--;
                if (map[j] == 0) {
                    num--;
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
