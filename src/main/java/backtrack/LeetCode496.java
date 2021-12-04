package backtrack;

import java.util.Stack;

public class LeetCode496 {
    public int[] nextGreaterElement(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = -1;
        }
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                int index = stack.pop();
                res[index] = nums[i];
            }
            stack.push(i);
        }
        return res;
    }

    public int[] nextGreaterElementsII(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = -1;
        }
        int n = nums.length;
        for (int i = 0; i < 2 * n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i%n]) {
                int index = stack.pop();
                res[index] = nums[i%n];
            }
            stack.push(i%n);
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode496 s = new LeetCode496();
        int[] nums = new int[]{2, 1, 2, 4, 3};
        int[] res = s.nextGreaterElement(nums);
        int[] res1 = s.nextGreaterElementsII(nums);
        System.out.println(res);
    }
}
