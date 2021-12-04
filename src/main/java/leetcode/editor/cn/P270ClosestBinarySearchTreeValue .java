//给定一个不为空的二叉搜索树和一个目标值 target，请在该二叉搜索树中找到最接近目标值 target 的数值。 
//
// 注意： 
//
// 
// 给定的目标值 target 是一个浮点数 
// 题目保证在该二叉搜索树中只会存在一个最接近目标值的数 
// 
//
// 示例： 
//
// 输入: root = [4,2,5,1,3]，目标值 target = 3.714286
//
//    4
//   / \
//  2   5
// / \
//1   3
//
//输出: 4
// 
// Related Topics 树 二分查找 
// 👍 78 👎 0


package leetcode.editor.cn;

import java.util.WeakHashMap;

//Java：最接近的二叉搜索树值
class P270ClosestBinarySearchTreeValue {
    public static void main(String[] args) {
        Solution solution = new P270ClosestBinarySearchTreeValue().new Solution();
        // TO TEST
        TreeNode root = new TreeNode(4);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(5);
        TreeNode c = new TreeNode(1);
        TreeNode d = new TreeNode(3);
        root.left = a;
        root.right = b;
        a.left =c;
        a.right=d;
        int res = solution.closestValue(root,3.714286);
        System.out.println(res);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public int closestValue(TreeNode root, double target) {
            //目标数在这两个数中间
            TreeNode next_large = null, pre_less = null;
            TreeNode cur = root;

            while (cur != null) {
                //当前的数小于目标，往目标的左边走
                if (cur.val < target) {
                    //那么当前的这个数可能是 比目标小的最近的数
                    if (pre_less == null || cur.val > pre_less.val) {
                        pre_less = cur;
                    }
                    cur = cur.right;
                } else {
                    //当前的这个值比目标大，它可能是下一个大的数备选项   当前这个值小于之前的值
                    // == null ||  后继为空 或者后继不为空但是值比之前的大
                    if (next_large == null || cur.val < next_large.val) {
                        next_large = cur;
                    }
                    cur = cur.left;
                }
            }
            if(pre_less == null){
                return next_large.val;
            }
            if(next_large == null){
                return pre_less.val;
            }

            double a = target - pre_less.val;
            double b = next_large.val - target;

            if (a > b) {
                return next_large.val;
            } else {
                return pre_less.val;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
