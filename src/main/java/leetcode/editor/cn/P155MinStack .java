//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 
// push(x) —— 将元素 x 推入栈中。 
// pop() —— 删除栈顶的元素。 
// top() —— 获取栈顶元素。 
// getMin() —— 检索栈中的最小元素。 
// 
//
// 
//
// 示例: 
//
// 输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// pop、top 和 getMin 操作总是在 非空栈 上调用。 
// 
// Related Topics 栈 设计 
// 👍 917 👎 0


package leetcode.editor.cn;

import java.util.Stack;

//Java：最小栈
class P155MinStack {
    public static void main(String[] args) {
        MinStack solution = new P155MinStack().new MinStack();
        // TO TEST
        solution.push(2);
        System.out.println(solution.getMin());
        solution.push(1);
        System.out.println(solution.getMin());

        solution.push(5);
        System.out.println(solution.getMin());

        solution.push(4);
        System.out.println(solution.getMin());

        solution.push(0);
        System.out.println(solution.getMin());

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {
        // 用于存储最小元素
        Stack<Integer> stackData;
        Stack<Integer> stackMin;

        //用于存储其他元素

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stackData = new Stack<>();
            stackMin = new Stack<>();
        }

        /**
         * 当前集合为空，需要压入Stackmin 当前的元素<= 最小元素，也需要将其写入最小栈
         * @param val
         */
        public void push(int val) {
            if (stackMin.isEmpty()) {
                stackMin.push(val);
            } else if (stackMin.peek() >= val) {
                stackMin.push(val);
            }
            stackData.push(val);
        }

        public void pop() {
            if(!stackData.isEmpty()){
                int val = stackData.pop();
                if(val==stackMin.peek()){
                    stackMin.pop();
                }
            }

        }

        public int top() {
            if(!stackData.isEmpty()){
                return stackData.peek();
            }
            throw new RuntimeException("栈中元素为空，此操作非法");
        }

        public int getMin() {
            if(!stackMin.isEmpty()){
                return stackMin.peek();
            }
            throw new RuntimeException("栈中元素为空，此操作非法");
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
