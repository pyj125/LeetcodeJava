package leetcode.editor.cn.slidwindow_hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lc187 {
    /**
     * 分析：滑动窗口 + hash  =  滚动hash
     * 求取不重复子串，需要记录子串及其出现的次数，
     * 按暴力的方法是从每个位置开始遍历10个字符，然后记录并统计频率 但是这个过程中会有很多重复的操作，比如第0到第9个字符记作s1,第1到第10个字符记作s2,它们中间的9个字符都是相同的，
     * 但是我们简单的for循环的话都要重新处理一遍
     * 使用滑动窗口可以减少一些冗余的操作。
     * 滑动窗口的分类：固定滑动窗口 和 动态的滑动窗口
     * 其核心问题是要在窗口滑动的过程中维持这个窗口的数据状态，要保持一致
     * 窗口的数据状态：窗口内的字符种类，及各个字符对应的数量,因此可以使用一个HashMap来维护，其key为字符，value为该字符出现的次数
     * 窗口的更新：左边减少一个字符，右边增加一个字符 左边减少的字符需要在map中将其次数减1，右边增加的字符需要加1
     */

    //编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
    public List<String> findRepeatedDnaSequences(String s) {
        char[] arr = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int k = 10;
        if (arr.length < k) {
            return null;
        }
        //初始化窗口
        for (int i = 0; i < k; i++) {
            char ch = arr[i];
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        //窗口滑动
        for (int i = k; i < arr.length; i++) {
            char pre = arr[i - k];
            char cur = arr[i];
            int pre_cnt = map.get(pre) - 1;
            int cur_cnt = map.getOrDefault(cur, 0) + 1;
            if (pre == 0) {
                map.remove(pre);
            } else {
                map.put(pre, pre_cnt);
            }
            map.put(cur, cur_cnt);
        }


        return null;
    }


    public List<String> findRepeatedDnaSequences1(String s) {
        List<String> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i + 10 <= s.length(); i++) {
            String t = s.substring(i, i + 10);
            int cnt = map.getOrDefault(t, 0) + 1;
            if (cnt == 2) {
                res.add(t);
            }
        }
        return res;
    }


}
