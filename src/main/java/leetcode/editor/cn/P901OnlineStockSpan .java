//编写一个 StockSpanner 类，它收集某些股票的每日报价，并返回该股票当日价格的跨度。 
//
// 今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。 
//
// 例如，如果未来7天股票的价格是 [100, 80, 60, 70, 60, 75, 85]，那么股票跨度将是 [1, 1, 1, 2, 1, 4, 6]。
// 
//
// 
//
// 示例： 
//
// 输入：["StockSpanner","next","next","next","next","next","next","next"], [[],[10
//0],[80],[60],[70],[60],[75],[85]]
//输出：[null,1,1,1,2,1,4,6]
//解释：
//首先，初始化 S = StockSpanner()，然后：
//S.next(100) 被调用并返回 1，
//S.next(80) 被调用并返回 1，
//S.next(60) 被调用并返回 1，
//S.next(70) 被调用并返回 2，
//S.next(60) 被调用并返回 1，
//S.next(75) 被调用并返回 4，
//S.next(85) 被调用并返回 6。
//
//注意 (例如) S.next(75) 返回 4，因为截至今天的最后 4 个价格
//(包括今天的价格 75) 小于或等于今天的价格。
// 
//
// 
//
// 提示： 
//
// 
// 调用 StockSpanner.next(int price) 时，将有 1 <= price <= 10^5。 
// 每个测试用例最多可以调用 10000 次 StockSpanner.next。 
// 在所有测试用例中，最多调用 150000 次 StockSpanner.next。 
// 此问题的总时间限制减少了 50%。 
// 
// Related Topics 栈 
// 👍 121 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Java：股票价格跨度
class P901OnlineStockSpan {
    public static void main(String[] args) {
        StockSpanner solution = new P901OnlineStockSpan().new StockSpanner();
        // TO TEST
        solution.next(31);
        solution.next(41);
        solution.next(48);
        solution.next(59);
        solution.next(79);
        System.out.println("=====");

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class StockSpanner {
        private Stack<Integer> stack;
        List<Integer> list;

        public StockSpanner() {
            stack = new Stack<Integer>();
            list = new ArrayList<>();
        }


        /**
         * 入栈：当栈为空的时候，当 当前遍历的元素 比 栈顶指针指向的元素要小或者等于
         * 出栈：当 当前元素比栈顶的元素要小或者等于的话，需要出栈，找到一个合适的位置
         *
         * @param price
         * @return
         */
        public int next(int price) {
            list.add(price);
            int res = 1;
            //出栈
            while (!stack.isEmpty() && list.get(stack.peek()) <= price) {
                stack.pop();
            }
            //栈为空，说明前面没有元素比它大，整个size都是比它小或者等的数
            if (!stack.isEmpty()) {
                res = list.size() - 1 - stack.peek();
            } else {
                res = list.size();
            }
            stack.push(list.size() - 1);
            return res;
        }
    }

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
