//给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。 
//
// 你可以返回满足此条件的任何数组作为答案。 
//
// 
//
// 示例： 
//
// 输入：[3,1,2,4]
//输出：[2,4,3,1]
//输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 5000 
// 0 <= A[i] <= 5000 
// 
// Related Topics 数组 
// 👍 207 👎 0


package leetcode.editor.cn;

//Java：按奇偶排序数组
 class P905SortArrayByParity {
    public static void main(String[] args) {
        Solution solution = new P905SortArrayByParity().new Solution();
        // TO TEST
        int[] array = new int[]{1,2,3,4,5,6,7};
        int[] res = solution.sortArrayByParity(array);
        for(int a : res){
            System.out.print(a+" ");
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArrayByParity(int[] nums) {
            return reOrderArray(nums);
        }

        public int[] reOrderArray(int[] array) {
            // write code here
            if (array == null || array.length == 0) {
                return array;
            }
            int odd = -1;
            int len = array.length;
            for (int i = 0; i < len; i++) {
                int cur = array[i];
                if (cur % 2 == 1) {
                    swap(array, ++odd, i);
                }
            }
            return array;
        }

        private void swap(int[] array ,int i,int j){
            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
