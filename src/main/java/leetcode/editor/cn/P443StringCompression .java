//给定一组字符，使用原地算法将其压缩。 
//
// 压缩后的长度必须始终小于或等于原数组长度。 
//
// 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。 
//
// 在完成原地修改输入数组后，返回数组的新长度。 
//
// 
//
// 进阶： 
//你能否仅使用O(1) 空间解决问题？ 
//
// 
//
// 示例 1： 
//
// 输入：
//["a","a","b","b","c","c","c"]
//
//输出：
//返回 6 ，输入数组的前 6 个字符应该是：["a","2","b","2","c","3"]
//
//说明：
//"aa" 被 "a2" 替代。"bb" 被 "b2" 替代。"ccc" 被 "c3" 替代。
// 
//
// 示例 2： 
//
// 输入：
//["a"]
//
//输出：
//返回 1 ，输入数组的前 1 个字符应该是：["a"]
//
//解释：
//没有任何字符串被替代。
// 
//
// 示例 3： 
//
// 输入：
//["a","b","b","b","b","b","b","b","b","b","b","b","b"]
//
//输出：
//返回 4 ，输入数组的前4个字符应该是：["a","b","1","2"]。
//
//解释：
//由于字符 "a" 不重复，所以不会被压缩。"bbbbbbbbbbbb" 被 “b12” 替代。
//注意每个数字在数组中都有它自己的位置。
// 
//
// 
//
// 提示： 
//
// 
// 所有字符都有一个ASCII值在[35, 126]区间内。 
// 1 <= len(chars) <= 1000。 
// 
// Related Topics 字符串 
// 👍 184 👎 0


package leetcode.editor.cn;

//Java：压缩字符串
class P443StringCompression {
    public static void main(String[] args) {
        Solution solution = new P443StringCompression().new Solution();
        // TO TEST
        String s = "a";

        int res = solution.compress(s.toCharArray());
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int compress(char[] chars) {
            if (chars == null || chars.length == 0) {
                return 0;
            }
            //index为写入的字符 count为计算这一区间满足条件的个数
            int index = 0, count = 0;
            //当前遍历的字符
            char cur = chars[0];
            for (int i = 0; i < chars.length; i++) {
                if (cur == chars[i]) {
                    count++;
                } else {
                    chars[index++] = cur;
                    if (count > 1) {
                        for (char c : String.valueOf(count).toCharArray()) {
                            chars[index++] = c;
                        }
                    }
                    count = 1;
                    cur = chars[i];
                }
            }
            chars[index++] = cur;
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[index++] = c;
                }
            }
            return index;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
