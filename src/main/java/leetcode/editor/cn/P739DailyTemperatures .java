//请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
// 
//
// 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2
//, 1, 1, 0, 0]。 
//
// 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。 
// Related Topics 栈 哈希表 
// 👍 765 👎 0


package leetcode.editor.cn;

import java.util.Stack;

//Java：每日温度
class P739DailyTemperatures {
    public static void main(String[] args) {
        Solution solution = new P739DailyTemperatures().new Solution();
        // TO TEST
        int[] arr = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        solution.dailyTemperatures(arr);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            if (temperatures == null || temperatures.length == 0) {
                return null;
            }
            int len = temperatures.length;

            int[] arr = new int[len];
            //存储元素下标 维护一个单调递减栈
            //栈为空 压入元素 当前元素如果小于=栈顶元素 压栈
            //当前元素如果比栈顶元素大，那么栈顶元素出栈 并且更新arr,表示找到了一个比栈顶元素大的温度
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < len; i++) {
                int cur = temperatures[i];
                //栈为空 压入元素 当前元素如果小于栈顶元素 压栈
                //注意：这里栈中存储的元素是下标，比较的时候要去拿值比较
//                if (stack.isEmpty() || temperatures[stack.peek()] >= cur) {
//                    stack.push(i);
//                } else {
                //栈不为空 栈顶元素小于当前元素
                while (!stack.isEmpty() && temperatures[stack.peek()] < cur) {
                    // 比第 preIndex 个元素更大的元素 是当前元素 第i个元素
                    int preIndex = stack.pop();
                    arr[preIndex] = i - preIndex;
                }
                //这个元素把比它小的元素都弹出后自己也要进栈
                stack.push(i);
//                }
            }
            return arr;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
