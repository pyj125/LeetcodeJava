//给你一个字符串 S，请你删去其中的所有元音字母（ 'a'，'e'，'i'，'o'，'u'），并返回这个新字符串。 
//
// 
//
// 示例 1： 
//
// 输入："leetcodeisacommunityforcoders"
//输出："ltcdscmmntyfrcdrs"
// 
//
// 示例 2： 
//
// 输入："aeiou"
//输出：""
// 
//
// 
//
// 提示： 
//
// 
// S 仅由小写英文字母组成。 
// 1 <= S.length <= 1000 
// 
// Related Topics 字符串 
// 👍 15 👎 0


package leetcode.editor.cn;

//Java：删去字符串中的元音
 class P1119RemoveVowelsFromAString {
    public static void main(String[] args) {
        Solution solution = new P1119RemoveVowelsFromAString().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeVowels(String s) {
            String param = "aeiou";
            StringBuilder sb = new StringBuilder();
            char[] t = s.toCharArray();
            for (int i = 0; i < t.length; i++) {
                if(isVowel(t[i])){
                    continue;
                }
                sb.append(t[i]);
            }
            return sb.toString();
        }
        private boolean isVowel(char ch){
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                return true;
            }
            return false;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
