//如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。 
//
// 只有给定的树是单值二叉树时，才返回 true；否则返回 false。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[1,1,1,1,1,null,1]
//输出：true
// 
//
// 示例 2： 
//
// 
//
// 输入：[2,2,2,5,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 给定树的节点数范围是 [1, 100]。 
// 每个节点的值都是整数，范围为 [0, 99] 。 
// 
// Related Topics 树 
// 👍 77 👎 0


package leetcode.editor.cn;

//Java：单值二叉树
class P965UnivaluedBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P965UnivaluedBinaryTree().new Solution();
        // TO TEST
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
        public boolean isUnivalTree1(TreeNode root) {
            if (root == null) {
                return true;
            }
            if(root.left==null && root.right==null){
                return true;
            }
            if (root.left != null && root.right == null) {
                return root.val==root.left.val && isUnivalTree(root.left);
            }
            if (root.right != null && root.left == null) {
                return root.val==root.right.val && isUnivalTree(root.right);
            }
            return root.val==root.left.val && root.val==root.right.val && isUnivalTree(root.left) && isUnivalTree(root.right);
        }

        public boolean isUnivalTree(TreeNode root) {
            if (root == null) {
                return true;
            }
//            if(root.left==null && root.right==null){
//                return true;
//            }
            //左子树非空 并且左子树的值不等于根节点的值 返回错误
            if (root.left != null && root.val != root.left.val) {
                return false;
            }
            if (root.right != null && root.val != root.right.val) {
                return false;
            }
            //到这里 要么是左右子树都是空 要么是左右子树都不是空并且值相同
            return  isUnivalTree(root.left) && isUnivalTree(root.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
