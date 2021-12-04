//给定一个字符串，逐个翻转字符串中的每个单词。 
//
// 说明： 
//
// 
// 无空格字符构成一个 单词 。 
// 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。 
// 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。 
// 
//
// 
//
// 示例 1： 
//
// 输入："the sky is blue"
//输出："blue is sky the"
// 
//
// 示例 2： 
//
// 输入："  hello world!  "
//输出："world! hello"
//解释：输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
// 
//
// 示例 3： 
//
// 输入："a good   example"
//输出："example good a"
//解释：如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
// 
//
// 示例 4： 
//
// 输入：s = "  Bob    Loves  Alice   "
//输出："Alice Loves Bob"
// 
//
// 示例 5： 
//
// 输入：s = "Alice does not even like bob"
//输出："bob like even not does Alice"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 包含英文大小写字母、数字和空格 ' ' 
// s 中 至少存在一个 单词 
// 
//
// 
// 
//
// 
//
// 进阶： 
//
// 
// 请尝试使用 O(1) 额外空间复杂度的原地解法。 
// 
// Related Topics 字符串 
// 👍 323 👎 0


package leetcode.editor.cn;

//Java：翻转字符串里的单词
class P151ReverseWordsInAString {
    public static void main(String[] args) {
        Solution solution = new P151ReverseWordsInAString().new Solution();
        // TO TEST
        String s = "   nowcoder.   a am I  ";
        String res = solution.reverseWords(s);
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String str) {
            if (str == null || str.length() == 0) {
                return str;
            }
            char[] array = str.toCharArray();
            int len = array.length;
            reverseStr(array, 0, len - 1);
            String sb = trimStr(array);
            return reverseEach(sb.toCharArray());
        }

        public String ReverseSentence(String str) {
            if (str == null || str.length() == 0) {
                return str;
            }
            char[] array = str.toCharArray();
            int len = array.length;
            reverseStr(array, 0, len - 1);
            //去掉单词前后的空格
            int left = 0, right = len - 1;
            while (array[left] == ' ') {
                left++;
            }
            if (left <= right) {
                while (array[right] == ' ') {
                    right--;
                }
            } else {
                return "";
            }
            int start = -1, end = -1;
            for (int i = left; i <= right; i++) {
                //如果当前的字符不是空格
                if (array[i] != ' ') {
                    //当前数不为空，前一个数为空 那么这个数就是开头元素
                    if (i == left || array[i - 1] == ' ') {
                        start = i;
                    }
                    //当前数时最后一个元素 或者下一个元素是空字符，end才赋值，否则还是-1
                    if (i == right || array[i + 1] == ' ') {
                        end = i;
                    }

                }
                //如果遇到的是空格，left和right就不会变化 就不用去调整
                if (start != -1 && end != -1) {
                    reverseStr(array, start, end);
                    start = -1;
                    end = -1;
                }

            }
            return String.valueOf(array).substring(left, right - left + 1);

        }

        private String trimStr(char[] array) {
            int len = array.length;
            int left = 0, right = len - 1;
            //去掉单词前后的空格
            while (left <= right && array[left] == ' ') {
                left++;
            }
            while (left <= right && array[right] == ' ') {
                right--;
            }
            StringBuilder sb = new StringBuilder();
            while (left <= right) {
                char c = array[left];
                if (c != ' ') {
                    sb.append(c);
                } else {
                    //当前字符为空，前一个字符不为空，那么这个空字符可以加入
                    if (sb.charAt(sb.length() - 1) != ' ') {
                        sb.append(c);
                    }
                }
                ++left;
            }
            return sb.toString();
        }

        private String reverseEach(char[] s) {
            int len = s.length;
            int start = 0, end = 0;
            while (start < len) {
                // start最开始就是0，end=start,end开始移动
                while (end < len && s[end] != ' ') {
                    end++;
                }
                //[start,end)为单词
                reverseStr(s, start, end - 1);
                //更新start end
                start = end + 1;
                end = start;
            }
            return String.valueOf(s);
        }

        private void reverseStr(char[] s, int i, int j) {
            while (i < j) {
                char tmp = s[i];
                s[i] = s[j];
                s[j] = tmp;
                i++;
                j--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
