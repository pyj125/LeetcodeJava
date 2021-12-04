//给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1]
//输出: 2
//说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。 
//
// 示例 2: 
//
// 
//输入: nums = [0,1,0]
//输出: 2
//说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// nums[i] 不是 0 就是 1 
// 
// Related Topics 哈希表 
// 👍 410 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：连续数组
class P525ContiguousArray {
    public static void main(String[] args) {
        Solution solution = new P525ContiguousArray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 前缀和 + hashmap
         * 把0 写作-1，那么满足条件的区间和为0
         * a[i]= s1 a[j]=s2  a[i+1 - j] s2-s1=k
         * map存储前缀和第一次出现的值，然后如果sum-k在前缀和中存在的话，计算长度
         * @param nums
         * @return
         *
         */
        public int findMaxLength(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int count = 0;
            int maxLen = 0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 1) {
                    count++;
                } else {
                    count--;
                }
                if (map.containsKey(count)) {
                    int preIndex = map.get(count);
                    maxLen = Math.max(i - preIndex, maxLen);
                } else {
                    map.put(count, i);
                }
            }
            return maxLen;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
