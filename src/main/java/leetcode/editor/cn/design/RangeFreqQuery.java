package leetcode.editor.cn.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RangeFreqQuery {
    HashMap<Integer, List<Integer>> map;
//    HashMap<Integer, Integer> numMap;


    public RangeFreqQuery(int[] arr) {
        map = new HashMap<>();
//        numMap = new HashMap<>();
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int num = arr[i];
            if (map.containsKey(num)) {
                map.get(num).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(num, list);
            }
//            numMap.put(Integer.valueOf(i),num);
        }
    }

    public int query(int left, int right, int value) {

        if (!map.containsKey(value)) {
            return 0;
        }
        List<Integer> list = map.get(value);
        if (right < list.get(0) || left>list.get(list.size()-1)) {
            return 0;
        }
        //二分查找
        int low = binarySearch1(list, left);
        int high = binarySearch2(list, right);

        return high - low + 1;
    }

    //二分查找第一个大于等于target的数
    private int binarySearch1(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                if (mid - 1 >= 0 && list.get(mid - 1) >= target) {
                    right = mid - 1;
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }

    //二分查找最后一个小于等于target的数
    private int binarySearch2(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) <= target) {
                if (mid + 1 <= list.size() - 1 && list.get(mid + 1) <= target) {
                    left = mid + 1;
                } else {
                    return mid;
                }
            } else {
                right = mid - 1;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{8, 4, 2, 5, 4, 5, 8, 6, 2, 3};
        RangeFreqQuery rangeFreqQuery = new RangeFreqQuery(arr);
        int a = rangeFreqQuery.query(6, 8, 4); // 返回 1 。4 在子数组 [33, 4] 中出现 1 次。
//        int b = rangeFreqQuery.query(0, 11, 33); // 返回 2 。33 在整个子数组中出现 2 次。
        System.out.println(a);
//        System.out.println(b);
    }

}
