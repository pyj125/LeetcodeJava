package leetcode.editor.cn.stack;

import java.util.Stack;

public class LC462 {

    public boolean find132pattern(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int len = nums.length;
        //次大的数，中间的数，对于132模式中的2
        int mid = Integer.MIN_VALUE;

        for (int i = len - 1; i >= 0; i--) {
            // mid这个次大的元素有值(132中的2），说明栈肯定不为空，栈中存放着比mid大的元素(132中的3），并且当前元素比mid小(132中的1）
            if(nums[i] < mid){
                return true;
            }
            //单调递减栈 出栈规则：
            // 栈不为空 并且 栈顶元素的值比当前遍历到的元素要小，那么需要一直从栈中弹出元素，直到能放进当前元素
            while (!st.isEmpty() && st.peek() < nums[i]){
                //弹出栈中的元素，并且栈中的元素肯定是依次递增的
//                mid = Math.max(mid,st.pop());
                mid = st.pop();
            }
            // 入栈：当前元素小于或者等于栈顶元素入栈，满足单调递减栈原则
            st.push(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,5,5,5,1,2,4,5};
        LC462 test = new LC462();
        boolean res = test.find132pattern(nums);
        System.out.println(res);
    }
}
