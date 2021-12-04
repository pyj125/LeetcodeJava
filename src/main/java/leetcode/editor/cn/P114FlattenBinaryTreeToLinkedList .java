//给你二叉树的根结点 root ，请你将它展开为一个单链表： 
//
// 
// 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。 
// 展开后的单链表应该与二叉树 先序遍历 顺序相同。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,5,3,4,null,6]
//输出：[1,null,2,null,3,null,4,null,5,null,6]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 2000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？ 
// Related Topics 树 深度优先搜索 
// 👍 775 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Java：二叉树展开为链表
class P114FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        Solution solution = new P114FlattenBinaryTreeToLinkedList().new Solution();
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
        public void flatten1(TreeNode root) {
            if (root == null) {
                return;
            }
            Stack<TreeNode> stack = new Stack<>();
            List<TreeNode> list = new ArrayList<>();

            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    list.add(root);
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                root = root.right;
            }
            int size = list.size();
            //每次取前两个数
            for (int i = 1; i < size; i++) {
                TreeNode pre = list.get(i - 1);
                TreeNode cur = list.get(i);
                pre.left = null;
                pre.right = cur;
            }
        }

        /**
         * 采用前驱节点的方式，来进行遍历
         * 前序遍历过程中，对于当前节点，访问完当前节点的左子树的最右边的一个节点后，才会访问当前节点的左子树，
         * 也就是说 只要记录好左子树的最右节点，就可以将它指向当前节点的右子节点，像链表一样连接起来
         * 始终要保持当前节点的右子树
         *
         *
         * 将左子树插入到右子树的地方
         * 将原来的右子树接到左子树的最右边节点
         * 考虑新的右子树的根节点，一直重复上边的过程，直到新的右子树为 null
         *
         * @param root
         */
        public void flatten(TreeNode root) {
            TreeNode cur = root;
            while (cur != null) {
                if(cur.left!=null){
                    TreeNode next = cur.left;
                    TreeNode pre = next;
                    //左子树的最右节点一定是右子树的最右子节点
                    while (pre.right!=null){
                        pre = pre.right;
                    }
                    //如果左子树没有最右子节点，那么前驱节点就是他自己，它指向当前节点的右子树右子树，下一次遍历的时候，就是访问它自己
                    //前驱的右子节点指向当前节点的右子树
                    pre.right = cur.right;
                    cur.left = null;
                    //当前节点的右子节点指向下一个元素，这个元素就是前序遍历的下一个元素，也就是当前节点的左子节点
                    cur.right = next;
                }
                cur = cur.right;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
