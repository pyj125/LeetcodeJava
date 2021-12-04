//给定一个整数数组 A，返回 A 中最长等差子序列的长度。 
//
// 回想一下，A 的子序列是列表 A[i_1], A[i_2], ..., A[i_k] 其中 0 <= i_1 < i_2 < ... < i_k <= A
//.length - 1。并且如果 B[i+1] - B[i]( 0 <= i < B.length - 1) 的值都相同，那么序列 B 是等差的。 
//
// 
//
// 示例 1： 
//
// 输入：[3,6,9,12]
//输出：4
//解释： 
//整个数组是公差为 3 的等差数列。
// 
//
// 示例 2： 
//
// 输入：[9,4,7,2,10]
//输出：3
//解释：
//最长的等差子序列是 [4,7,10]。
// 
//
// 示例 3： 
//
// 输入：[20,1,15,3,10,5,8]
//输出：4
//解释：
//最长的等差子序列是 [20,15,10,5]。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= A.length <= 2000 
// 0 <= A[i] <= 10000 
// 
// Related Topics 动态规划 
// 👍 130 👎 0


package leetcode.editor.cn;

//Java：最长等差数列
class P1027LongestArithmeticSubsequence {
    public static void main(String[] args) {
        Solution solution = new P1027LongestArithmeticSubsequence().new Solution();
        // TO TEST
        int[] arr = new int[]{3, 6, 9, 12};
        int num = solution.longestArithSeqLength(arr);
        System.out.println(num);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestArithSeqLength(int[] arr) {
            if (arr == null || arr.length == 0) {
                return 0;
            }
            int[][] dp = new int[arr.length][20001];
            int len = arr.length;
            int ans = 2,diff;
            for(int i=0;i<len;i++){
                for(int j=0;j<i;j++){
                    //可能为负数
                    diff = arr[i]-arr[j]+10000;
                    //dp[i][diff] 以i结尾，遍历从[0,i)的数，获取dp[j][diff]的值，看看与他们能否组成等差数列，如果没有，那么自己是一个等差数列组，
                    dp[i][diff] = Math.max(dp[j][diff]+1,2);
                    ans = Math.max(dp[i][diff],ans);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
