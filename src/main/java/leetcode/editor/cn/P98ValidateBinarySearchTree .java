//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 1001 👎 0


package leetcode.editor.cn;
//Java：验证二叉搜索树
class P98ValidateBinarySearchTree{
    public static void main(String[] args) {
        Solution solution = new P98ValidateBinarySearchTree().new Solution();
        // TO TEST
        TreeNode root = new TreeNode(1);
//        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(1);
//        root.left = left;
        root.right = right;

        boolean res = solution.isValidBST(root);
        System.out.println(res);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode pre = null;
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }

        //判断一棵树是否是二叉搜索树 中序遍历
        boolean left = isValidBST(root.left);
        if( !left){
            return false;
        }
        if(pre !=null && pre.val>=root.val){
            return false;
        }
        pre = root;
        return isValidBST(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
