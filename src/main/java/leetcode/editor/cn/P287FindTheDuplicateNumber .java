//给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。 
//
// 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,4,2,2]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,1,3,4,2]
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1]
//输出：1
// 
//
// 示例 4： 
//
// 
//输入：nums = [1,1,2]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 3 * 104 
// nums.length == n + 1 
// 1 <= nums[i] <= n 
// nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次 
// 
//
// 
//
// 进阶： 
//
// 
// 如何证明 nums 中至少存在一个重复的数字? 
// 你可以在不修改数组 nums 的情况下解决这个问题吗？ 
// 你可以只用常量级 O(1) 的额外空间解决这个问题吗？ 
// 你可以设计一个时间复杂度小于 O(n2) 的解决方案吗？ 
// 
// Related Topics 数组 双指针 二分查找 
// 👍 1225 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//Java：寻找重复数
class P287FindTheDuplicateNumber {
    public static void main(String[] args) {
        Solution solution = new P287FindTheDuplicateNumber().new Solution();
        // TO TEST
        int[] array = new int[]{2,3,1,0,2,5,3};
        int res = solution.findDuplicate2(array);
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findDuplicate1(int[] nums) {
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] == nums[i + 1]) {
                    return nums[i];
                }
            }
            return -1;
        }

        //修改数组的情况下
        public int findDuplicate2(int[] nums) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            for (int i = 0; i < nums.length; i++) {
                // 下标 比 下标对应的数 小1 那么就符合条件，否则继续迭代
                while (nums[i] != i + 1) {
                    //当前下标i 对应的数 nums[i]
                    //标准情况下对应的下标 nums[i]-1 对应的值是num[num[i]-1]
                    if (nums[nums[i] - 1] == nums[i]) {
                        // 在下标i 和 nums[i]-1 位置都出现了
                        return nums[i];
                    }
                    swap(nums, i, nums[i] - 1);
                }
            }
            return -1;
        }

        //不修改数组的情况

        private void swap(int[] array, int i, int j) {
            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }

        public int findDuplicate(int[] nums) {
            int slow = nums[0], fast = nums[nums[0]];
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }
            //找到环的入口，slow = fast 指针指向了同一个数
            slow = 0;
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[fast];
            }
            //注意返回的是slow
            return slow;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
