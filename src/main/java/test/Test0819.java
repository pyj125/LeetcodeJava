package test;

public class Test0819 {

    public static void main(String[] args) {
        int[] a = new int[]{1,3,4,5,5,7,9,10};
        int res = binarySearch(a,10);
        System.out.println(res);

    }

    public static int binarySearch(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (num == arr[mid]) {
                return mid;
            } else if (arr[mid] > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
