//给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。 
//
// 
//
// 进阶：你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？ 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,1,3,2,5]
//输出：[3,5]
//解释：[5, 3] 也是有效的答案。
// 
//
// 示例 2： 
//
// 
//输入：nums = [-1,0]
//输出：[-1,0]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0,1]
//输出：[1,0]
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 3 * 104 
// -231 <= nums[i] <= 231 - 1 
// 除两个只出现一次的整数外，nums 中的其他数字都出现两次 
// 
// Related Topics 位运算 
// 👍 406 👎 0


package leetcode.editor.cn;

//Java：只出现一次的数字 III
class P260SingleNumberIii {
    public static void main(String[] args) {
        Solution solution = new P260SingleNumberIii().new Solution();
        // TO TEST
        String s = "110100010";
        boolean res = solution.checkZeroOnes(s);
        System.out.println(res);

        String s1 = "01111111011110";
        int minJump = 1;
        int maxJump = 9;
        boolean res1 = solution.canReach(s1, minJump, maxJump);
        System.out.println(res1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] singleNumber(int[] nums) {
            return null;
        }

        public boolean checkZeroOnes(String s) {
            if (s == null || s.length() == 0) {
                return false;
            }
            char[] array = s.toCharArray();
            int zero = getLongestChar(array, '0');
            int one = getLongestChar(array, '1');
            if (one > zero) {
                return true;
            }
            return false;

        }

        private int getLongestChar(char[] s, char c) {
            int max = -1;
            int count = 0;
            for (int i = 0; i < s.length; i++) {
                char cur = s[i];
                if (cur != c) {
                    count = 0;
                    continue;
                }
                //是 c 字符
                count++;
                max = Math.max(max, count);
            }
            return max;
        }

        public boolean canReach(String s, int minJump, int maxJump) {
            if (s == null || s.length() == 0) {
                return false;
            }
            char[] arr = s.toCharArray();
            int len = arr.length;
            if (arr[len - 1] != '0') {
                return false;
            }
            boolean flag = false;
            for(int i=0;i<len;i++){
                if(arr[i] == '1'){
                    flag = true;
                    break;
                }
            }
            if(flag == false){
                return true;
            }
            boolean res = dfs(arr, 0, len, minJump, maxJump);
//            boolean res = processArray(arr, minJump, maxJump);
            return res;
        }

        private boolean dfs(char[] arr, int index, int len, int minJump, int maxJump) {
            if (arr[index] != '0') {
                return false;
            }
            if (index == len - 1) {
                return true;
            }
            boolean res = false;
            int min = index + minJump;
            int max = Math.min(index + maxJump, len - 1);
            if(arr[min] == '0' && max == len-1){
                return true;
            }
            for (int i = min; i <= max; i++) {
                if(arr[i] == '1'){
                    continue;
                }
                res |= dfs(arr, i, len, minJump, maxJump);
            }
            return res;
        }

        private boolean processArray(char[] arr, int minJump, int maxJump) {
            int len = arr.length;
            return false;


            //dp[i]表示 [0-i]从0开始可以调到i的位置
//            boolean[] dp = new boolean[len];
//            dp[0] = true;
//            for (int i = 0; i < len; i++) {
//                if (arr[i] == '1') {
//                    dp[i] = false;
//                } else {
//                    //i + minJump <= j <= min(i + maxJump, s.length - 1)
//                    boolean a = i - minJump >= 0 ? dp[i - minJump] : dp[0];
//                    boolean b = i - maxJump >= 0 ? dp[i - maxJump] : dp[0];
//                    dp[i] = a|b;
//                }
//            }
//            return dp[len-1];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
