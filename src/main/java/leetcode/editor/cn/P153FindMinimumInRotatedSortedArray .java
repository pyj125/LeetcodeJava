//已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变
//化后可能得到：
// 
// 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2] 
// 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7] 
// 
//
// 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], 
//..., a[n-2]] 。 
//
// 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,4,5,1,2]
//输出：1
//解释：原数组为 [1,2,3,4,5] ，旋转 3 次得到输入数组。
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2]
//输出：0
//解释：原数组为 [0,1,2,4,5,6,7] ，旋转 4 次得到输入数组。
// 
//
// 示例 3： 
//
// 
//输入：nums = [11,13,15,17]
//输出：11
//解释：原数组为 [11,13,15,17] ，旋转 4 次得到输入数组。
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 5000 
// -5000 <= nums[i] <= 5000 
// nums 中的所有整数 互不相同 
// nums 原来是一个升序排序的数组，并进行了 1 至 n 次旋转 
// 
// Related Topics 数组 二分查找 
// 👍 486 👎 0


package leetcode.editor.cn;

//Java：寻找旋转排序数组中的最小值
class P153FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new P153FindMinimumInRotatedSortedArray().new Solution();
        // TO TEST
        int[] nums = new int[]{3, 1, 2};
        int res = solution.findMin(nums);
        System.out.println(res);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMin(int[] nums) {
            if (nums == null && nums.length == 0) {
                return 0;
            }
            return processArray2(nums);
        }

        int fun(int[] array) {
            int len = array.length;

            int left = 0;
            int right = len - 1;
            if (array[0] < array[len - 1]) {
                return array[0];
            }
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int num = array[mid];
                //
                if (num >= array[left]) {
                    if (mid + 1 <= right && num > array[mid + 1]) {
                        return array[mid + 1];
                    }
                    left = mid + 1;
                }
                //如果中间的数大于左边的数 那么[left,mid]是有序的 不在这个区
                else {
                    if (mid - 1 >= left && num < array[mid - 1]) {
                        return num;
                    }
                    right = mid - 1;
                }
            }
            return array[left];
//            return array[left] > array[right] ? array[right] : array[left];
        }

        private int processArray(int[] array) {
            int left = 0;
            int right = array.length - 1;
            //只有第一个数严格小于最后一个数才能代表说是严格递增的
            // 等于的话可能是 123401111  不能说明当前的数最小
            if (array[left] < array[right]) {
                return array[left];
            }
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int num = array[mid];
                //中间的数大于左边的数，左边有序 去右边寻找
                if (num >= array[left]) {
                    //有可能右边的这个数就是要找的数
                    if (mid + 1 <= right && num > array[mid + 1]) {
                        return array[mid + 1];
                    }
                    left = mid + 1;
                } else {
                    //在左边寻找
                    if (mid - 1 >= left && array[mid - 1] > num) {
                        return num;
                    }
                    right = mid - 1;
                }
            }
            return array[left];
        }


        private int processArray1(int[] array) {
            int left = 0;
            int right = array.length - 1;
            //只有第一个数严格小于最后一个数才能代表说是严格递增的
            // 等于的话可能是 123401111  不能说明当前的数最小

            while (left < right) {
                if (array[left] < array[right]) {
                    return array[left];
                }
                int mid = left + (right - left) / 2;
                int num = array[mid];
                //中间的数大于左边的数，左边有序 去右边寻找
                if (num > array[left]) {
                    left = mid + 1;
                } else if (num < array[left]) {
                    if (mid - 1 >= 0 && array[mid - 1] > num) {
                        return num;
                    }
                    right = mid;
                }
            }
            return array[left];
        }

        private int processArray2(int[] array) {
            int left = 0;
            int right = array.length - 1;
            //只有第一个数严格小于最后一个数才能代表说是严格递增的
            // 等于的话可能是 123401111  不能说明当前的数最小

            while (left < right) {
//                if (array[left] < array[right]) {
//                    return array[left];
//                }
                int mid = left + (right - left) / 2;
                int num = array[mid];
                //中间的数大于左边的数，左边有序 去右边寻找
                if (num > array[right]) {
                    left = mid + 1;
                } else  {
                    right = mid;
                }
            }
            return array[left];
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
