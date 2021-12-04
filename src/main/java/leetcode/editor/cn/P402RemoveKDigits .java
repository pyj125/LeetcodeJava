//给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。 
// 
//
// 示例 1 ： 
//
// 
//输入：num = "1432219", k = 3
//输出："1219"
//解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
// 
//
// 示例 2 ： 
//
// 
//输入：num = "10200", k = 1
//输出："200"
//解释：移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
// 
//
// 示例 3 ： 
//
// 
//输入：num = "10", k = 2
//输出："0"
//解释：从原数字移除所有的数字，剩余为空就是 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= num.length <= 105 
// num 仅由若干位数字（0 - 9）组成 
// 除了 0 本身之外，num 不含任何前导零 
// 
// Related Topics 栈 贪心 字符串 单调栈 
// 👍 605 👎 0


package leetcode.editor.cn;

import java.util.Stack;

//Java：移掉 K 位数字
class P402RemoveKDigits {
    public static void main(String[] args) {
        Solution solution = new P402RemoveKDigits().new Solution();
        // TO TEST
        String num = "10001";
        String res = solution.removeKdigits(num,4);
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

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
            if (num == null || num.length() == 0 || k == num.length()) {
                return "0";
            }
            char[] arr = num.toCharArray();
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < arr.length; i++) {

                while (!stack.isEmpty() && arr[stack.peek()]>arr[i] && k>0 ){
                    stack.pop();
                    k--;
                }
                stack.push(i);


            }

            // k 值可能还没有用完
            while (k>0){
                stack.pop();
                k--;
            }

            // 栈中都没有元素了 返回本身
            if (stack.isEmpty()) {
                return "0";
            }

            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(arr[stack.pop()]);
            }
            String result = sb.reverse().toString();
            return result;


        }


        public String removeKdigits2(String num, int k) {
            char[] ch = num.toCharArray();
            int cnt = 0;
            Stack<Character> stack = new Stack<>();
            if (ch.length == k) {
                return "0";
            }
            for (int i = 0; i < ch.length; i++) {
                //??????????????? ??????
                while (!stack.isEmpty() && stack.peek() > ch[i] && k > 0) {
                    //?????????k????????????????
                    stack.pop();
                    k--;
                }
                //????0 ??? ???????0????
                // ???? ?? ??????0 ??
                if (!stack.isEmpty() || ch[i] != '0') {
                    stack.push(ch[i]);
                }else{
                    if(k>0){
                        k--;
                    }
                }
            }
            //***** ???????????? ??? k ????????cnt ?????? ?????????
            while (k > 0) {
                stack.pop();
                k--;
            }
            if (stack.isEmpty()) {
                return "0";
            }

            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            String result = sb.reverse().toString();

//            System.out.println(result);
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
