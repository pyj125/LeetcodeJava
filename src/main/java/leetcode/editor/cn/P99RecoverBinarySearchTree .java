package leetcode.editor.cn;
//给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。
//
// 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用常数空间的解决方案吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,3,null,null,2]
//输出：[3,1,null,null,2]
//解释：3 不能是 1 左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
// 
//
// 示例 2： 
//
// 
//输入：root = [3,1,4,null,null,2]
//输出：[2,1,4,null,null,3]
//解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。 
//
// 
//
// 提示： 
//
// 
// 树上节点的数目在范围 [2, 1000] 内 
// -231 <= Node.val <= 231 - 1 
// 
// Related Topics 树 深度优先搜索 
// 👍 443 👎 0


import java.util.Stack;

//Java：恢复二叉搜索树
class P99RecoverBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new P99RecoverBinarySearchTree().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class tree.leetcode.editor.cn.TreeNode {
     * int val;
     * tree.leetcode.editor.cn.TreeNode left;
     * tree.leetcode.editor.cn.TreeNode right;
     * tree.leetcode.editor.cn.TreeNode() {}
     * tree.leetcode.editor.cn.TreeNode(int val) { this.val = val; }
     * tree.leetcode.editor.cn.TreeNode(int val, tree.leetcode.editor.cn.TreeNode left, tree.leetcode.editor.cn.TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {

        TreeNode errorOne = null;
        TreeNode errorTwo = null;
        public void recoverTree(TreeNode root) {
            //是一个二叉树，采用中序遍历，是一个递增的序列，如果碰到前一个数据比后一个数据大，那么可能是这两个数交换了，相邻的
            if(root == null){
                return;
            }
            TreeNode pre = null;

            Stack<TreeNode> st = new Stack<>();
            while(root!=null || !st.isEmpty()){
                while (root!=null){
                    st.push(root);
                    root = root.left;
                }
                TreeNode temp = st.pop();
                if(pre!=null && pre.val>temp.val){
                    if(errorOne == null){
                        errorOne = pre;
                        errorTwo = temp;
                    }else{
                        errorTwo = temp;
                    }
                }
                pre = temp;
                root =  temp.right;
            }

            int a = errorOne.val;
            errorOne.val = errorTwo.val;
            errorTwo.val = a;


            return;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
