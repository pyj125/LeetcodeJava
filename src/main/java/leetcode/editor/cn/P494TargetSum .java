//给你一个整数数组 nums 和一个整数 target 。 
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
// Related Topics 数组 动态规划 回溯 
// 👍 815 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：目标和
class P494TargetSum {
    public static void main(String[] args) {
        Solution solution = new P494TargetSum().new Solution();
        // TO TEST
        StringBuilder sb = new StringBuilder();
        sb.append("ab");
        String tmp = "1234";
        sb.append(tmp);
        sb.delete(sb.length() - tmp.length(), sb.length());


        int[] arr = new int[]{1, 1, 1, 1, 1};
        int target = 3;
        int num = solution.findTargetSumWays(arr, target);


        System.out.println(num);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<String> res = new ArrayList<>();
        int[] flag = new int[]{-1, 1};

        public int findTargetSumWays(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            StringBuilder sb = new StringBuilder();
            dfs(nums, target, 0, 0, sb);

            for (String tmp : res) {
                System.out.println(tmp);
            }
            return res.size();
        }

        private void dfs(int[] nums, int target, int curSum, int index, StringBuilder sb) {
            if (index >= nums.length) {
                if (index == nums.length) {
                    if (curSum == target) {
                        res.add(sb.toString());
                    }
                }
                return;
            }


            //当前的数 nums[index]
            for (int i = index; i < nums.length; i++) {
                //选择当前的数 两种选择，-1，1
                for (int j = 0; j < 2; j++) {
                    curSum = curSum + flag[j] * nums[i];
                    String tmp = (j == 0 ? "-" : "+") + nums[i];
                    sb.append(tmp);
                    dfs(nums, target, curSum, i + 1, sb);
                    sb.delete(sb.length() - tmp.length(), sb.length());
                    curSum = j == 0 ? curSum + nums[i] : curSum - nums[i];
                }

            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
