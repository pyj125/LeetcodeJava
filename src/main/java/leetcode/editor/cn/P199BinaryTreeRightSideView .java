//给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 示例: 
//
// 输入: [1,2,3,null,5,null,4]
//输出: [1, 3, 4]
//解释:
//
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
// 
// Related Topics 树 深度优先搜索 广度优先搜索 递归 队列 
// 👍 444 👎 0


package leetcode.editor.cn;

import java.util.*;

//Java：二叉树的右视图
class P199BinaryTreeRightSideView {
    public static void main(String[] args) {
        Solution solution = new P199BinaryTreeRightSideView().new Solution();
        // TO TEST
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
        public List<Integer> rightSideView1(TreeNode root) {

            List<Integer> res = new ArrayList<>();

            Queue<TreeNode> queue = new LinkedList<>();

            if (root != null) {
                queue.offer(root);
            }
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                    //是当前层的最后一个元素
                    if (i == size - 1) {
                        res.add(node.val);
                    }
                }
            }
            return res;
        }

        public List<Integer> rightSideView(TreeNode root) {

             dfs(root,0);
             return res;

        }

        //记录数据
        List<Integer> res = new ArrayList<>();

        private void dfs(TreeNode root,int depth){
            if(root == null){
                return ;
            }
            if(depth == res.size()){
                res.add(root.val);
            }
            depth++;
            dfs(root.right,depth);
            dfs(root.left,depth);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
