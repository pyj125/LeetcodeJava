//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法 
// 👍 1074 👎 0


package leetcode.editor.cn;

import java.util.Scanner;

//Java：数组中的第K个最大元素
class P215KthLargestElementInAnArray {
    public static void main1(String[] args) {
        Solution solution = new P215KthLargestElementInAnArray().new Solution();
        // TO TEST
        int[] nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        int tar = solution.findKthLargest(nums, 4);
        System.out.println(tar);
        solution.sort3(nums);
        System.out.println("===");
    }


    int fun(int[] array){
        int len = array.length;

        int left = 0;
        int right = len-1;
        if(array[0]<array[len-1]){
            return array[0];
        }
        while(left<=right){
            int mid = left + (right-left)/2;
            int num = array[mid];
            //
            if(num>=array[left]){
                if(num>array[mid+1] && (mid+1<=right)){
                    return array[mid+1];
                }
                //如果中间的数大于左边的数 那么[left,mid]是有序的 不在这个区间
                left = mid+1;
            }else{
                if(num<array[mid-1] && (mid-1>=left)){
                    return array[mid-1];
                }
                right = mid - 1;
            }
        }
        return array[left]>array[right]?array[right]:array[left];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
//         System.out.println(a);



        System.out.println("Hello World!");

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest1(int[] nums, int k) {
            //维护一个小根堆
            int[] heap = new int[k];
            for (int i = 0; i < k; i++) {
                heapInsert(heap, nums[i], i);
            }
            for (int i = k; i < nums.length; i++) {
                if (nums[i] > heap[0]) {
                    heap[0] = nums[i];
                    //下沉操作
                    heapify(heap, 0, k);
                }
            }
            return heap[0];
        }


        /**
         * 向堆中插入元素 初始化前k个元素
         *
         * @param arr
         * @param num
         * @param index
         */
        private void heapInsert(int[] arr, int num, int index) {
            arr[index] = num;
            while (index != 0) {
                //上浮过程，父节点的值比子节点小满足条件，否则迭代交换
                int parent = (index - 1) / 2;
                if (arr[parent] > arr[index]) {
                    swap(arr, parent, index);
                    index = parent;
                } else {
                    break;
                }
            }
        }

        private void heapify(int[] arr, int index, int heapSize) {
            int left = index * 2 + 1;
            int right = index * 2 + 2;
            int smaller = index;
            while (left < heapSize) {
                //越往下 数越大  比较index left right 对应的三个数 谁最小，如果最小的数时index那么不交换，如果最小的数时left,right 就交换
                if (arr[index] > arr[left]) {
                    smaller = left;
                }
                if (right < heapSize && arr[right] < arr[smaller]) {
                    smaller = right;
                }
                if (smaller != index) {
                    swap(arr, smaller, index);
                } else {
                    break;
                }
                index = smaller;
                left = index * 2 + 1;
                right = index * 2 + 2;
            }
        }

        private void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }


        //通过partition 来分割，获取当前数

        private int[] partition(int[] arr, int left, int right) {
            int target = arr[left];
            int less = left, more = right;
            int i = left + 1;
            while (i <= more) {
                if (arr[i] < target) {
                    swap(arr, ++less, i++);
                } else if (arr[i] == arr[less]) {
                    i++;
                } else {
                    swap(arr, more--, i);
                }
            }
            swap(arr, less, left);

            return new int[]{less-1,more+1};
        }

        private int partition1(int[] arr, int left, int right) {
            int target = arr[left];
            int less = left, more = right;
            int i = left + 1;
            while (i <= more) {
                if (arr[i] < target) {
                    swap(arr, ++less, i++);
                } else if (arr[i] == arr[less]) {
                    i++;
                } else {
                    swap(arr, more--, i);
                }
            }
            swap(arr, less, left);
            return (less+more)/2;
        }

        private int[] partition3(int[] arr, int left, int right) {
            int target = arr[left];
            int less = left, more = right;
            int i = left + 1;
            while (i <= more) {
                if (arr[i] <= target) {
                    swap(arr, ++less, i++);
                } else {
                    swap(arr, more--, i);
                }
            }
            swap(arr, less, left);

            return new int[]{less-1,more+1};
        }

        public  void sort3(int[] a,int left,int right){
            if(left>=right){
                return;
            }
            int[] index= partition3(a,left,right);
            sort3(a,left,index[0]);
            sort3(a,index[1],right);
        }

        public  void sort3(int[] a){
            if(a==null|| a.length<=1){
                return;
            }
            int left=0,right=a.length-1;
            sort3(a,left,right);
        }

        //第k大的元素 实际下标号是 len-k;
        public int findKthLargest(int[] nums, int k) {
            int left = 0;
            int right = nums.length - 1;

            return findKth(nums, left, right, k);
        }

        private int findKth(int[] arr, int left, int right, int k) {
            if (left > right) {
                return -1;
            }
            int len = arr.length;
            int index = partition1(arr, left, right);
            if (index == len - k) {
                return arr[index];
            } else if (index > len - k) {
                return findKth(arr, left, index - 1, k);
            } else {
                return findKth(arr, index + 1, right, k);
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
