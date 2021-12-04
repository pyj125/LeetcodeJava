//给定两个字符串, A 和 B。 
//
// A 的旋转操作就是将 A 最左边的字符移动到最右边。 例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea' 。如果在若干次旋转操作之后
//，A 能变成B，那么返回True。 
//
// 
//示例 1:
//输入: A = 'abcde', B = 'cdeab'
//输出: true
//
//示例 2:
//输入: A = 'abcde', B = 'abced'
//输出: false 
//
// 注意： 
//
// 
// A 和 B 长度不超过 100。 
// 
// 👍 127 👎 0


package leetcode.editor.cn;

//Java：旋转字符串
class P796RotateString {
    public static void main(String[] args) {
        Solution solution = new P796RotateString().new Solution();
        // TO TEST
        String s = "abcXYZdef";
        int n = 3;
        String res = solution.LeftRotateString(s, n);
        System.out.println(res);
        String a = "abcd";
        String b = "cdba";
        boolean  t = solution.rotateString(a,b);
        System.out.println(t);
        // (A+A).contains(B)
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean rotateString(String s, String goal) {
            if (s.length() != goal.length()) {
                return false;
            }
            if (s.length() == 0) {
                return true;
            }
            char[] a = s.toCharArray();
            char[] b = goal.toCharArray();
            int len = s.length();
            int cnt = 0;
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    if (a[(i + j) % len] != b[j]) {
                        cnt = 0;
                        break;
                    }
                    //记录以 i开头开始匹配，能够匹配上的字符数
                    cnt++;
                }
                if(cnt == a.length){
                    return true;
                }
            }
            return false;
        }

        public String LeftRotateString(String str, int n) {
            int len = str.length();
            int cnt = n % len;
            if (cnt == 0) {
                return str;
            }
            return str.substring(cnt) + reverseStr(str.substring(0, cnt));
        }

        private String reverseStr(String s) {
            char[] chs = s.toCharArray();
            int i = 0, j = chs.length - 1;
            while (i < j) {
                char tmp = chs[i];
                chs[i] = chs[j];
                chs[j] = tmp;
                i++;
                j--;
            }
            return String.valueOf(chs);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
