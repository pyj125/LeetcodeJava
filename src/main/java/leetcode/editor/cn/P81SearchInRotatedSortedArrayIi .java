//已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。 
//
// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，使数组变为 [nums[k], nums
//[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,
//2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。 
//
// 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值 targ
//et ，则返回 true ，否则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,5,6,0,0,1,2], target = 0
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,5,6,0,0,1,2], target = 3
//输出：false 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -104 <= nums[i] <= 104 
// 题目数据保证 nums 在预先未知的某个下标上进行了旋转 
// -104 <= target <= 104 
// 
//
// 
//
// 进阶： 
//
// 
// 这是 搜索旋转排序数组 的延伸题目，本题中的 nums 可能包含重复元素。 
// 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？ 
// 
// Related Topics 数组 二分查找 
// 👍 454 👎 0


package leetcode.editor.cn;

//Java：搜索旋转排序数组 II
class P81SearchInRotatedSortedArrayIi {
    public static void main(String[] args) {
        Solution solution = new P81SearchInRotatedSortedArrayIi().new Solution();
        // TO TEST
        int[] arr = new  int[]{2,5,6,0,0,1,2};
        int num =2;
        boolean a = solution.search(arr,num);
        System.out.println(a);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean search(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return false;
            }
            int len = nums.length;
            int left = 0, right = len - 1;
            while (left <= right) {
                int mid = left +((right - left)>>1);
                // [left,mid]是升序的
                if (nums[mid] == target) {
                    return true;
                }
                //前半段有序
                if (nums[mid] > nums[right]) {
                    //target在有序数组中
                    if (target >= nums[left] && target < nums[mid]) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                } else if (nums[mid] == nums[right]) {
                    right--;
                } else {
                    // [mid+1,right]升序 后半段有序
                    if (target>nums[mid] && target<=nums[right]) {
                        left = mid +1;
                    }else{
                        right = mid;
                    }
                }
            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
