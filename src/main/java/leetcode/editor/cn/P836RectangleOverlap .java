//矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。矩形的上下边平行于 x 
//轴，左右边平行于 y 轴。 
//
// 如果相交的面积为 正 ，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。 
//
// 给出两个矩形 rec1 和 rec2 。如果它们重叠，返回 true；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：rec1 = [0,0,2,2], rec2 = [1,1,3,3]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：rec1 = [0,0,1,1], rec2 = [1,0,2,1]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：rec1 = [0,0,1,1], rec2 = [2,2,3,3]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// rect1.length == 4 
// rect2.length == 4 
// -109 <= rec1[i], rec2[i] <= 109 
// rec1[0] <= rec1[2] 且 rec1[1] <= rec1[3] 
// rec2[0] <= rec2[2] 且 rec2[1] <= rec2[3] 
// 
// Related Topics 数学 
// 👍 207 👎 0


package leetcode.editor.cn;
//Java：矩形重叠
class P836RectangleOverlap{
    public static void main(String[] args) {
        Solution solution = new P836RectangleOverlap().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x1 = rec1[0];
        int y1 = rec1[1];
        int x2 = rec1[2];
        int y2 = rec1[3];

        int x3 = rec2[0];
        int y3 = rec2[1];
        int x4 = rec2[2];
        int y4 = rec2[3];

//        x1,x2,x3,x4;
        //投影是否有重叠 两个线段是否有重叠 第二坐标比较的最小 大于第一位最大的
       return Math.min(x2,x4)>Math.max(x1,x3) && Math.min(y2,y4)>Math.max(y1,y3);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
