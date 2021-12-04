package history;

import java.util.List;

class Solution {

    public String getPermutation(int n, int k) {
        char[] ch = new char[n];
        for (int i = 0; i < n; i++) {
            ch[i] = (char) (48 + i + 1);
        }
        boolean[] visit = new boolean[n];
        dfs(visit, ch, k, "");
        System.out.println(ans);
        return ans;
    }

    // 输入数组 第k个数 当前的位置第几个数 当前的字符串
    public void getPermutation(char[] ch, int index, int k, List<String> list) {
        if (index == ch.length) {
            String cur = new String(ch);
            list.add(cur);
        }
        for (int i = index; i < ch.length; i++) {
            swap(ch, i, index);
            getPermutation(ch, index + 1, k, list);
            swap(ch, i, index);
        }
    }

    private void swap(char[] ch, int i, int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }

    int curNum = 1;
    String ans = "";

    public void dfs(boolean[] visit, char[] ch, int k, String temp) {
        if (!ans.equals("")) {
            return;
        }
        if (temp.length() == ch.length) {
            if (curNum == k) {
                ans = temp;
            } else {
                curNum++;
            }
            return;
        }
        // 这里就是按照从小到大的顺序来排列 便利的
        for (int i = 0; i < ch.length; i++) {
            if (visit[i]) {
                continue;
            }
            visit[i] = true;
            temp = temp + ch[i];
            dfs(visit, ch, k, temp);
            visit[i] = false;
            //去掉一位 字符
            temp = temp.substring(0, temp.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.getPermutation(4, 9);
        System.out.println("------");
        System.out.println(s);
    }



}