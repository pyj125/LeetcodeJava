//小力将 N 个零件的报价存于数组 `nums`。小力预算为 `target`，假定小力仅购买两个零件，要求购买零件的花费不超过预算，请问他有多少种采购方案。
//
//
//注意：答案需要以 `1e9 + 7 (1000000007)` 为底取模，如：计算初始结果为：`1000000008`，请返回 `1`
//
//
//**示例 1：**
//>输入：`nums = [2,5,3,5], target = 6`
//>
//>输出：`1`
//>
//>解释：预算内仅能购买 nums[0] 与 nums[2]。
//
//**示例 2：**
//>输入：`nums = [2,2,1,9], target = 10`
//>
//>输出：`4`
//>
//>解释：符合预算的采购方案如下：
//>nums[0] + nums[1] = 4
//>nums[0] + nums[2] = 3
//>nums[1] + nums[2] = 3
//>nums[2] + nums[3] = 10
//
//**提示：**
//- `2 <= nums.length <= 10^5`
//- `1 <= nums[i], target <= 10^5`
// Related Topics 数组 双指针 二分查找 排序 
// 👍 33 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//Java：采购方案
class PLCP_28FourXy4Wx {
    public static void main(String[] args) {
        Solution solution = new PLCP_28FourXy4Wx().new Solution();
        // TO TEST
        int[] nums = new int[]{2,2,1,9};
        int target = 10;

        int res = solution.purchasePlans(nums,target);
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int purchasePlans(int[] nums, int target) {
            int res = 0;
            Arrays.sort(nums);
            int left = 0;
            int right = nums.length-1;
            while(left < right){
                int sum = nums[left] + nums[right];
                // begin the left calc, left+1;
                if(sum <= target){
                    res += right-left;
                    left++;
                }else{
                    // two sum > target  lower the sum, right--
                    right--;
                }
            }
            return res%1000000007;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
