//给定一个字符串 s ，找出 至多 包含两个不同字符的最长子串 t ，并返回该子串的长度。 
//
// 示例 1: 
//
// 输入: "eceba"
//输出: 3
//解释: t 是 "ece"，长度为3。
// 
//
// 示例 2: 
//
// 输入: "ccaabbb"
//输出: 5
//解释: t 是 "aabbb"，长度为5。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 112 👎 0


package leetcode.editor.cn;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

//Java：至多包含两个不同字符的最长子串
class P159LongestSubstringWithAtMostTwoDistinctCharacters {
    public static void main(String[] args) {
        Solution solution = new P159LongestSubstringWithAtMostTwoDistinctCharacters().new Solution();
        // TO TEST
        String s = "abcabcabc";
        int res = solution.lengthOfLongestSubstringTwoDistinct(s);
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstringTwoDistinct1(String s) {
            //最多只包含2个重复字符的最长子串
            //滑动窗口

            int left = 0, right = 0;
            int res = 0;
            int len = s.length();
            int num = 0;
            //存储字符，及该字符出现的次数
            Map<Character, Integer> map = new HashMap<>();

            while (right < len) {
                Character ch = s.charAt(right);
                //[left,right]区间上已经有2个字符了，并且当前字符从来没出现过 如果被删除了为0也要考虑  出现过值为0，
                if (!map.containsKey(ch) && num >= 2 || (map.containsKey(ch) && map.get(ch) == 0)) {
                    //left开始遍历
                    map.put(ch, 1);
                    num++;
                    while (num > 2) {
                        Character left_char = s.charAt(left);
                        map.put(left_char, map.get(left_char) - 1);
                        if (map.get(left_char) == 0) {
                            num--;
                        }
                        left++;
                    }
                } else if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch) + 1);
                } else {
                    //不被包含 新增字符
                    map.put(ch, 1);
                    num++;
                }
                res = Math.max(res, right - left + 1);
                right++;
            }
            return res;
        }

        public int lengthOfLongestSubstringTwoDistinct2(String s) {
            //最多只包含2个重复字符的最长子串
            //滑动窗口
            int left = 0, right = 0;
            int res = 0;
            int len = s.length();
            int num = 0;

            //存储字符，及该字符最后一次出现的位置
            Map<Character, Integer> map = new HashMap<>();

            while (right < len) {
                Character ch = s.charAt(right);

                if (map.size() < 3) {
                    map.put(ch, right);
                }

                if (map.size() == 3) {
                    //获取并删除最左边的那个元素
                    int del_index = Collections.min(map.values());
                    map.remove(s.charAt(del_index));
                    left = del_index + 1;

                }
                res = Math.max(res, right - left + 1);
                right++;
            }
            return res;
        }


        public int lengthOfLongestSubstringTwoDistinct(String s) {
            int left = 0, right = 0;
            int res = 0;
            int len = s.length();
            int num = 0;
            //存储字符，及该字符出现的次数 index = ch-'0'
            // 当这个字符没有出现过，或者说这个字符出现过，但是在当前的这个窗口又被去掉了，都是0；
            int[] map = new int[128];

            while (right < len) {
                Character ch = s.charAt(right);
                int index = ch - '0';
                //新加入的字符，在以往都没有出现过的话，就加1,总的字符个数加1
                if (map[index] == 0) {
                    num++;
                }
                map[index]++;
                //如果当前所有不相同字符的种类
                //移动左指针，直到满足条件为止
                while (num > 2) {
                    int j = s.charAt(left) - '0';
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
