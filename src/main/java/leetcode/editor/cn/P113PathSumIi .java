//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：[[5,4,11,2],[5,8,4,5]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,3], targetSum = 5
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], targetSum = 0
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点总数在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
// 
// 
// Related Topics 树 深度优先搜索 
// 👍 462 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：路径总和 II
 class P113PathSumIi{
    public static void main(String[] args) {
        Solution solution = new P113PathSumIi().new Solution();
        // TO TEST
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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root,0,targetSum,new ArrayList<>(),res);
        return res;
    }

    private void dfs(TreeNode root,Integer curSum,Integer targetSum,List<Integer> list,List<List<Integer>> res){
        if(root == null){
            return;
        }
        list.add(new Integer(root.val));
//        list.add(root.val);
        curSum = curSum + root.val;

        if(root.left == null && root.right ==  null){
            //????????curSum??????????????????????
            if(curSum == targetSum){
                res.add(new ArrayList(list));
            }
            list.remove(list.size()-1);
            return;
        }
        dfs(root.left,curSum,targetSum,list,res);
        dfs(root.right,curSum,targetSum,list,res);
        list.remove(list.size()-1);
    }



}
//leetcode submit region end(Prohibit modification and deletion)

}
