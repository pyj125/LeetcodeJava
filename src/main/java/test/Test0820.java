package test;

import java.util.ArrayList;
import java.util.List;

public class Test0820 {

    public static void main(String[] args) {
        Test0820 a = new Test0820();
        String s = "101023";
        List<String> res = a.restoreIpAddresses(s);
        System.out.println(res);


    }

    List<List<String>> list = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() > 12 || s.length() < 4) {
            return res;
        }
        dfs(s, 0, 0, new ArrayList());
        for (int i = 0; i < list.size(); i++) {
            List<String> tmp = list.get(i);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < tmp.size(); j++) {
                if (j != tmp.size() - 1) {
                    sb.append(tmp.get(j));
                    sb.append(".");
                } else {
                    sb.append(tmp.get(j));
                }
            }
            res.add(sb.toString());
        }
        return res;
    }

    void dfs(String s, int part, int index, List<String> curList) {
        if (part >= 4 || index>= s.length()) {
            // 把当前的字符串刚好分成了4份
            if (part == 4 && s.length()==index) {
                list.add(new ArrayList<>(curList));
            }
            return;
        }

        for (int i = 1; index + i <= s.length() && i <= 3; i++) {
            //当前选择的字符串 选择1位，2位，3位
            String a = s.substring(index, index + i);
            //校验字符串
            if (isValid(a)) {
                curList.add(a);
                dfs(s, part + 1, index + i, curList);
                curList.remove(curList.size() - 1);
            }
        }

    }

    boolean isValid(String s) {
        char[] arr = s.toCharArray();
        //如果数字长度大于1，且第一位为0 false
        if (arr.length > 1 && arr[0] == '0') {
            return false;
        }
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            num = 10 * num + arr[i] - '0';
        }
        if (num > 255) {
            return false;
        }
        return true;

    }


}
