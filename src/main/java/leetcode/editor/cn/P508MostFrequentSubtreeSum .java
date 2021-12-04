//给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。 
//
// 你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。 
//
// 
//
// 示例 1： 
//输入: 
//
//   5
// /  \
//2   -3
// 
//
// 返回 [2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。 
//
// 示例 2： 
//输入： 
//
//   5
// /  \
//2   -5
// 
//
// 返回 [2]，只有 2 出现两次，-5 只出现 1 次。 
//
// 
//
// 提示： 假设任意子树元素和均可以用 32 位有符号整数表示。 
// Related Topics 树 哈希表 
// 👍 108 👎 0


package leetcode.editor.cn;

import java.util.*;

//Java：出现次数最多的子树元素和
class P508MostFrequentSubtreeSum {
    public static void main(String[] args) {
        Solution solution = new P508MostFrequentSubtreeSum().new Solution();
        // TO TEST
        TreeNode root = new TreeNode(5);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(-5);
        root.left = a;
        root.right = b;
        int[] res = solution.findFrequentTreeSum(root);
        System.out.println(res);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {

        Map<Integer, Integer> freq = new HashMap<>();
        public int[] findFrequentTreeSum(TreeNode root) {
            getNodeGain(root);
            int max_f = Integer.MIN_VALUE;
            for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
                int value = entry.getValue();
                if(value>max_f){
                    max_f =value;
                }
            }
            List<Integer> temp = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
                int value = entry.getValue();
                if(value == max_f){
                    temp.add(entry.getKey());
                }
            }
            int[] res = new int[temp.size()];
            for(int i=0;i<temp.size();i++){
                res[i] = temp.get(i);
            }
            return res;
        }

        int getNodeGain(TreeNode root) {
            if (root == null) {
                return 0;
            }
            //先左右后自己
            int left = getNodeGain(root.left);
            int right = getNodeGain(root.right);
            int gain = left + right + root.val;
            if (freq.containsKey(gain)) {
                freq.put(gain, freq.get(gain) + 1);
//                int temp=freq.get(gain) + 1;
                // maxcount 全局变量
//                if(maxcount<temp) maxcount=temp;//比较并更新“子树数元素和”的最大重复个数
            } else {
                freq.put(gain, 1);
            }
            return gain;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
