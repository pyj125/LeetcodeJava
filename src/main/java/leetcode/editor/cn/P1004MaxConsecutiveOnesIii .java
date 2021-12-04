//给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。 
//
// 返回仅包含 1 的最长（连续）子数组的长度。 
//
// 
//
// 示例 1： 
//
// 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
//输出：6
//解释： 
//[1,1,1,0,0,1,1,1,1,1,1]
//粗体数字从 0 翻转到 1，最长的子数组长度为 6。 
//
// 示例 2： 
//
// 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
//输出：10
//解释：
//[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
//粗体数字从 0 翻转到 1，最长的子数组长度为 10。 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 20000 
// 0 <= K <= A.length 
// A[i] 为 0 或 1 
// 
// Related Topics 双指针 Sliding Window 
// 👍 274 👎 0


package leetcode.editor.cn;
//Java：最大连续1的个数 III
 class P1004MaxConsecutiveOnesIii{
    public static void main(String[] args) {
        Solution solution = new P1004MaxConsecutiveOnesIii().new Solution();
        // TO TEST
        int[] nums = new int[]{1,1,1,0,0,0,1,1,1,1,0};
        int res = solution.longestOnes(nums,2);
        System.out.println(res);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestOnes(int[] nums, int k) {

        //换个说法，就是求取一个子数组中包含k个0的子串长度
        int left=0,right=0;
        int len = nums.length;
        int zero = 0;// zero>k 就要判断情况了
        int res = 0;

        while (right<len){
            if(nums[right] == 0) {
                zero++;
            }
            //判断条件：什么时候右指针先不动，移动左指针
            while (zero>k){
                //需要移动左指针，到第一个0的后面 如果碰到0就减去1
                if(nums[left++]==0){
                    zero--;
                }
            }
            res = Math.max(res,right-left+1);
            right++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
