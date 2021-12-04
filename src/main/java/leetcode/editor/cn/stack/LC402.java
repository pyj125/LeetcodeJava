package leetcode.editor.cn.stack;

import java.util.Stack;

public class LC402 {

    /***
     * 高位数字越小越好，因此我们后面遇到较小的数字的时候，可以看看前面的数字是不是可以去除，用当前的数来做高位
     * 单调栈实现：
     *  压栈：
     *      1）栈为空，直接压入 （要考虑到前导0，如果此时栈为空，但是当前元素是0，那么就不把这个元素压栈）
     *      2）栈不为空，当前的数字比栈顶的元素大，那么可以压入
     *  出栈：
     *      1）栈不为空，并且栈顶的元素比当前访问到的元素要大，如果当前还有删除的机会的话，那么可以将其出栈并删除 直到遇到一个比当前数小或者等的
     * @param num
     * @param k
     * @return
     */
    public String removeKdigits(String num, int k) {
        char[] arr = num.toCharArray();
        Stack<Character> st = new Stack<>();
        int len = arr.length;
        int cnt = 0;

        //所有字符都要去除
        if (k == len) {
            return "0";
        }

        for (int i = 0; i < len; i++) {
            //递增栈 出栈 : 栈不为空，且栈顶元素的字符大于当前元素 并且当前删除的字符数还超过要求 同时满足这3个条件才能进行出栈操作
            while (!st.isEmpty() && st.peek() > arr[i] && cnt < k) {
                st.pop();
                cnt++;
            }
            // 栈为空并且当前元素是0不压栈，其余情况压栈
            if (!st.isEmpty() || arr[i] != '0') {
                st.push(arr[i]);
            }

        }
        // 去除字符的数目还没有完成，可能一开始就是有序，如 12345 k=2
        // 因为前导0没有压栈，所以栈的数量可能比此时还需要去除的字符数小
        while (!st.isEmpty() && k - cnt > 0) {
            st.pop();
            cnt++;
        }

        if (st.isEmpty()) {
            return "0";
        }

        // 栈中元素全部弹出并拼接处理
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        String result = sb.reverse().toString();
        return result;
    }

//    1432219

    public static void main(String[] args) {
        String num = "10001";
        int k = 4;
        LC402 t = new LC402();
        String res = t.removeKdigits(num, k);
        System.out.println(res);
    }
}
