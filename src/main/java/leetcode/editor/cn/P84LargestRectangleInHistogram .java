//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。 
//
// 
//
// 
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。 
//
// 
//
// 示例: 
//
// 输入: [2,1,5,6,2,3]
//输出: 10 
// Related Topics 栈 数组 
// 👍 1380 👎 0


package leetcode.editor.cn;

import java.util.Stack;

//Java：柱状图中最大的矩形
class P84LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new P84LargestRectangleInHistogram().new Solution();
        // TO TEST
        int[] arr = new int[]{2, 0, 2};
        int res = solution.largestRectangleArea(arr);
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 单调递增栈 当遇到比当前数小的时候 结算
         * 入栈： 栈为空
         * 对于某个元素 a[i]来看 就是要找到他的左边和右边的第一个比它小的元素，这样就可以对这个元素进行结算
         * 对于单调递增栈而言，进行出栈时的当前元素就是右边的比他小的元素，左边出栈后，不在能出栈的比它还小的元素
         *
         * @param heights
         * @return
         */
        public int largestRectangleArea(int[] heights) {
            if (heights == null || heights.length == 0) {
                return 0;
            }
            int len = heights.length;
            Stack<Integer> stack = new Stack<>();
            int res = 0;
            stack.push(0);
            //如果一直是增序的，最后一个元素无法计算
            for (int i = 0; i <= len; i++) {
                int cur = i == len ? 0 : heights[i];
                while (!stack.isEmpty() && heights[stack.peek()] > cur) {
                    int index = stack.pop();
                    int right = i;
                    //左边的边如何确定 如果这个数弹出后是空的，那么说明左边的数都比它小
                    int left = stack.size() == 0 ? -1 : stack.peek();
                    res = Math.max(res, heights[index] * (right - left - 1));
                }
                stack.push(i);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
