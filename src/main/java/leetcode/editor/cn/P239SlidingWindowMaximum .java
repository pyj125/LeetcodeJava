//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,-1], k = 1
//输出：[1,-1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [9,11], k = 2
//输出：[11]
// 
//
// 示例 5： 
//
// 
//输入：nums = [4,-2], k = 2
//输出：[4] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// -104 <= nums[i] <= 104 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window 
// 👍 957 👎 0


package leetcode.editor.cn;

import java.util.LinkedList;

//Java：滑动窗口最大值
class P239SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new P239SlidingWindowMaximum().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 滑动窗口的最大值
         * 使用一个双端队列来维护窗口的最大值，队列的队头元素就是当前窗口的最大值元素对于的下标
         * 入队：
         * 1、当队列为空
         * 2、当 当前元素比 队列尾部的元素小
         * <p>
         * 出队：
         * 1、队列不为空，队列头部的元素下标已经不再窗口范围内
         * 2、队列不为空，队列头部的元素比当前元素要小
         *
         * @param nums
         * @param k
         * @return
         */
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length == 0 || k <= 0) {
                return null;
            }
            int len = nums.length;
            int[] res = new int[len + 1 - k];
            int index = 0;
            LinkedList<Integer> queue = new LinkedList<>();
            for (int i = 0; i < len; i++) {
                int cur = nums[i];

                if (!queue.isEmpty()) {
                    if (queue.peekFirst() < i + 1 - k) {
                        queue.pollFirst();
                    }
                }
                while (!queue.isEmpty() && nums[queue.peekLast()] < cur) {
                    queue.pollLast();
                }

//                if (queue.isEmpty() || nums[queue.peekLast()] >= cur) {
                    queue.addLast(i);
//                }
                //从第k-1个数开始写入
                if (i >= k - 1) {
                    res[index++] = nums[queue.peekFirst()];
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
