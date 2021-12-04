//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -104 <= matrix[i][j], target <= 104 
// 
// Related Topics 数组 二分查找 
// 👍 437 👎 0


package leetcode.editor.cn;

//Java：搜索二维矩阵
class P74SearchA2dMatrix {
    public static void main(String[] args) {
        Solution solution = new P74SearchA2dMatrix().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            return Find(target,matrix);
        }

        public boolean Find(int target, int[][] array) {
            int m = array.length;
            int n = array[0].length;

            int row = 0;
            int col = n - 1;
            // row小于行数  col减少不能小于0
            while (row < m && col >= 0) {
                int num = array[row][col];
                if (num == target) {
                    return true;
                } else if (target < num) {
                    col--;
                } else {
                    row++;
                }
            }
            return false;
        }
        //二分查找


    }
//leetcode submit region end(Prohibit modification and deletion)

}
